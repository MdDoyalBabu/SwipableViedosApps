package com.example.swipeablevideos.adapter;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swipeablevideos.R;
import com.example.swipeablevideos.model.VideoItem;

import java.util.List;

public class VideoitemAdapter extends RecyclerView.Adapter<VideoitemAdapter.ViewHolder> {

    List<VideoItem> videoItems;

    public VideoitemAdapter(List<VideoItem> videoItems) {
        this.videoItems = videoItems;
    }

    @NonNull
    @Override
    public VideoitemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contain_videos,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoitemAdapter.ViewHolder holder, int position) {

        holder.setVideosData(videoItems.get(position));
    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private VideoView videoView;
        private TextView textTtile,textDescription;
        private ProgressBar progressBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textTtile=itemView.findViewById(R.id.textvideoTitile);
            textDescription=itemView.findViewById(R.id.textvideoDescription);
            videoView=itemView.findViewById(R.id.videosVideoView);
            progressBar=itemView.findViewById(R.id.videosProgressbar);

        }

        void setVideosData(VideoItem videosData){

            textTtile.setText(videosData.textVideoTitle);
            textDescription.setText(videosData.textVideoDescription);
            videoView.setVideoPath(videosData.vidoUrl);


            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    progressBar.setVisibility(View.GONE);
                    mp.start();

                    float videoRatio=(float) mp.getVideoWidth()/(float)mp.getVideoHeight();
                    float sreenRatio=(float) videoView.getWidth()/(float)videoView.getHeight();
                    float scale=videoRatio/sreenRatio;

                    if (scale>=1f){
                        videoView.setScaleX(scale);
                    }else {
                        videoView.setScaleY(1f/scale);
                    }

                }
            });

            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                }
            });




        }

    }
}
