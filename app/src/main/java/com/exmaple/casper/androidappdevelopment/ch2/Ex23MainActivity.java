package com.exmaple.casper.androidappdevelopment.ch2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex23MainActivity extends AppCompatActivity {
    //声明与界面布局相同的组件
    TextView txt;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex23_main);
        //建立与界面布局中组件的关联
        txt = (TextView)findViewById(R.id.textView);
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new mClick());
    }
    //定义实现监听接口的内部类
    class mClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int BLACK = 0xffcccccc;
            txt.setText("改变了文字及背景颜色");
            txt.setTextColor(Color.YELLOW);//设置文字的颜色我黄色
            txt.setBackgroundColor(BLACK);  //设置文本标签背景颜色
        }
    }
}
