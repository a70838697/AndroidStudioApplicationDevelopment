package com.exmaple.casper.androidappdevelopment.ch4;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex48MainActivity extends Activity
{
    MediaPlayer mMediaPlayer;
    SurfaceView mSurfaceView;
    Button playBtn;
    String path;
    SurfaceHolder sh;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex48_main);
        mSurfaceView = (SurfaceView)findViewById(R.id.surfaceView1);
        playBtn=(Button)findViewById(R.id.play1);
        path = "/sdcard/woniu.3gp";
        mMediaPlayer = new  MediaPlayer();
        playBtn.setOnClickListener(new mClick());
    }

    class mClick implements OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            try {
                mMediaPlayer.reset();
                //为播放器对象设置用于显示视频内容、代表屏幕描绘的控制器
                mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mMediaPlayer.setDataSource(path);//设置数据源
                sh=mSurfaceView.getHolder();
                mMediaPlayer.setDisplay(sh);
                mMediaPlayer.prepare();
                mMediaPlayer.start();
            }catch (Exception e){ Log.i("MediaPlay err", "MediaPlay err");}
        }
    }
}
