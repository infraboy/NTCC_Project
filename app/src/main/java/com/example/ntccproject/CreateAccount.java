package com.example.ntccproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.HashSet;
import java.util.Set;

public class CreateAccount extends AppCompatActivity {

    private EditText name, email, username, password, confirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirmPass = findViewById(R.id.confirmPass);
    }

    public void signUp(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("Accounts", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> accDetails = new HashSet<String>();
        accDetails.add("password\n" + password.getText().toString());
        accDetails.add("name\n" + name.getText().toString());
        accDetails.add("email\n" + email.getText().toString());
        editor.putStringSet(username.getText().toString(), accDetails);
        editor.commit();
        Intent i = new Intent(CreateAccount.this, MainActivity.class);
        startActivity(i);
        finish();
    }

    public void goToSignIn(View view) {
        Intent i = new Intent(CreateAccount.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}