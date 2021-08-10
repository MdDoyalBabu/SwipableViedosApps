package com.example.swipeablevideos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.example.swipeablevideos.adapter.VideoitemAdapter;
import com.example.swipeablevideos.model.VideoItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ViewPager2 viewPager2=findViewById(R.id.videosViewPagers);

        List<VideoItem> videoItems=new ArrayList<>();

        VideoItem videoItemCeleberate=new VideoItem();

        videoItemCeleberate.vidoUrl="https://www.youtube.com/watch?v=668nUCeBHyY";
        videoItemCeleberate.textVideoTitle="Celeberate";
        videoItemCeleberate.textVideoDescription="Hey i am New Student Of Rangpur Polytechnic Institute";
        videoItems.add(videoItemCeleberate);

        VideoItem videoItemCeleberate1=new VideoItem();

        videoItemCeleberate1.vidoUrl="";
        videoItemCeleberate1.textVideoTitle="Celeberate";
        videoItemCeleberate1.textVideoDescription="Hey i am New Student Of Rangpur Polytechnic Institute";
        videoItems.add(videoItemCeleberate1);



        viewPager2.setAdapter(new VideoitemAdapter(videoItems));


    }
}