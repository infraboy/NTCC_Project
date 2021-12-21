package com.example.ntccproject;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Home_Page extends AppCompatActivity {

    private SharedPreferences account;
    private Set<String> accDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle("Home Page");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        account = getSharedPreferences("Accounts", MODE_PRIVATE);
        String username = account.getString("LoggedIn", "0\n").split("\n")[1];
        accDetails = account.getStringSet(username, new HashSet<String>());
        Map<String, String> details = new HashMap<>();
        for (String item:accDetails) {
            String[] items = item.split("\n");
            details.put(items[0], items[1]);
        }
        TextView welcomeMsg = findViewById(R.id.welcomeMsg);
        welcomeMsg.setText("WELCOME, " + details.get("name"));
        if (details.get("payment").equals("1")) {
            TextView fees = findViewById(R.id.fees);
            fees.setText("Fees Paid");
            Button payFees = findViewById(R.id.payFees);
            payFees.setEnabled(false);
            payFees.setBackgroundColor(Color.GRAY);
            payFees.setTextColor(Color.DKGRAY);
        }
        if (Integer.parseInt(details.get("dbms")) >= -4 && Integer.parseInt(details.get("dbms")) != -1) {
            TextView dbms = findViewById(R.id.dbms);
            dbms.setText(details.get("dbms") + "/6");
            Button dbmsButton = findViewById(R.id.dbmsButton);
            dbmsButton.setEnabled(false);
            dbmsButton.setBackgroundColor(Color.GRAY);
            dbmsButton.setTextColor(Color.DKGRAY);
        }
        if (Integer.parseInt(details.get("it307")) >= -4 && Integer.parseInt(details.get("it307")) != -1) {
            TextView it307 = findViewById(R.id.it307);
            it307.setText(details.get("it307") + "/6");
            Button it307Button = findViewById(R.id.it307Button);
            it307Button.setEnabled(false);
            it307Button.setBackgroundColor(Color.GRAY);
            it307Button.setTextColor(Color.DKGRAY);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.logout) {
            SharedPreferences.Editor editor = account.edit();
            editor.putString("LoggedIn", "0\n");
            editor.commit();
            Toast.makeText(getApplicationContext(), "Signed Out", Toast.LENGTH_LONG).show();
            Intent i = new Intent(Home_Page.this, MainActivity.class);
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void pay(View view) {
        Intent i = new Intent(Home_Page.this, FeePayment.class);
        startActivity(i);
        finish();
    }

    public void dbms(View view) {
        Intent i = new Intent(Home_Page.this, Exam_DBMS.class);
        startActivity(i);
        finish();
    }

    public void it307(View view) {
        Intent i = new Intent(Home_Page.this, Exam_IT307.class);
        startActivity(i);
        finish();
    }
}