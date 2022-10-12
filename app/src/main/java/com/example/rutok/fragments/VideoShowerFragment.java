package com.example.rutok.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rutok.R;

import java.util.ArrayList;
import java.util.List;

import datavalues.VideoItem;


public class VideoShowerFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_video_shower, container, false);

        final ViewPager2 videosViewPager = root.findViewById(R.id.videoViewPagerNew);

        List<VideoItem> videoItems = new ArrayList<>();

        VideoItem videoItemForest = new VideoItem();
        videoItemForest.videoURL = R.raw.forest;
        videoItemForest.videoTitle = "Forest";
        videoItemForest.VideoDescription = "Forest is a nice place to walk.";
        videoItems.add(videoItemForest);

        VideoItem videoItemPCGaming = new VideoItem();
        videoItemPCGaming.videoURL = R.raw.gaming;
        videoItemPCGaming.videoTitle = "Gaming";
        videoItemPCGaming.VideoDescription = "It's cool to be a gamer, you know.";
        videoItems.add(videoItemPCGaming);

        VideoItem videoItemSea = new VideoItem();
        videoItemSea.videoURL = R.raw.sea;
        videoItemSea.videoTitle = "Sea";
        videoItemSea.VideoDescription = "I like to travel to the sea.";
        videoItems.add(videoItemSea);

        VideoItem videoItemNature = new VideoItem();
        videoItemNature.videoURL = R.raw.nature;
        videoItemNature.videoTitle = "Nature";
        videoItemNature.VideoDescription = "Nature is a home of man's eternity";
        videoItems.add(videoItemNature);

        videosViewPager.setAdapter(new VideoAdapter(videoItems));
        return root;
    }
}