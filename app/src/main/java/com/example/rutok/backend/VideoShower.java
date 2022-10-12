package com.example.rutok.backend;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import androidx.viewpager2.widget.ViewPager2;

import com.example.rutok.R;
import com.example.rutok.fragments.VideoAdapter;

import java.util.ArrayList;
import java.util.List;

import datavalues.VideoItem;

public class VideoShower extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_show);


        //деалаем красоту




        //Далее убираем панель статусов важно задать id для layout-а
        //View overlay = findViewById(R.id.videshowid);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION );//View.SYSTEM_UI_FLAG_HIDE_NAVIGATION убирает панель нижних кнопок



        final ViewPager2 videosViewPager = findViewById(R.id.videoViewPagerNew);

        List<VideoItem> videoItems = new ArrayList<>();

        VideoItem videoItemForest  = new VideoItem();
        videoItemForest.videoURL = R.raw.forest;
        videoItemForest.videoTitle = "Forest";
        videoItemForest.VideoDescription = "Forest is a nice place to walk.";
        videoItems.add(videoItemForest);

        VideoItem videoItemPCGaming  = new VideoItem();
        videoItemPCGaming.videoURL = R.raw.gaming;
        videoItemPCGaming.videoTitle = "Gaming";
        videoItemPCGaming.VideoDescription = "It's cool to be a gamer, you know.";
        videoItems.add(videoItemPCGaming);

        VideoItem videoItemSea  = new VideoItem();
        videoItemSea.videoURL = R.raw.sea;
        videoItemSea.videoTitle = "Sea";
        videoItemSea.VideoDescription = "I like to travel to the sea.";
        videoItems.add(videoItemSea);

        VideoItem videoItemNature  = new VideoItem();
        videoItemNature.videoURL = R.raw.nature;
        videoItemNature.videoTitle = "Nature";
        videoItemNature.VideoDescription = "Nature is a home of man's eternity";
        videoItems.add(videoItemNature);

        videosViewPager.setAdapter(new VideoAdapter(videoItems));

















    }
}
