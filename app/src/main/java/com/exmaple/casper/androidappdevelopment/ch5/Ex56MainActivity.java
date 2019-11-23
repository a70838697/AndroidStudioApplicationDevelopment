package com.exmaple.casper.androidappdevelopment.ch5;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex56MainActivity extends Activity
{
    Button btn_sms;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex56_main);
        btn_sms=(Button)findViewById(R.id.btn1);
        btn_sms.setOnClickListener(new mClick());
    }
    class mClick implements OnClickListener
    {
        @Override
        public void onClick(View arg0)
        {
            Uri uri =Uri.parse("smsto:13900100100");
            Intent it = new Intent(Intent.ACTION_SENDTO,uri);
            it.putExtra("sms_body", "TheSMS text");
            startActivity(it);
        }
    }
}

