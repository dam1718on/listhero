package com.example.listhero.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Patterns;
import android.widget.EditText;

import com.example.listhero.R;
import com.example.listhero.datapersistence.DataBase;

import static com.example.listhero.datapersistence.Tables.BuildUser.*;

import java.util.regex.Pattern;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class SignInUp {

    private boolean areEtValidated;
    private boolean isUserRegistered;

    private final Context context;
    private final EditText etNameUser, etEmail, etPass;

    private DataBase dataBase;
    private SQLiteDatabase sqlite;

    public SignInUp(Context context, EditText etNameUser, EditText etEmail, EditText etPass) {

        this.context = context;
        this.etNameUser = etNameUser;
        this.etEmail = etEmail;
        this.etPass = etPass;
    }

    public boolean areEtValidated() {

        validateEditText();
        return areEtValidated;
    }

    public boolean isUserRegistered() {

        receiveUser();
        return isUserRegistered;
    }

    private void validateEditText() {

        //4 minimum characters for nameUser OR valid email OR 6 minimum characters for passUser
        if(etNameUser.getText().length() < 4 || validateEmail(etEmail) || etPass.getText().length() < 6) {

            if(etNameUser.getText().length() < 4) {

                etNameUser.setError(etNameUser.getHint() + context.getString(R.string.minEditText));
            }

            if(validateEmail(etEmail)) {

                etEmail.setError(context.getString(R.string.emailInvalid));
            }

            if(etPass.getText().length() <6) {

                etPass.setError(etPass.getHint() + context.getString(R.string.minEditText));
            }

            areEtValidated = false;

        } else {  areEtValidated = true;  }
    }

    private boolean validateEmail(EditText email) {

        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return !pattern.matcher(email.getText().toString()).matches();
    }

    private void receiveUser() {

        dataBase = new DataBase(context);
        sqlite = dataBase.getReadableDatabase();

        String[] columns = {_idUser, COLUMN_NAME_nameUser, COLUMN_NAME_EMAIL, COLUMN_NAME_passUser};
        String userSQL = COLUMN_NAME_EMAIL + " LIKE '" + etEmail.getText().toString() + "'";
        String order = COLUMN_NAME_EMAIL + " DESC";

        Cursor cursor = sqlite.query(TABLE_NAME, columns, userSQL,null, null,null, order);

        //Is empty the Cursor?
        if (cursor.getCount() != 0) {

            cursor.moveToFirst();
            etEmail.setError(etEmail.getHint()+" "+context.getString(R.string.emailUsed));
            isUserRegistered = true;
        } else {  isUserRegistered = false;  }

        cursor.close();
        sqlite.close();
        dataBase.close();
    }

    public void registerUser() {

        dataBase = new DataBase(context);
        sqlite = dataBase.getWritableDatabase();

        String bcryptHashString = BCrypt.withDefaults().hashToString(10,
            etPass.getText().toString().toCharArray());

        ContentValues content = new ContentValues();

        content.put(COLUMN_NAME_nameUser, etNameUser.getText().toString());
        content.put(COLUMN_NAME_EMAIL, etEmail.getText().toString());
        content.put(COLUMN_NAME_passUser, bcryptHashString);

        sqlite.insert(TABLE_NAME, null, content);

        sqlite.close();
        dataBase.close();

        new EditedToast(context, "Sign up successful");

        etNameUser.setText("");
        etEmail.setText("");
        etPass.setText("");
    }

}