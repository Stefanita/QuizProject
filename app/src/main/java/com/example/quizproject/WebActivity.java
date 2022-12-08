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

public class WebActivity extends AppCompatActivity implements View.OnClickListener{
    RadioButton raspA,raspB,raspC,raspD;
    Button btnNextWeb;
    TextView tvScor,tvIntrebare,tvNrintrWeb;
    RadioGroup rg;

    int score=0;
    int totalQuestion= IntrebariWeb.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        tvIntrebare = findViewById(R.id.tvIntrebareWeb);
        tvScor = findViewById(R.id.tvScorWeb);
        tvNrintrWeb=findViewById(R.id.tvNrIntrWeb);

        raspA = findViewById(R.id.btnRaspAWeb);
        raspB = findViewById(R.id.btnRaspBWeb);
        raspC = findViewById(R.id.btnRaspDWeb);
        raspD = findViewById(R.id.btnRaspCWeb);
        btnNextWeb = findViewById(R.id.btnNextWeb);

        rg = findViewById(R.id.rg1);

        raspA.setOnClickListener(this);
        raspB.setOnClickListener(this);
        raspC.setOnClickListener(this);
        raspD.setOnClickListener(this);
        btnNextWeb.setOnClickListener(this);

        tvNrintrWeb.setText("Numar intrebari: "+totalQuestion);
        nextIntrebare();

    }

    @Override
    public void onClick(View view) {

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.btnNextWeb){
            rg.clearCheck();
            if(selectedAnswer.equals(IntrebariWeb.correctAnswers[currentQuestionIndex])){
                score++;
                tvScor.setText("Scor:"+score);
            }
            currentQuestionIndex++;
            nextIntrebare();
        }else{
            selectedAnswer  = clickedButton.getText().toString();
        }

    }

    private void nextIntrebare() {

        if(currentQuestionIndex == totalQuestion ){
            terminaTest();
            return;
        }
        else{
            tvIntrebare.setText(IntrebariWeb.question[currentQuestionIndex]);
            raspA.setText(IntrebariWeb.choices[currentQuestionIndex][0]);
            raspB.setText(IntrebariWeb.choices[currentQuestionIndex][1]);
            raspC.setText(IntrebariWeb.choices[currentQuestionIndex][2]);
            raspD.setText(IntrebariWeb.choices[currentQuestionIndex][3]);}
    }

    void terminaTest(){
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