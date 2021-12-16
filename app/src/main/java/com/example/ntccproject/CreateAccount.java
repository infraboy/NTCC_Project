package com.example.ntccproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreateAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }

    public void signIn(View view) {
        Intent i = new Intent(CreateAccount.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}