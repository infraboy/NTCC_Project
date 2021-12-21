package com.example.ntccproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class CreateAccount extends AppCompatActivity {

    private EditText name, email, username, password, confirmPass, question;

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
        question = findViewById(R.id.question);
    }

    public void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    private boolean validate() {
        if (question.getText().toString().isEmpty() || name.getText().toString().isEmpty() || email.getText().toString().isEmpty() || username.getText().toString().isEmpty() || password.getText().toString().isEmpty() || confirmPass.getText().toString().isEmpty()) {
            showToast("Field(s) cannot be empty");
            return false;
        }
        if (!password.getText().toString().equals(confirmPass.getText().toString())) {
            showToast("Passwords do not match!!");
            return false;
        }
        return true;
    }

    public void signUp(View view) {
        if (!validate())
            return;
        SharedPreferences sharedPreferences = getSharedPreferences("Accounts", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> accDetails = sharedPreferences.getStringSet(username.getText().toString(), new HashSet<String>());
        if (!accDetails.isEmpty())
        {
            showToast("Username already exists, please enter a different username");
            return;
        }
        accDetails.add("password\n" + password.getText().toString());
        accDetails.add("name\n" + name.getText().toString());
        accDetails.add("email\n" + email.getText().toString());
        accDetails.add("question\n" + question.getText().toString());
        accDetails.add("payment\n0");
        accDetails.add("dbms\n-1");
        accDetails.add("it307\n-1");
        editor.putStringSet(username.getText().toString(), accDetails);
        editor.commit();
        showToast("Account Created");
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