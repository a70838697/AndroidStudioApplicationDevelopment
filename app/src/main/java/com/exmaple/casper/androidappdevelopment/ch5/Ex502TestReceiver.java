package com.exmaple.casper.androidappdevelopment.ch5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Ex502TestReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        String str = intent.getExtras().getString("hello");
        Ex502MainActivity.txt.setText(str);
    }
}

