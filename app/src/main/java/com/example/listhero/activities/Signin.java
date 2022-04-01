package com.example.listhero.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.listhero.R;
import com.example.listhero.objects.User;
import com.example.listhero.utils.EditedToast;
import com.example.listhero.utils.SignInUp;

public class Signin extends AppCompatActivity {

    private SignInUp signInUp;
    //Remember credentials variables
    String emailSP;
    String passSP;
    boolean cbSP;
    private SharedPreferences mySharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        EditText etEmailIn = findViewById(R.id.etEmailIn);
        EditText etPassIn = findViewById(R.id.etPassIn);

        //Remember credentials
        CheckBox cbRemember = findViewById(R.id.cbRemember);
        //Shared Preferences data persistence
        mySharedPref = getSharedPreferences("data", Context.MODE_PRIVATE);
        String emailET = mySharedPref.getString("email", emailSP);
        String passET = mySharedPref.getString("pass", passSP);
        boolean cbET = mySharedPref.getBoolean("cb", cbSP);
        //Output
        etEmailIn.setText(emailET);
        etPassIn.setText(passET);
        cbRemember.setChecked(cbET);

        //Forgot password
        TextView tvForgotPass = findViewById(R.id.tvForgotPass);
        //Make linkable Forgot password TextView
        SpannableString contentC = new SpannableString(tvForgotPass.getText());
        tvForgotPass.setText(contentC);
        tvForgotPass.setOnClickListener(v -> {

        });

        //Create Account
        Button btnCreate = findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(view -> {

            Intent intent = new Intent(getApplicationContext(), Signup.class);
            startActivity(intent);
            new EditedToast(getApplicationContext(), getString(R.string.btnSignup));
        });

        //Sign in
        Button btnSignin = findViewById(R.id.btnSignin);
        btnSignin.setOnClickListener(view -> {

            signInUp = new SignInUp(getApplicationContext(), etEmailIn, etPassIn);
            if(signInUp.isUserValidated()) {
                User user = new User(signInUp.getUser());

                if(cbRemember.isChecked()) {

                    mySharedPref = getSharedPreferences("data", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = mySharedPref.edit();
                    editor.putString("email", user.getEmail());
                    editor.putString("pass", etPassIn.getText().toString());
                    editor.putBoolean("cb", true);
                    editor.apply();
                } else {

                    mySharedPref = getSharedPreferences("data", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = mySharedPref.edit();
                    editor.putString("email", "");
                    editor.putString("pass", "");
                    editor.putBoolean("cb", false);
                    editor.apply();

                    etEmailIn.setText("");
                    etPassIn.setText("");
                }
                //Change userPass to decrypted String
                user.setPassUser(etPassIn.getText().toString());
                //user push to .Main
                Intent intent = new Intent(getApplicationContext(), Main.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });

    }

}