package com.example.rutok.backend;

import static com.example.rutok.backend.MainApplication.getContext;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rutok.R;

import java.util.List;

import datavalues.VideoItem;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder>{

    private List<VideoItem> videoItems;

    public VideoAdapter(List<VideoItem> videoItems) {
        this.videoItems = videoItems;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_video,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.setVideoData(videoItems.get(position));
    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    static class VideoViewHolder extends RecyclerView.ViewHolder{

        VideoView videoView;
        TextView textVideoTitle, textVideoDescription;
        ImageView Like,Comment,MoreOptions,AccoutnButton;


        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView  = itemView.findViewById(R.id.VideoViewValue);//подсоединение окна контейнера для видео, текста и тд.
            textVideoTitle  = itemView.findViewById(R.id.textVievVideoTitle);
            textVideoDescription = itemView.findViewById(R.id.textVievVideoDescription);

            Like = itemView.findViewById(R.id.imageView2);
            Comment = itemView.findViewById(R.id.imageView3);
            MoreOptions = itemView.findViewById(R.id.imageView4);
            AccoutnButton = itemView.findViewById(R.id.imageView);




            Like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(),"Liked",Toast.LENGTH_SHORT).show();
                }
            });



            Comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(getContext(),"Liked",Toast.LENGTH_SHORT).show();
                }
            });


            MoreOptions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(),"Liked",Toast.LENGTH_SHORT).show();
                }
            });


            AccoutnButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(videoView.getContext(), AccountActivity.class);//У нас не Activity, а  RecyclerView.Adapter<VideoAdapter.VideoViewHolder> поэтому делаем videoView.getContext()
                    videoView.getContext().startActivity(intent);
                    ((Activity)videoView.getContext()).finish();// пребразуем тип на Activity

                }
            });





        }
        public void setVideoData(VideoItem videoItem){

            textVideoTitle.setText(videoItem.videoTitle);
            textVideoDescription.setText(videoItem.VideoDescription);
            videoView.setVideoURI(Uri.parse("android.resource://" + getContext().getPackageName() +"/"+videoItem.videoURL));
            videoView.start();
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                    float videoRatio = mediaPlayer.getVideoWidth() / (float) mediaPlayer.getVideoHeight();
                    float screenRatio = videoView.getWidth() / (float) videoView.getHeight();
                    float scale = videoRatio / screenRatio;
                    if(scale >= 1f){

                        videoView.setScaleX(scale);

                    }else {

                        videoView.setScaleY(1f/scale);

                    }

                }

            });

            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {

                    mediaPlayer.start();
                }
            });



        }
    }
}
