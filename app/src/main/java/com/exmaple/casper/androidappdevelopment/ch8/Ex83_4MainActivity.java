package com.exmaple.casper.androidappdevelopment.ch8;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.exmaple.casper.androidappdevelopment.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Ex83_4MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex83_4_main);
        Button loadButton = findViewById(R.id.button2);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readfile();
            }
        });
        Button saveButton = findViewById(R.id.button1);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savefile();
            }
        });

    }

    void savefile() {
        String fileName = "test.txt";
        String str = "Hello World!" + Math.random();
        FileOutputStream f_out;
        try {
            f_out = openFileOutput(fileName, Context.MODE_PRIVATE);
            f_out.write(str.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(Ex83_4MainActivity.this,
                "保存文件内容：" + str, Toast.LENGTH_LONG).show();
    }

    void readfile() {
        String fileName = "test.txt", str;
        byte[] buffer = new byte[1024];
        FileInputStream in_file = null;
        try {
            in_file = openFileInput(fileName);
            int bytes = in_file.read(buffer);
            str = new String(buffer, 0, bytes);
            Toast.makeText(Ex83_4MainActivity.this,
                    "文件内容：" + str, Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            System.out.print("文件不存在");
        } catch (IOException e) {
            System.out.print("IO流错误");
        }
    }
}
