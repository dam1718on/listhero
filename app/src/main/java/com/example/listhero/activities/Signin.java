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
import com.example.listhero.utils.EditedToast;

public class Signin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        EditText etEmailIn = findViewById(R.id.etEmailIn);
        EditText etPassIn = findViewById(R.id.etPassIn);

        CheckBox cbLogged = findViewById(R.id.cbLogged);

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

        });

    }

}