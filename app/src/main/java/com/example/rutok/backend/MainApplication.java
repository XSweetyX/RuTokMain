package com.example.rutok.backend;



import android.app.Application;
import android.content.Context;

public class MainApplication extends Application {

    private static MainApplication instance;

    public MainApplication() {
        instance = this;
    }

    public static Context getContext() {
        return instance;
    }
}
