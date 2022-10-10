package com.example.rutok.backend;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.example.rutok.R;

public class SearchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);



    }
}
