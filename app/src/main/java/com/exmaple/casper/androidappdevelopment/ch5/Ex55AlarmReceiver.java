package com.exmaple.casper.androidappdevelopment.ch5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Ex55AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("aaa"))
        {
            Toast.makeText(context,"时间到，上课了！",Toast.LENGTH_LONG).show();
        }else if(intent.getAction().equals("repeating"))
        {
            Toast.makeText(context,"时间到，起床了！",Toast.LENGTH_LONG).show();
        }

    }
}
