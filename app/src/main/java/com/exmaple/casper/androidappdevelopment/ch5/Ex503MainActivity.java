package com.exmaple.casper.androidappdevelopment.ch5;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex503MainActivity extends Activity implements View.OnClickListener
{
    Ex503Broadcast mEx503Broadcast = null;
    static Button btnStart;
    Button btnStop;
    Intent intent;
    String AUDIO_PATH="/sdcard/Music/meiliyou.mp3";
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex503_main);
        btnStart  = (Button) findViewById(R.id.btnPlayOrPause);
        btnStop = (Button) findViewById(R.id.btnStop);
        IntentFilter filter = new IntentFilter("music");
        mEx503Broadcast = new Ex503Broadcast();
        registerReceiver(mEx503Broadcast, filter);
        btnStart.setOnClickListener (this);
        btnStop.setOnClickListener(this);
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        unregisterReceiver(mEx503Broadcast);
    }
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.btnPlayOrPause:
                intent = new Intent(Ex503MainActivity.this,
                        Ex503AudioService.class);
                Bundle bundle = new Bundle();
                bundle.putString("audioPath", AUDIO_PATH);
                intent.putExtras(bundle);
                startService(intent);
                break;
            case R.id.btnStop:
                if(intent != null)
                {
                    stopService(intent);
                }
                break;
        }
    }
}
