package com.exmaple.casper.androidappdevelopment.ch5;
import android.app.NotificationChannel;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex54MainActivity extends Activity {
    NotificationManager n_Manager;
    Notification notification;
    Button btn1, btn2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex54_main);
        String service = NOTIFICATION_SERVICE;
        n_Manager = (NotificationManager) getSystemService(service);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new mClick());
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new mClick());
    }

    class mClick implements OnClickListener {
        @Override
        public void onClick(View arg0) {
            if (arg0 == btn1) {
                int icon = R.drawable.icon;
                CharSequence tickerText = "紧急通知,程序已启动";
                long when = System.currentTimeMillis();
                Notification.Builder builder = new Notification.Builder(Ex54MainActivity.this);
                String contextTitle="通知的标题";
                String contentText=("这是通知的内容");
                Intent intent = new Intent(Ex54MainActivity.this, Ex54MainActivity.class);
                PendingIntent pi = PendingIntent.getActivity(Ex54MainActivity.this,
                        0, intent, 0);
                builder.setTicker(tickerText);
                builder.setWhen(when);
                builder.setSmallIcon(icon);

                if(Build.VERSION.SDK_INT >= 26)
                {
                    //当sdk版本大于26
                    String id = "channel_1";
                    String description = "143";
                    int importance = NotificationManager.IMPORTANCE_LOW;
                    NotificationChannel channel = new NotificationChannel(id, description, importance);
//                     channel.enableLights(true);
//                     channel.enableVibration(true);//
                    n_Manager.createNotificationChannel(channel);
                    Notification notification = new Notification.Builder(Ex54MainActivity.this, id)
                            .setCategory(Notification.CATEGORY_MESSAGE)
                            .setSmallIcon(icon)
                            .setContentTitle(contextTitle)
                            .setContentText(contentText)
                            .setContentIntent(pi)
                            .setWhen(when)
                            .setTicker(tickerText)
                            .setAutoCancel(true)
                            .build();
                    n_Manager.notify(1, notification);
                }
                else
                {
                    //当sdk版本小于26
                    Notification notification = new NotificationCompat.Builder(Ex54MainActivity.this)
                            .setContentTitle(contextTitle)
                            .setContentText(contentText)
                            .setContentIntent(pi)
                            .setWhen(when)
                            .setTicker(tickerText)
                            .setSmallIcon(icon)
                            .build();
                    n_Manager.notify(1,notification);
                }
            } else if (arg0 == btn2) {
                n_Manager.cancelAll();
            }
        }
    }


}