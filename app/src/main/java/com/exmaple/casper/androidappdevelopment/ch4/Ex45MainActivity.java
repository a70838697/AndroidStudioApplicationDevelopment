package com.exmaple.casper.androidappdevelopment.ch4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex45MainActivity extends Activity
{
    private Ex45HandWrite handWrite = null;
    private Button clear = null;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex45_main);
        handWrite = (Ex45HandWrite)findViewById(R.id.handwriteview);
        clear = (Button)findViewById(R.id.clear);
        clear.setOnClickListener(new mClick());
    }
    private class mClick implements OnClickListener
    {
        public void onClick(View v)
        {
            handWrite.clear();
        }
    }
}
