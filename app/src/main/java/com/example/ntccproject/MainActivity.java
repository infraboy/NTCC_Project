package com.example.ntccproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private CheckBox showPass;
    private EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showPass = findViewById(R.id.showPass);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        showPass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                password.setInputType(isChecked ? InputType.TYPE_CLASS_TEXT: InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
        });
    }

    public void createAccount(View view) {
        Intent i = new Intent(MainActivity.this, CreateAccount.class);
        startActivity(i);
        finish();
    }

    public void signIn(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("Accounts", MODE_PRIVATE);
        Set<String> accDetails = sharedPreferences.getStringSet(username.getText().toString(), new HashSet<String>());
        if (accDetails.isEmpty()) {
            Toast.makeText(getApplicationContext(),"Username not found!!", Toast.LENGTH_LONG).show();
            return;
        }
        Map<String, String> details = new HashMap<>();
        for (String item:accDetails) {
            String[] items = item.split("\n");
            details.put(items[0], items[1]);
        }
        if (details.get("password").equals(password.getText().toString())) {
            Toast.makeText(getApplicationContext(),"Logged In", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(),"Password is incorrect!!", Toast.LENGTH_LONG).show();
        }
    }
}