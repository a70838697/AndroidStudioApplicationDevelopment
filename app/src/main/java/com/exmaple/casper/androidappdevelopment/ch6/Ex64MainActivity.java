package com.exmaple.casper.androidappdevelopment.ch6;

import java.net.InetAddress;
import java.net.UnknownHostException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex64MainActivity extends Activity
{
    Button IPBtn;
    String ipStr="";
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex64_main);
        IPBtn=(Button)findViewById(R.id.button1);
        IPBtn.setOnClickListener(new mClick());
    }

    class mClick implements OnClickListener
    {
        @Override
        public void onClick(View arg0)
        {
            final Handler handler=new Handler()
            {
               @Override
                public void handleMessage(Message msg) {
                    Toast.makeText(Ex64MainActivity.this, ipStr, Toast.LENGTH_LONG).show();
                }
            };
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        InetAddress zsm_address=InetAddress.getByName("www.jiaozuoye.com");
                        ipStr="jiaozuoye.com的IP地址为：\n"+zsm_address.toString();
                    }
                    catch(UnknownHostException e)
                    {
                        ipStr="无法找到jiaozuoye.com";
                    }
                    handler.sendEmptyMessage(1);
                }
            }).start();

        }
    }
}
