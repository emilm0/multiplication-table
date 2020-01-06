package com.example.tabliczkamnozenia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void click(View view) {

        Intent intent;
        switch(view.getId())
        {
            case R.id.nowaGraBt:
                intent = new Intent (MainActivity.this, LevelActivity.class);
                finish();
                startActivity(intent);
                break;
            case R.id.opisBt:
                intent = new Intent (MainActivity.this, OpisActivity.class);
                finish();
                startActivity(intent);
                break;
            case R.id.wyjscieBt:
                finish();
                System.exit(0);

        }
    }
}
