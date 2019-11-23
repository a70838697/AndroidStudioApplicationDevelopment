package com.exmaple.casper.androidappdevelopment.ch5;

import android.os.Bundle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex501MainActivity extends Activity
{
    Button startbtn, stopbtn;
    Context context;
    Intent intent;
    static TextView txt;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex501_main);
        startbtn=(Button)findViewById(R.id.butn1);
        stopbtn=(Button)findViewById(R.id.butn2);
        startbtn.setOnClickListener(new mClick());
        stopbtn.setOnClickListener(new mClick());
        txt=(TextView)findViewById(R.id.text1);
        intent = new Intent(Ex501MainActivity.this, Ex501AudioSrv.class);
    }
    class mClick implements OnClickListener  //定义一个类实现监听接口
    {
        public void onClick(View v)
        {
            if(v == startbtn)
            {
                Ex501MainActivity.this.startService(intent);
                txt.setText("start service .......");
            }
            else if(v == stopbtn)
            {
                Ex501MainActivity.this.stopService(intent);
            }
        }
    }
}

