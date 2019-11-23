package com.exmaple.casper.androidappdevelopment.ch2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex213MainActivity extends AppCompatActivity {

    ImageView img;
    Button btn_last, btn_next;
    //存放图片id的int数组
    private int[] imgs = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6};
    int index = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex213_main);
        img = (ImageView) findViewById(R.id.img);
        btn_last = (Button) findViewById(R.id.btn_last);
        btn_next = (Button) findViewById(R.id.btn_next);
        btn_last.setOnClickListener(new mClick());
        btn_next.setOnClickListener(new mClick());
    }

    class mClick implements View.OnClickListener  //定义一个类实现监听接口
    {
        public void onClick(View v) {
            if (v == btn_last) {
                if (index > 0 && index < imgs.length) {
                    index--;
                    img.setImageResource(imgs[index]);
                } else {
                    index = imgs.length + 1;
                }
            }
            if (v == btn_next) {
                if (index > 0 && index < imgs.length - 1) {
                    index++;
                    img.setImageResource(imgs[index]);
                } else {
                    index = imgs.length - 1;
                }
            }
        }
    }
}

