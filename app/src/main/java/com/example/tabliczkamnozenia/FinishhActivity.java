package com.example.tabliczkamnozenia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.time.Instant;

public class FinishhActivity extends AppCompatActivity {

    private TextView textScore, textProcent;
    private  int tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finishh);

        textProcent = findViewById(R.id.textProcenty);
        textScore =  findViewById(R.id.textOdpowiedzi);

        setLevel();
        showAnswer();
    }

    void setLevel(){
        switch(MyApp.level){
            case 1:
                tasks = 10;
                break;
            case 2:
                tasks = 20;
                break;
            case 3:
                tasks = 30;
                break;
            case 4:
                tasks = 40;
                break;
            case 5:
                tasks = 50;
                break;

        }
    }

    void showAnswer(){
        textScore.setText( MyApp.correct + " / "+ tasks);

        int i = (MyApp.correct*100) / tasks ;
        textProcent.setText(i + "%");
    }

    public void click(View view) {
        Intent intent;
        switch(view.getId()){
            case R.id.btEnd:
                intent = new Intent(FinishhActivity.this, MainActivity.class);
                finish();
                startActivity(intent);
                break;
            case R.id.btStats:
                intent = new Intent(FinishhActivity.this, StatsActivity.class);
                finish();
                startActivity(intent);
                break;


    }
    }
}
