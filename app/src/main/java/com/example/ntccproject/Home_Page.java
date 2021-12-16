package com.example.ntccproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Home_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle("Home Page");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void signOut(View view) {
        Toast.makeText(getApplicationContext(), "Signed Out", Toast.LENGTH_LONG).show();
        Intent i = new Intent(Home_Page.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}