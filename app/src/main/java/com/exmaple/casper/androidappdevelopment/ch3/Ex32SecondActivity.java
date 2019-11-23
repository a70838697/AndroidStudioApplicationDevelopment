package com.exmaple.casper.androidappdevelopment.ch3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex32SecondActivity extends AppCompatActivity {

    TextView txt2;
    Bundle   bundle2;
    String   str2;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex32_second);    //(2)修改复制后显示的界面文件
        txt2=(TextView)findViewById(R.id.textView3);
        btn2=(Button)findViewById(R.id.button2);
        bundle2=this.getIntent().getExtras();//从传递过来的Intent对象中取出Bundle对象
        str2=bundle2.getString("user");     //从Bundle对象中取出键名为 user的数据
        txt2.setText(str2 + "\n 欢迎进入本系统！");
        btn2.setOnClickListener(new btnClick2());
    }
    class btnClick2 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent2 = new Intent();
            intent2.setClass(Ex32SecondActivity.this, Ex32MainActivity.class);
            startActivity(intent2);  //跳转到MainActivity页面
        }
    }

}
