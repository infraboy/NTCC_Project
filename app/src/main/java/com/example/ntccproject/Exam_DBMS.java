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

public class Exam_DBMS extends AppCompatActivity {

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
        setContentView(R.layout.activity_exam_dbms);
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
                    if (Ans_A==false && Ans_B==false && Ans_C == false && Ans_D==true)
                    {
                        score=score+2;
                        Toast.makeText(Exam_DBMS.this, "Correct Answer!!", Toast.LENGTH_LONG).show();
                        Result.setText("SCORE: "+score+"/6");
                        Correct.setText("The term \"DDL\" stands for Data Definition Language, used to perform all other essential tasks such as deleting relation and related schemas in defining the structure relation. So, the correct answer is D.");
                    }
                    else
                    {
                        score=score-1;
                        Toast.makeText(Exam_DBMS.this, "Wrong Answer!!", Toast.LENGTH_LONG).show();
                        Result.setText("SCORE: "+score+"/6");
                        Correct.setText("The term \"DDL\" stands for Data Definition Language, used to perform all other essential tasks such as deleting relation and related schemas in defining the structure relation. So, the correct answer is D.");
                    }
                    count++;
                }
                else if (count==2)
                {
                    A.setChecked(false);
                    B.setChecked(false);
                    C.setChecked(false);
                    D.setChecked(false);
                    Question.setText("Q2. Which one of the following given statements possibly contains the error?");
                    A.setText("A) select * from emp where empid = 10003;");
                    B.setText("B) select empid from emp where empid = 10006;");
                    C.setText("C) select empid from emp;");
                    D.setText("D) select empid where empid = 1009 and Lastname = 'GELLER';");
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
                    if (Ans_A==false && Ans_B==false && Ans_C == false && Ans_D==true)
                    {
                        score=score+2;
                        Toast.makeText(Exam_DBMS.this, "Correct Answer!!", Toast.LENGTH_LONG).show();
                        Result.setText("SCORE: "+score+"/6");
                        Correct.setText("The Query given in option D does not contain the \"from\" clause, which specifies the relation from which the values have to be selected or fetched. Therefore the correct answer is D.");
                    }
                    else
                    {
                        score=score-1;
                        Toast.makeText(Exam_DBMS.this, "Wrong Answer!!", Toast.LENGTH_LONG).show();
                        Result.setText("SCORE: "+score+"/6");
                        Correct.setText("The Query given in option D does not contain the \"from\" clause, which specifies the relation from which the values have to be selected or fetched. Therefore the correct answer is D.");
                    }
                    count++;
                }
                else if (count==4)
                {
                    A.setChecked(false);
                    B.setChecked(false);
                    C.setChecked(false);
                    D.setChecked(false);
                    Question.setText("Q3. What do you mean by one to many relationships?");
                    A.setText("A) One class may have many teachers");
                    B.setText("B) One teacher can have many classes");
                    C.setText("C) Many classes may have many teachers");
                    D.setText("D) Many teachers may have many classes");
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
                    if (Ans_A==false && Ans_B==true && Ans_C == false && Ans_D==false)
                    {
                        score=score+2;
                        Toast.makeText(Exam_DBMS.this, "Correct Answer!!", Toast.LENGTH_LONG).show();
                        Result.setText("YOUR FINAL SCORE IN DBMS: "+score+"/6");
                        Correct.setText("We can understand the \"one to many\" relationship as a teacher who may have more than one class to attend. So, the correct answer is B.");
                    }
                    else
                    {
                        score=score-1;
                        Toast.makeText(Exam_DBMS.this, "Wrong Answer!!", Toast.LENGTH_LONG).show();
                        Result.setText("YOUR FINAL SCORE IN DBMS: "+score+"/6");
                        Correct.setText("We can understand the \"one to many\" relationship as a teacher who may have more than one class to attend. So, the correct answer is B.");
                    }
                    count++;
                }
                else
                {
                    SharedPreferences account = getSharedPreferences("Accounts", MODE_PRIVATE);
                    String username = account.getString("LoggedIn", "0\n").split("\n")[1];
                    Set<String> accDetails = account.getStringSet(username, new HashSet<String>());
                    accDetails.remove("dbms\n-1");
                    accDetails.add("dbms\n" + score);
                    SharedPreferences.Editor editor = account.edit();
                    editor.putStringSet(username, accDetails);
                    editor.commit();
                    Toast.makeText(Exam_DBMS.this, "THANK YOU!! YOUR EXAM IS OVER!! \n YOUR FINAL SCORE IN DBMS: "+score+"/6", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Exam_DBMS.this, Home_Page.class);
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