package com.example.quizproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
 Button btnWeb,btnSo,btnDez;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnWeb=findViewById(R.id.btnWeb);
        btnSo=findViewById(R.id.btnSo);
        btnDez=findViewById(R.id.btnDez);

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),WebActivity.class);
                startActivity(intent);
            }
        });

        btnSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),SoActivity.class);
                startActivity(intent);
            }
        });


        btnDez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),DamActivity.class);
                startActivity(intent);
            }
        });

    }
}