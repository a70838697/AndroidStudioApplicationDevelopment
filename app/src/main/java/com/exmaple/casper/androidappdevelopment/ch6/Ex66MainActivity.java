package com.exmaple.casper.androidappdevelopment.ch6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.exmaple.casper.androidappdevelopment.R;

import java.util.concurrent.FutureTask;

public class Ex66MainActivity extends AppCompatActivity {
    Button connBtn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex66_main);
        txt = (TextView) findViewById(R.id.textView);
        connBtn = (Button) findViewById(R.id.button);
        connBtn.setOnClickListener(new mClick());
    }

    class mClick implements View.OnClickListener {
        String str;

        @Override
        public void onClick(View v) {
            if (v == connBtn) {
                Ex66ConnSocket conn = new Ex66ConnSocket();
                try {
                    FutureTask<String> msg = new FutureTask<String>(conn);
                    new Thread(msg).start();
                    str = msg.get();
                    txt.append(str);
                } catch (Exception e) {
                    txt.setText("连接错误！！！！！！");
                } finally {
                    conn.disConnet();
                }
            }  // if_end         //使用get()方法获取线程的返回值
        }  // onClick_end
    } // mClick_end
}

