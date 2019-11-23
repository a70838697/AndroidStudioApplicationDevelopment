package com.exmaple.casper.androidappdevelopment.ch8;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex85MainActivity extends Activity
{
    Button saveBtn, readBtn, savesdBtn, readsdBtn;
    EditText edit;
    String fileName="test.txt";
    String str;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex85_main);
        edit=(EditText)findViewById(R.id.edit1);
        saveBtn=(Button)findViewById(R.id.button1);
        saveBtn.setOnClickListener(new mClick());
        readBtn=(Button)findViewById(R.id.button2);
        readBtn.setOnClickListener(new mClick());
        savesdBtn=(Button)findViewById(R.id.button3);
        savesdBtn.setOnClickListener(new mClick());
        readsdBtn=(Button)findViewById(R.id.button4);
        readsdBtn.setOnClickListener(new mClick());
    }
    //按钮事件
    class mClick implements OnClickListener
    {
        @Override
        public void onClick(View arg0)
        {
            if(arg0== saveBtn)
            {
                savefile();
            }
            else if(arg0== readBtn)
            {
                readfile(fileName);
            }
            else if(arg0== savesdBtn)
            {
                saveSDcar();
            }
            else if(arg0 == readsdBtn)
            {
                readsdcard(fileName);
            }
        }
    }

    void savefile()
    {
        str= edit.getText().toString();
        try {
            FileOutputStream f_out =
                    openFileOutput(fileName, Context.MODE_PRIVATE);
            f_out.write(str.getBytes());
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //读取文件数据
    void readfile(String fileName)
    {
        byte[]  buffer = new byte[1024];
        FileInputStream in_file=null;
        try {
            in_file = openFileInput(fileName);
            int   bytes = in_file.read(buffer);
            str = new String(buffer, 0, bytes);
            Toast.makeText(Ex85MainActivity.this,
                    "文件内容：" + str, Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) { System.out.print("文件不存在");}
        catch (IOException e) { System.out.print("IO流错误");}
    }
    //保存文件到SD卡
    void saveSDcar()
    {
        str= edit.getText().toString();
        if(Environment.getExternalStorageState()
                .equals(Environment.MEDIA_MOUNTED))
        {
            File path = Environment.getExternalStorageDirectory();
            File sdfile = new File(path, fileName);
            try {
                FileOutputStream f_out = new FileOutputStream(sdfile);
                f_out.write(str.getBytes());
                Toast.makeText(Ex85MainActivity.this,
                        "文件保存到SD卡", Toast.LENGTH_LONG).show();
            }catch (FileNotFoundException e)
            {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //从SD卡读取文件内容
    void readsdcard(String fileName)
    {
        if(Environment.getExternalStorageState()
                .equals(Environment.MEDIA_MOUNTED))
        {
            File path = Environment
                    .getExternalStorageDirectory();
            File sdfile= new File(path, fileName);
            try {
                FileInputStream in_file =new  FileInputStream(sdfile);
                byte[]  buffer = new byte[1024];
                int   bytes = in_file.read(buffer);
                str = new String(buffer, 0, bytes);
                Toast.makeText(Ex85MainActivity.this,
                        "文件内容：" + str, Toast.LENGTH_LONG).show();
            } catch (FileNotFoundException e){ System.out.print("文件不存在");}
            catch (IOException e) { System.out.print("IO流错误");}
        }
    }
}
