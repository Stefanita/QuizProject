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

public class SoActivity extends AppCompatActivity implements View.OnClickListener {
    RadioButton raspA,raspB,raspC,raspD;
    Button btnNextg;
    TextView tvScor,tvIntrebare,tvNrintr;
    RadioGroup rg2;

    int score=0;
    int totalQuestion= IntrebariSo.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_so);

        tvIntrebare = findViewById(R.id.tvIntrebare);
        tvScor = findViewById(R.id.tvScor);
        tvNrintr=findViewById(R.id.tvNrintr);

        raspA = findViewById(R.id.btnRaspA);
        raspB = findViewById(R.id.btnRaspB);
        raspC = findViewById(R.id.btnRaspD);
        raspD = findViewById(R.id.btnRaspC);
        btnNextg = findViewById(R.id.btnNextg);
        rg2=findViewById(R.id.rg2);

        raspA.setOnClickListener(this);
        raspB.setOnClickListener(this);
        raspC.setOnClickListener(this);
        raspD.setOnClickListener(this);
        btnNextg.setOnClickListener(this);

        tvNrintr.setText("Numar intrebari: "+totalQuestion);
        nextIntrebare();

    }

    @Override
    public void onClick(View view) {

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.btnNextg){
            rg2.clearCheck();
            if(selectedAnswer.equals(IntrebariSo.correctAnswers[currentQuestionIndex])){
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
            tvIntrebare.setText(IntrebariSo.question[currentQuestionIndex]);
            raspA.setText(IntrebariSo.choices[currentQuestionIndex][0]);
            raspB.setText(IntrebariSo.choices[currentQuestionIndex][1]);
            raspC.setText(IntrebariSo.choices[currentQuestionIndex][2]);
            raspD.setText(IntrebariSo.choices[currentQuestionIndex][3]);}
    }

    void terminaTest(){
        String passStatus = "";
        if(score >totalQuestion){
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