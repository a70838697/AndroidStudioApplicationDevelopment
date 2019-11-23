package com.exmaple.casper.androidappdevelopment.ch5;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex501AudioSrv extends Service
{
    MediaPlayer play;
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
    public void onCreate()
    {
        super.onCreate();
        play = MediaPlayer.create(this, R.raw.yelang);
        Toast.makeText(this, "创建后台服务...", Toast.LENGTH_LONG).show();
    }
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        super.onStartCommand(intent, flags, startId);
        play.start();
        Toast.makeText(this, "启动后台服务程序，播放音乐...",
                Toast.LENGTH_LONG).show();
        return START_STICKY;
    }
    public void onDestroy()
    {
        play.release();
        super.onDestroy();
        Toast.makeText(this, "销毁后台服务！", Toast.LENGTH_LONG).show();
    }
}

