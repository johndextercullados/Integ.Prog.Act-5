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
                String answer = question1_Input.getText().toString();

                if (answer.equalsIgnoreCase("Mango")){
                    correctMessage();
                    count++;
                } else {
                    wrongMessage();
                }
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    //put method here
    public void wrongMessage(){
        Toast.makeText(MainActivity.this, "Wrong Answer :[", Toast.LENGTH_SHORT).show();
    }
    public void correctMessage(){
        Toast.makeText(MainActivity.this, "Correct Answer! :]", Toast.LENGTH_SHORT).show();
    }

    public void finalMessage(int score, String name){
        double avg;
        double perc;

        avg = (double) count / 5.00;
        perc = avg * 100;

        if (score > 2){
            Toast.makeText(MainActivity.this, "Congrats! " + name + "\nYour score is: " + score + "/5 = " + perc + "%", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Nice Try! " + name + "\nYour score is: " + score + "/5 = " + perc + "%", Toast.LENGTH_SHORT).show();
        }



    }


} //class ending