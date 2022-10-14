package com.example.rutok.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.rutok.R;
import com.example.rutok.backend.VideoShower;

public class SplashActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        //Далее убираем панель статусов важно задать id для layout-а

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        //-----------------------------------------------


       // MediaPlayer mPlayer = MediaPlayer.create(SplashActivity.this, R.raw.introsound);;
       // mPlayer.start();


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, NavigationActivity.class));
                SplashActivity.this.finish();
            }
        }, 2000);//Ставите сколько сек, 1000 = 1с.

    }

}
