package com.example.ntccproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private CheckBox showPass;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        showPass = findViewById(R.id.showPass);
        pass = findViewById(R.id.p);
        pass.getInputType();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createAccount(View view) {
        Intent i = new Intent(MainActivity.this, CreateAccount.class);
        startActivity(i);
        finish();
    }

    public void showPassword(View view) {
        pass.setInputType(showPass.isChecked() ? EditorInfo.TYPE_CLASS_TEXT : EditorInfo.TYPE_TEXT_VARIATION_PASSWORD);
    }
}