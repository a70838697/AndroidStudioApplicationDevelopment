package com.exmaple.casper.androidappdevelopment.ch5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/*  广播接收器 */
class Ex503Broadcast extends  BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        /**
         * 更新界面。这里改变Button的值
         * 从intent获取接收到的广播数据,
         * 数据值为0表示此时是播放、为1表示是暂停、 为2表示是停止
         */
        int backFlag = intent.getExtras().getInt("backFlag");
        switch(backFlag)
        {
            case 0:
                Ex503MainActivity.btnStart.setText("暂停");
                break;
            case 1:
            case 2:
                Ex503MainActivity.btnStart.setText("播放");
                break;
        }
    }
}
