package com.exmaple.casper.androidappdevelopment.ch5;

import java.util.Calendar;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex55MainActivity extends Activity
{
    Button btn1, btn2, btn3;
    Intent intent;
    PendingIntent sender;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex55_main);
        btn1=(Button)findViewById(R.id.button1);
        btn1.setOnClickListener(new mClick());
        btn2=(Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new mClick());
        btn3=(Button)findViewById(R.id.button3);
        btn3.setOnClickListener(new mClick());
    }
    class mClick implements OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            switch (v.getId())
            {
                case R.id.button1:
                    timing(); break;
                case R.id.button2:
                    cycle(); break;
                case R.id.button3:
                    cancel(); break;
            }
        }
    }
    /**
     * 定时：5秒后发送一个广播，广播接收后Toast提示定时操作完成
     */
    void  timing()
    {
        intent = new Intent(Ex55MainActivity.this, Ex55AlarmReceiver.class);
        intent.setAction("aaa");
        sender = PendingIntent.getBroadcast(Ex55MainActivity.this, 0, intent, 0);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 5);  //      设定一个五秒后的时间
        AlarmManager alarm=(AlarmManager)getSystemService(ALARM_SERVICE);
        alarm.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                sender);
        Toast.makeText(Ex55MainActivity.this, "五秒后alarm开启",
                Toast.LENGTH_LONG).show();
    }
    /**
     * 定义循环：每5秒发送一个广播，广播接收后Toast提示定时操作完成
     */
    void cycle()
    {
        Intent intent =new Intent(Ex55MainActivity.this, Ex55AlarmReceiver.class);
        intent.setAction("repeating");
        PendingIntent sender = PendingIntent.getBroadcast(Ex55MainActivity.this,
                0, intent, 0);
        /*  开始时间  */
        long firstime=SystemClock.elapsedRealtime();
        AlarmManager am=(AlarmManager)getSystemService(ALARM_SERVICE);
        /*  5秒一个周期，不停的发送广播    */
        am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP ,
                firstime, 5*1000, sender);
    }
    /**
     * 取消周期发送信息
     */
    void cancel()
    {
        Intent intent =new Intent(Ex55MainActivity.this, Ex55AlarmReceiver.class);
        intent.setAction("repeating");
        PendingIntent sender=PendingIntent
                .getBroadcast(Ex55MainActivity.this, 0, intent, 0);
        AlarmManager alarm=(AlarmManager)getSystemService(ALARM_SERVICE);
        alarm.cancel(sender);
    }
}

