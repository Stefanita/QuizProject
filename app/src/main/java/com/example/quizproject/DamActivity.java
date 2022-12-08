package com.example.quizproject;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class DamActivity extends AppCompatActivity implements View.OnClickListener {
     RadioGroup rg1;
    RadioButton raspADam,raspBDam,raspCDam,raspDDam;
    Button btnNextDam;
    TextView tvScorDam,tvIntrebareDam,tvNrINTR;

    int score=0;
    int totalQuestion= IntrebariDam.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dam);

        tvIntrebareDam = findViewById(R.id.tvIntrebareDam);
        tvScorDam = findViewById(R.id.tvScorDam);
        tvNrINTR=findViewById(R.id.tvNrINTR);



        raspADam = findViewById(R.id.btnRaspADam);
        raspBDam = findViewById(R.id.btnRaspBDam);
        raspCDam = findViewById(R.id.btnRaspCDam);
        raspDDam = findViewById(R.id.btnRaspDDam);
        btnNextDam = findViewById(R.id.btnNextDam);
        rg1=findViewById(R.id.rg1);

        raspADam.setOnClickListener(this);
        raspBDam.setOnClickListener(this);
        raspCDam.setOnClickListener(this);
        raspDDam.setOnClickListener(this);
        btnNextDam.setOnClickListener(this);

        tvNrINTR.setText("Total questions : "+totalQuestion);

        loadNewQuestion();


    }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.btnNextDam){
            rg1.clearCheck();
            if(selectedAnswer.equals(IntrebariDam.correctAnswers[currentQuestionIndex])){
                score++;
                tvScorDam.setText("Scor:"+score);

            }
            currentQuestionIndex++;
            loadNewQuestion();


        }else{
            //choices button clicked
            selectedAnswer  = clickedButton.getText().toString();
          //  rg1.clearCheck();

        }

    }

    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion ){
            finishQuiz();
            return;
        }
        else {
            tvIntrebareDam.setText(IntrebariDam.question[currentQuestionIndex]);
            raspADam.setText(IntrebariDam.choices[currentQuestionIndex][0]);
            raspBDam.setText(IntrebariDam.choices[currentQuestionIndex][1]);
            raspCDam.setText(IntrebariDam.choices[currentQuestionIndex][2]);
            raspDDam.setText(IntrebariDam.choices[currentQuestionIndex][3]);
        }
    }

    void finishQuiz(){
        String passStatus = "";
        if(score >totalQuestion*0.60){
            passStatus = "Passed";
            new AlertDialog.Builder(this)
                    .setTitle(passStatus)
                    .setMessage("Score is "+ score +" out of "+ totalQuestion)
                    .setPositiveButton("Home",((dialogInterface, i) ->goHome()))
                    .setCancelable(false)
                    .show();
        }else{
            passStatus = "Failed";
            new AlertDialog.Builder(this)
                    .setTitle(passStatus)
                    .setMessage("Score is "+ score+" out of "+ totalQuestion)
                    .setPositiveButton("Home",(dialogInterface, i) -> goHome() )
                    .setCancelable(false)
                    .show();
        }

    }


    void goHome(){

        Intent intent =new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}