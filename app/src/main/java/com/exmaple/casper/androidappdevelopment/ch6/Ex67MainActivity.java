package com.exmaple.casper.androidappdevelopment.ch6;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.exmaple.casper.androidappdevelopment.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Ex67MainActivity extends AppCompatActivity {
    ImageView img;
    TextView txt1, txt2;
    Button connBtn;
    HttpURLConnection conn = null ;
    InputStream inStrem = null;
    String str = "https://upload.jianshu.io/users/upload_avatars/1002598/e60a46ad541f.jpg";
    HHandler mHandler = new HHandler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex67_main);
        img = (ImageView)findViewById(R.id.imageView);
        txt1 = (TextView)findViewById(R.id.textView);
        txt2 = (TextView)findViewById(R.id.textView2);
        connBtn = (Button)findViewById(R.id.button);
        connBtn.setOnClickListener(new mClick());
    }

    class mClick implements View.OnClickListener {
        public void onClick(View arg0) {
            StrictMode.setThreadPolicy(
                    new StrictMode
                            .ThreadPolicy
                            .Builder()
                            .detectDiskReads()
                            .detectDiskWrites()
                            .detectNetwork()
                            .penaltyLog()
                            .build()
            );
            StrictMode.setVmPolicy(
                    new StrictMode
                            .VmPolicy
                            .Builder()
                            .detectLeakedSqlLiteObjects()
                            .detectLeakedClosableObjects()
                            .penaltyLog()
                            .penaltyDeath()
                            .build()
            );
            getPicture();
        }
    }

    private  void getPicture(){
        try {
            URL url = new URL(str);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            if ( conn.getResponseCode() == 200) {
                inStrem = conn.getInputStream();
                Bitmap bmp= BitmapFactory.decodeStream(inStrem);
                mHandler.obtainMessage(0, bmp).sendToTarget();
                int result = inStrem.read();
                while (result != -1){
                    txt1.setText((char)result);
                    result = inStrem.read();
                }
                inStrem.close();
                txt1.setText("(1)建立输入流成功！");
            }
        }catch(Exception e2)  { txt1.setText("(3)IO流失败");}
    }

    class HHandler extends Handler
    {
        public void handleMessage(Message msg){
            super. handleMessage( msg);
            txt2.setText("(2)下载图像成功!");
            img.setImageBitmap((Bitmap) msg.obj);
        }
    }
}
