package com.cullados.cullados_activity5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //declared here so i can access in all btn
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //declare variables here
        Button btn_1, btn_2, btn_3, btn_4, btn_5;
        EditText playerName_Input, question1_Input, question2_Input, question3_Input, question4_Input, question5_Input;

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //connect java var to xml id here
        btn_1 = findViewById(R.id.btn1);
        btn_2 = findViewById(R.id.btn2);
        btn_3 = findViewById(R.id.btn3);
        btn_4 = findViewById(R.id.btn4);
        btn_5 = findViewById(R.id.btn5);
        playerName_Input = findViewById(R.id.playerNameInput);
        question1_Input = findViewById(R.id.question1Input);
        question2_Input = findViewById(R.id.question2Input);
        question3_Input = findViewById(R.id.question3Input);
        question4_Input = findViewById(R.id.question4Input);
        question5_Input = findViewById(R.id.question5Input);

        //add button action here

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //added toString() cuz I cant compare tje 2 string, idk why yet,,,
                String answer = question1_Input.getText().toString();

                if (answer.equalsIgnoreCase("Mango")){
                    //calls a method with toast
                    correctMessage();
                    //increment so counted and score
                    count++;
                    //so they cant click it again, if they clicked it again and again, it can make the score higher
                    btn_1.setEnabled(false);
                } else {
                    wrongMessage();
                }
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = question2_Input.getText().toString();

                if (answer.equalsIgnoreCase("Skin")){
                    correctMessage();
                    count++;
                    btn_2.setEnabled(false);
                } else {
                    wrongMessage();
                }
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = question3_Input.getText().toString();

                if (answer.equalsIgnoreCase("Manila")){
                    correctMessage();
                    count++;
                    btn_3.setEnabled(false);
                } else {
                    wrongMessage();
                }
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = question4_Input.getText().toString();

                if (answer.equalsIgnoreCase("7")){
                    correctMessage();
                    count++;
                    btn_4.setEnabled(false);
                } else {
                    wrongMessage();
                }
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = question5_Input.getText().toString();
                String playerName = playerName_Input.getText().toString();

                if (answer.equalsIgnoreCase("Sun")){
                    correctMessage();
                    count++;
                    btn_5.setEnabled(false);
                } else {
                    wrongMessage();
                }
                //calling final method, showing anme, score, and percentage
                finalMessage(count, playerName);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    //put method here
    //pagmali answer
    public void wrongMessage(){
        Toast.makeText(MainActivity.this, "Wrong Answer :[", Toast.LENGTH_SHORT).show();
    }
    //pagtama answer
    public void correctMessage(){
        Toast.makeText(MainActivity.this, "Correct Answer! :]", Toast.LENGTH_SHORT).show();
    }

    public void finalMessage(int score, String name){
        double avg;
        double perc;
        //computation fro the percentage
        avg = (double) count / 5;
        perc = avg * 100;

        //if statement if bagsak or not
        if (score > 2){
            Toast.makeText(MainActivity.this, "Congrats! " + name + "!\nYour score is: " + score + "/5 = " + perc + "%", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "Nice Try! " + name + "!\nYour score is: " + score + "/5 = " + perc + "%", Toast.LENGTH_LONG).show();
        }
    }


} //class ending