package com.example.tabliczkamnozenia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LevelActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
    }

    void goToPlay(int i){
        intent = new Intent (LevelActivity.this, PlayActivity.class);
        MyApp.level = i;
        finish();
        startActivity(intent);
    }

    public void click(View view) {

        switch (view.getId()) {
            case R.id.blatwyBt:
                goToPlay(1);
                break;

            case R.id.latwyBt:
              goToPlay(2);
                break;

            case R.id.sredniBt:
                goToPlay(3);
                break;

            case R.id.trudnyBt:
                goToPlay(4);
                break;

            case R.id.btrudnyBt:
                goToPlay(5);
                break;

            case R.id.powrotBt:
                intent = new Intent(LevelActivity.this, MainActivity.class);
                finish();
                startActivity(intent);
                break;
        }
    }

}
