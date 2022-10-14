package com.example.rutok.fragments;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rutok.fragments.AccountActivityFragment;
import com.example.rutok.R;
import com.example.rutok.fragments.SearchActivityFragment;
import com.example.rutok.fragments.VideoShowerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class NavigationActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    VideoShowerFragment videoShowerFragment = new VideoShowerFragment();
    AccountActivityFragment accountActivityFragment = new AccountActivityFragment();
    SearchActivityFragment searchActivityFragment = new SearchActivityFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_activity);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION );//View.SYSTEM_UI_FLAG_HIDE_NAVIGATION убирает панель нижних кнопок



        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,videoShowerFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                System.out.println(item.getItemId());
                switch (item.getItemId()) {
                    case R.id.videoShower:

                        getSupportFragmentManager().beginTransaction().replace(R.id.container, videoShowerFragment).commit();
                        return true;


                    case R.id.accountActivity:

                        getSupportFragmentManager().beginTransaction().replace(R.id.container, accountActivityFragment).commit();
                        return true;

                    case R.id.searchActivity:

                        getSupportFragmentManager().beginTransaction().replace(R.id.container, searchActivityFragment).commit();
                        return true;

                    }
                    return false;

            }

        });






    }
}
