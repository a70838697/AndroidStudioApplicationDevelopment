package com.exmaple.casper.androidappdevelopment.ch5;

import android.content.ComponentName;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex502MainActivity extends Activity
{
    static TextView txt;
    private Ex502TestReceiver myBroadcastReceiver;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex502_main);
        txt = (TextView)findViewById(R.id.txt1);
        Button btn=(Button)findViewById(R.id.button01);
        btn.setOnClickListener(new mClick());
    }

    class mClick implements  OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent("com.example.MY_B");
            intent.setAction("com.example.MY_B");
            intent.setComponent(new ComponentName("com.exmaple.casper.androidappdevelopment", "com.exmaple.casper.androidappdevelopment.ch5.Ex502TestReceiver"));
            Bundle bundle = new Bundle();
            bundle.putString("hello", "这是广播信息!");
            intent.putExtras(bundle);
            sendBroadcast(intent);
        }
    }
}
