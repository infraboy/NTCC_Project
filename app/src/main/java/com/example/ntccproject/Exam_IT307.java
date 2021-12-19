package com.example.ntccproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class Exam_IT307 extends AppCompatActivity {

    private TextView Question;
    private RadioButton A;
    private RadioButton B;
    private RadioButton C;
    private RadioButton D;
    private Button Submit;
    private TextView Result;
    private TextView Correct;
    private int score = 0;
    private int count = 1;
    private Button Clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_it307);
        Question = findViewById(R.id.Question);
        A = findViewById(R.id.A);
        B = findViewById(R.id.B);
        C = findViewById(R.id.C);
        D = findViewById(R.id.D);
        Submit = findViewById(R.id.Submit);
        Result = findViewById(R.id.Result);
        Correct = findViewById(R.id.Correct);
        Clear = findViewById(R.id.Clear);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count ==1)
                {
                    boolean Ans_A = A.isChecked();
                    boolean Ans_B = B.isChecked();
                    boolean Ans_C = C.isChecked();
                    boolean Ans_D = D.isChecked();
                    Submit.setText("Next");
                    if (Ans_A==true && Ans_B==false && Ans_C == false && Ans_D==false)
                    {
                        score=score+2;
                        Toast.makeText(Exam_IT307.this, "Correct Answer!!", Toast.LENGTH_LONG).show();
                        Result.setText("SCORE: "+score+"/6");
                        Correct.setText("Because of the growth of the Internet and the depletion of available IPV4 address, a new version of IP(IPV6), using 128 nits for the IP address, was developed in 1995, and standardized as RFC 2460 in 1998. IPV6 deployment has been ongoing since the mid 2000s. Hence the correct answer is A.");
                    }
                    else
                    {
                        score=score-1;
                        Toast.makeText(Exam_IT307.this, "Wrong Answer!!", Toast.LENGTH_LONG).show();
                        Result.setText("SCORE: "+score+"/6");
                        Correct.setText("Because of the growth of the Internet and the depletion of available IPV4 address, a new version of IP(IPV6), using 128 nits for the IP address, was developed in 1995, and standardized as RFC 2460 in 1998. IPV6 deployment has been ongoing since the mid 2000s. Hence the correct answer is A.");
                    }
                    count++;
                }
                else if (count==2)
                {
                    A.setChecked(false);
                    B.setChecked(false);
                    C.setChecked(false);
                    D.setChecked(false);
                    Question.setText("Q2. Which of the below is consider as (a) signal transmission medium is data communications?");
                    A.setText("A) Fiber optics");
                    B.setText("B) Microwaves and Satellite Signals");
                    C.setText("C) Repeaters");
                    D.setText("D) Twisted pair cables");
                    Submit.setText("SUBMIT");
                    Correct.setText("");
                    count++;
                }
                else if (count ==3)
                {
                    boolean Ans_A = A.isChecked();
                    boolean Ans_B = B.isChecked();
                    boolean Ans_C = C.isChecked();
                    boolean Ans_D = D.isChecked();
                    Submit.setText("Next");
                    if (Ans_A==true && Ans_B==true && Ans_C == false && Ans_D==true)
                    {
                        score=score+2;
                        Toast.makeText(Exam_IT307.this, "Correct Answer!!", Toast.LENGTH_LONG).show();
                        Result.setText("SCORE: "+score+"/6");
                        Correct.setText("Correct Answer: Option A, B and D.");
                    }
                    else
                    {
                        score=score-1;
                        Toast.makeText(Exam_IT307.this, "Wrong Answer!!", Toast.LENGTH_LONG).show();
                        Result.setText("SCORE: "+score+"/6");
                        Correct.setText("Correct Answer: Option A, B and D.");
                    }
                    count++;
                }
                else if (count==4)
                {
                    A.setChecked(false);
                    B.setChecked(false);
                    C.setChecked(false);
                    D.setChecked(false);
                    Question.setText("Q3. Which of the following IP addresses can be used as (a) loop-back addresses?");
                    A.setText("A) 0.0.0.0");
                    B.setText("B) 255.255.255.255");
                    C.setText("C) 127.0.0.1");
                    D.setText("D) 0.255.255.255");
                    Submit.setText("SUBMIT");
                    Correct.setText("");
                    count++;
                }
                else if (count ==5)
                {
                    boolean Ans_A = A.isChecked();
                    boolean Ans_B = B.isChecked();
                    boolean Ans_C = C.isChecked();
                    boolean Ans_D = D.isChecked();
                    Submit.setText("THANK YOU!! YOUR EXAM IS OVER!!");
                    if (Ans_A==false && Ans_B==false && Ans_C == true && Ans_D==false)
                    {
                        score=score+2;
                        Toast.makeText(Exam_IT307.this, "Correct Answer!!", Toast.LENGTH_LONG).show();
                        Result.setText("YOUR FINAL SCORE IN IT307: "+score+"/6");
                        Correct.setText("A loopback address is a special IP address whose IP address is between 127.0.0.1 to 127.255.255.255. It is reserved for loopback. It doesn't require a physical connection to a network. So the correct answer is C.");
                    }
                    else
                    {
                        score=score-1;
                        Toast.makeText(Exam_IT307.this, "Wrong Answer!!", Toast.LENGTH_LONG).show();
                        Result.setText("YOUR FINAL SCORE IN IT307: "+score+"/6");
                        Correct.setText("A loopback address is a special IP address whose IP address is between 127.0.0.1 to 127.255.255.255. It is reserved for loopback. It doesn't require a physical connection to a network. So the correct answer is C.");
                    }
                    count++;
                }
                else
                {
                    SharedPreferences account = getSharedPreferences("Accounts", MODE_PRIVATE);
                    String username = account.getString("LoggedIn", "0\n").split("\n")[1];
                    Set<String> accDetails = account.getStringSet(username, new HashSet<String>());
                    accDetails.remove("it307\n-1");
                    accDetails.add("it307\n" + score);
                    SharedPreferences.Editor editor = account.edit();
                    editor.putStringSet(username, accDetails);
                    editor.commit();
                    Toast.makeText(Exam_IT307.this, "THANK YOU!! YOUR EXAM IS OVER!! \n YOUR FINAL SCORE IN IT307: "+score+"/6", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Exam_IT307.this, Home_Page.class);
                    startActivity(i);
                    finish();
                }

            }
        });

    }

    public void Clear (View view) {
        Toast.makeText(getApplicationContext(), "Selections Cleared!!", Toast.LENGTH_LONG).show();
        A.setChecked(false);
        B.setChecked(false);
        C.setChecked(false);
        D.setChecked(false);
    }
}