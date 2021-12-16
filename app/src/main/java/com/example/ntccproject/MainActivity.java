package com.example.ntccproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createAccount(View view) {
        Intent i = new Intent(MainActivity.this, CreateAccount.class);
        startActivity(i);
        finish();
    }
}