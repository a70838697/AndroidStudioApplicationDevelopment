package com.exmaple.casper.androidappdevelopment.ch6;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex65MainActivity extends AppCompatActivity {
    private Socket socket = null;
    private DataInputStream dis = null;
    private DataOutputStream dos = null;
    private TextView mTextView1;
    private Button Button1;
    String msg = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex65_main);
        mTextView1 = (TextView) findViewById(R.id.textView);
        Button1 = (Button) findViewById(R.id.Button);
        Button1.setOnClickListener(new mClick());
        //以下代码避免程序出现NetworkOnMainThreadException异常
        StrictMode.setThreadPolicy(new StrictMode
                .ThreadPolicy
                .Builder()
                .detectDiskWrites()
                .detectDiskReads()
                .detectNetwork()
                .penaltyLog()
                .build());
    }

    class mClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Client();
        }

        public void Client() {
            try {
                socket = new Socket("192.168.1.135", 4321);
            } catch (Exception ioe) {
                System.out.print("socket  err ");
            }
            try {
                // 创建输入流对象dis读取数据，创建输出流对象dos发送数据
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF("给我数据啊。。。");
                dos.flush();
            } catch (IOException ioe) {
                System.out.print("DataStream create err ");
            }
            ReadStr();
            try {
                Thread.sleep(500);
                msg = "手机客户端发来贺电！";
                WriteString(msg);
                dis.close();
                socket.close();
            } catch (Exception ioe) {
                System.out.println("socket close() err .......");
            }
            ReadStr();
        }

        // 写数据到socket，即发送数据
        public void WriteString(String str) {
            try {
                dos.writeUTF(str);
                dos.flush();
                ReadStr();
                socket.close();
            } catch (IOException e) {
                System.out.print("WriteString() err");
            }
        }

        // 显示从socket返回的数据，即读取数据
        public void ReadStr() {
            try {

                if ((msg = dis.readUTF()) != null) {

                    mTextView1.append(msg);
                }
            } catch (IOException ioe) {
                System.out.print("ReadStr() err ");
            }
        }
    }
}
