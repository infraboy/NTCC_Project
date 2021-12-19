package com.example.ntccproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ForgotPassword extends AppCompatActivity {

    private EditText username, question, password, confirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        username = findViewById(R.id.username);
        question = findViewById(R.id.question);
        password = findViewById(R.id.password);
        confirmPass = findViewById(R.id.confirmPass);
    }

    public void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    private boolean validate() {
        if (question.getText().toString().isEmpty() || username.getText().toString().isEmpty() || password.getText().toString().isEmpty() || confirmPass.getText().toString().isEmpty()) {
            showToast("Field(s) cannot be empty");
            return false;
        }
        if (!password.getText().toString().equals(confirmPass.getText().toString())) {
            showToast("Passwords do not match!!");
            return false;
        }
        return true;
    }

    public void reset(View view) {
        if (!validate())
            return;
        SharedPreferences sharedPreferences = getSharedPreferences("Accounts", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> accDetails = sharedPreferences.getStringSet(username.getText().toString(), new HashSet<>());
        Map<String, String> details = new HashMap<>();
        for (String item:accDetails) {
            String[] items = item.split("\n");
            details.put(items[0], items[1]);
        }
        if (!details.get("question").equals(question.getText().toString())) {
            showToast("Wrong answer");
            return;
        }
        accDetails.remove("password\n" + details.get("password"));
        accDetails.add("password\n" + password.getText().toString());
        editor.putStringSet(username.getText().toString(), accDetails);
        editor.commit();
        showToast("Password has been reset");
        Intent i = new Intent(ForgotPassword.this, MainActivity.class);
        startActivity(i);
        finish();
    }

    public void goToSignIn(View view) {
        Intent i = new Intent(ForgotPassword.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}