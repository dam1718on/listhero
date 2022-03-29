package com.example.listhero.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.listhero.R;
import com.example.listhero.utils.*;

public class Signup extends AppCompatActivity {

    private SignInUp signInUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        EditText etUserUp = findViewById(R.id.etUserUp);
        EditText etEmailUp = findViewById(R.id.etEmailUp);
        EditText etPassUp = findViewById(R.id.etPassUp);

        CheckBox cbTerms = findViewById(R.id.cbTerms);

        //Terms Agreement
        TextView tvTermsLinkable = findViewById(R.id.tvTermsLinkable);
        //Make linkable Terms Agreement TextView
        SpannableString contentC = new SpannableString(tvTermsLinkable.getText());
        tvTermsLinkable.setText(contentC);
        tvTermsLinkable.setOnClickListener(v -> {

            Intent intent = new Intent(getApplicationContext(), Terms.class);
            startActivity(intent);
            new EditedToast(getApplicationContext(), getString(R.string.tvTermsLinkable));
        });

        //Back to Sign in
        Button btnBackSignin = findViewById(R.id.btnBackSignin);
        btnBackSignin.setOnClickListener(view -> {

            Intent intent = new Intent(getApplicationContext(), Signin.class);
            startActivity(intent);
            new EditedToast(getApplicationContext(), getString(R.string.btnSignin));
        });

        //Sign up
        Button btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(view -> {

            signInUp = new SignInUp(getApplicationContext(), etUserUp, etEmailUp, etPassUp);

            if (signInUp.areEtValidated()) {

                if(cbTerms.isChecked()){

                    if(!signInUp.isUserRegistered()) {

                        signInUp.registerUser();
                        cbTerms.setChecked(false);
                    }

                } else {

                    new EditedToast(getApplicationContext(), getString(R.string.cbTermsChecked));
                }
            }
        });

    }

}