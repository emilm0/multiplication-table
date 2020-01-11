package com.example.tabliczkamnozenia;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.time.Instant;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private int tasksNumber, barTime, res, progressStatus, click, clickCount;

    private TextView textTasks;
    private TextView multiSign;
    private TextView equalSign;
    private TextView value1;
    private TextView value2;
    private TextView result;
    private TextView textAnswer;
    private ProgressBar progressBar;
    private boolean end =false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        MyApp.correct = 0;

        setLevel();
        textTasks = findViewById(R.id.textTasks);
        value1 = findViewById(R.id.textValue1);
        value2 = findViewById(R.id.textValue2);
        progressBar = findViewById(R.id.progressBar);
        result =findViewById(R.id.textResult);
        textAnswer = findViewById(R.id.textAnswer);
        multiSign = findViewById(R.id.textMulti);
        equalSign = findViewById(R.id.textEqualSign);


        textTasks.setText("Zadanie "+ 0 + " / "+ tasksNumber);



        barProgress();
    }

    void setLevel(){
        switch (MyApp.level){
            case 1:
                tasksNumber = 10;
                barTime = 30*10;
                break;
            case 2:
                tasksNumber = 20;
                barTime = 20*10;
                break;
            case 3:
                tasksNumber = 30;
                barTime = 15*9;
                break;
            case 4:
                tasksNumber = 40;
                barTime = 10 *9;
                break;
            case 5:
                tasksNumber = 50;
                barTime = 5 * 9;
                break;

        }
    }

    public void addValue(){
        Random random = new Random();
        String first, second;
        int f,s;
        f = random.nextInt(10)+1;
        s = random.nextInt(10)+1;
        res = s*f;
        first = Integer.toString(f);
        second = Integer.toString(s);
        value1.setText(first);
        value2.setText(second);
        setClickCount(res);
    }

    void setClickCount(int r) {
        if(r == 100)
            clickCount = 3;
        else if(r<10)
            clickCount = 1;
        else
            clickCount = 2;
    }

    public void viewResult(String s){
        TextView text = findViewById(R.id.textResult);
        if(s.equals(""))
            text.setText(null);
        if(click <= clickCount)
             text.append(s);
    }

    public void click(View view) {
        Intent intent;

        switch (view.getId()) {
            case R.id.bt0:
                click++;
                viewResult("0");
                break;
            case R.id.bt1:
                click++;
                viewResult("1");
                break;
            case R.id.bt2:
                click++;
                viewResult("2");
                break;
            case R.id.bt3:
                click++;
                viewResult("3");
                break;
            case R.id.bt4:
                click++;
                viewResult("4");
                break;
            case R.id.bt5:
                click++;
                viewResult("5");
                break;
            case R.id.bt6:
                click++;
                viewResult("6");
                break;
            case R.id.bt7:
                click++;
                viewResult("7");
                break;
            case R.id.bt8:
                click++;
                viewResult("8");
                break;
            case R.id.bt9:
                click++;
                viewResult("9");
                break;
            case R.id.btMenu:
                intent = new Intent(PlayActivity.this, MainActivity.class);
                end = true;
                finish();
                startActivity(intent);
                break;

        }
    }

    void showAnswer(){
        progressBar.setVisibility(View.INVISIBLE);
        textAnswer.setVisibility(View.VISIBLE);
        if(Integer.toString(res).equals(result.getText().toString())){
            MyApp.correct++;
            textAnswer.setText("DOBRZE!");
            textAnswer.setTextColor(Color.rgb(0,204,0));
            equalSign.setTextColor(Color.rgb(0,204,0));
            multiSign.setTextColor(Color.rgb(0,204,0));
            result.setTextColor(Color.rgb(0,204,0));
            value1.setTextColor(Color.rgb(0,204,0));
            value2.setTextColor(Color.rgb(0,204,0));
        }
        else {
            textAnswer.setText("ŹLE");
            textAnswer.setTextColor(Color.RED);
            equalSign.setVisibility(View.INVISIBLE);
            multiSign.setVisibility(View.INVISIBLE);
            result.setVisibility(View.INVISIBLE);
            value1.setVisibility(View.INVISIBLE);
            value2.setVisibility(View.INVISIBLE);
        }
    }

    void returnView(){
        textAnswer.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        equalSign.setVisibility(View.VISIBLE);
        multiSign.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
        value1.setVisibility(View.VISIBLE);
        value2.setVisibility(View.VISIBLE);

        result.setText("");
        equalSign.setTextColor(Color.BLACK);
        multiSign.setTextColor(Color.BLACK);
        result.setTextColor(Color.BLACK);
        value1.setTextColor(Color.BLACK);
        value2.setTextColor(Color.BLACK);

        click = 0;
    }

    public void barProgress(){

        final Thread tBar =new Thread(new Runnable() {
            @Override
            public void run() {
                int time, i;

                for (i = 0; i < tasksNumber; i++) {

                    final int x =i;

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            textTasks.setText("Zadanie "+ (x+1) + " / "+ tasksNumber);
                            returnView();
                            addValue();
                        }
                    });

                    progressStatus = 100;

                    while (progressStatus > 0) {
                        progressStatus--;
                        try {
                            Thread.sleep(barTime);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if (end) {
                            progressStatus = 0;
                            i = tasksNumber;
                        }

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setProgress(progressStatus);
                            }
                        });
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showAnswer();

                        }
                    });

                    time =0;
                    while (time < 100) {
                        time++;
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                }
                if (i == tasksNumber)
                    endGame();
            }
        });

        tBar.start();

    }

    void endGame(){
        Intent intent;
        intent = new Intent(PlayActivity.this, FinishhActivity.class);
        finish();
        startActivity(intent);


    }

}
