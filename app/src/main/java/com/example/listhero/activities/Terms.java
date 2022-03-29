package com.example.listhero.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.listhero.R;
import com.example.listhero.utils.EditedToast;

public class Terms extends AppCompatActivity {

    EditedToast editedToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        //Read
        Button button5 = findViewById(R.id.btnRead);
        //OnClickListener that make an intent with a Edited Toast
        button5.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Signup.class);
            startActivity(intent);
            editedToast = new EditedToast(getApplicationContext(), getString(R.string.btnSignup));

        });

    }

}