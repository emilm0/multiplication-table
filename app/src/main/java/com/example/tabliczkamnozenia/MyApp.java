package com.example.tabliczkamnozenia;

import android.app.Application;

public class MyApp extends Application {

    public static int correct;
    public static int level;


    @Override
    public void onCreate() {

        correct =0;
        level = 0;
        super.onCreate();
    }
}