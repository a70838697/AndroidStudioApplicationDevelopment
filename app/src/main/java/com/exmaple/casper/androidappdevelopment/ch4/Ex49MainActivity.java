package com.exmaple.casper.androidappdevelopment.ch4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex49MainActivity extends Activity
{
    private VideoView mVideoView;
    private Button playBtn;
    MediaController mMediaController;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex49_main);
        mVideoView = new VideoView(this);
        mVideoView = (VideoView)findViewById(R.id.video);
        mMediaController = new MediaController(this);
        playBtn = (Button)findViewById(R.id.playButton);
        playBtn.setOnClickListener(new mClick());
    }
    class mClick implements OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            String path="/sdcard/woniu.3gp";
            mVideoView.setVideoPath(path);
            mMediaController.setMediaPlayer(mVideoView);
            mVideoView.setMediaController(mMediaController);
            mVideoView.start();
        }
    }
}
