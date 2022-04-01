package com.example.listhero.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.listhero.R;
import com.example.listhero.objects.User;

public class Main extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvUserPushed = findViewById(R.id.tvUserPushed);

        //User received from Sign in
        final User userSignin = (User) getIntent().getSerializableExtra("user");

        tvUserPushed.setText(userSignin.getIdUser() + ", " + userSignin.getNameUser() + ", " +
            userSignin.getEmail() + ", " + userSignin.getPassUser() + ".");

    }

}