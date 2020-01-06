package com.example.tabliczkamnozenia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OpisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opis);
    }

    public void click(View view) {

        Intent intent;
        intent = new Intent(OpisActivity.this, MainActivity.class);
        finish();
        startActivity(intent);

    }
}
