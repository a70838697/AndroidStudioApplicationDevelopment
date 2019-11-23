package com.exmaple.casper.androidappdevelopment.ch5;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class Ex503AudioService extends Service
{
    private MediaPlayer mediaPlayer = null;
    private Intent intent2 = null;
    private Bundle bundle2 = null;
    private String audioPath ;
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        super.onStartCommand(intent, flags, startId);
        audioPath = intent.getExtras().getString("audioPath");
        /**  １.正在播放
         *     使其暂停播放，并通知界面将Button的值改为"播放"
         *     (如果正在播放，Button值是"暂停")
         */
        if(mediaPlayer != null && mediaPlayer.isPlaying())
        {
            mediaPlayer.pause();
            sendUpdateUI(1);//更新界面
        }
        /**
         *２.正在暂停
         */
        else{
            if(mediaPlayer == null)
            {
                mediaPlayer = new MediaPlayer();//如果被停止了，则为null
                try {
                    mediaPlayer.reset();
                    mediaPlayer.setDataSource(audioPath) ;
                    mediaPlayer.prepare();
                } catch (Exception e)
                {  Log.e("player", "player  prepare() err");  	}
            }
            mediaPlayer.start();
            sendUpdateUI(0);//更新界面
        }
        return START_STICKY;
    }
    @Override
    public void onDestroy()
    {
        if(mediaPlayer !=null)
        {
            mediaPlayer.release();//停止时要release
            sendUpdateUI(2);//更新界面
        }
        super.onDestroy();
    }
    private void sendUpdateUI(int flag)
    {
        intent2 = new Intent();
        intent2.setAction("music");
        bundle2 = new Bundle();
        bundle2.putInt("backFlag", flag);//把flag传回去
        intent2.putExtras(bundle2);
        //intent2.setComponent(new ComponentName("com.exmaple.casper.androidappdevelopment", "com.exmaple.casper.androidappdevelopment.ch5.Ex503Broadcast"));

        sendBroadcast(intent2);
        /* 发送广播
         * 后台服务把键名为backFlag的信息广播出去
         * 发送后，在Activity里的updateUIReceiver的onReceiver()方法
         * 就能做相应的更新界面的工作了
         */
    }
}
