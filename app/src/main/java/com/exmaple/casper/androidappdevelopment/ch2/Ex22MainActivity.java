package com.exmaple.casper.androidappdevelopment.ch2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex22MainActivity extends AppCompatActivity {

    //首先声明与界面相同的组件
    TextView txt;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex22_main);
        //建立控制层与表现层（布局文件）组件之间的关联
        txt = (TextView)findViewById(R.id.textView);
        btn = (Button)findViewById(R.id.button);
        //注册监听接口
        btn.setOnClickListener(new mClick());
    }
    //定义实现监听接口的内部类
    class mClick implements View.OnClickListener{
        //实现接口的方法
        @Override
        public void onClick(View v) {
            Ex22MainActivity.this.setTitle("改变标题");
            txt.setText(R.string.newStr);   //把要改变的文字内容设置到strings.xml文件中
        }
    }
}

