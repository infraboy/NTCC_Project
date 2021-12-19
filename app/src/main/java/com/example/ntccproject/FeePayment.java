package com.example.ntccproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FeePayment extends AppCompatActivity {

    private SharedPreferences account;
    private Set<String> accDetails;
    private String username;
    private int radio = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle("Fee Payment");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fee_payment);
        account = getSharedPreferences("Accounts", MODE_PRIVATE);
        username = account.getString("LoggedIn", "0\n").split("\n")[1];
        accDetails = account.getStringSet(username, new HashSet<String>());
        Map<String, String> details = new HashMap<>();
        for (String item:accDetails) {
            String[] items = item.split("\n");
            details.put(items[0], items[1]);
        }
        TextView name = findViewById(R.id.name), email = findViewById(R.id.email);
        name.setText(details.get("name"));
        email.setText(details.get("email"));
        RadioButton paytm = findViewById(R.id.paymentPaytm), netBanking = findViewById(R.id.paymentNetBanking);
        netBanking.toggle();
        paytm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(paytm.isChecked())
                    netBanking.setChecked(false);
            }
        });
        netBanking.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(netBanking.isChecked())
                    paytm.setChecked(false);
            }
        });
    }

    public void pay(View view) {
        accDetails.remove("payment\n0");
        accDetails.add("payment\n1");
        SharedPreferences.Editor editor = account.edit();
        editor.putStringSet(username, accDetails);
        editor.commit();
        Toast.makeText(getApplicationContext(), "Payment Completed", Toast.LENGTH_LONG).show();
        Intent i = new Intent(FeePayment.this, Home_Page.class);
        startActivity(i);
        finish();
    }
}