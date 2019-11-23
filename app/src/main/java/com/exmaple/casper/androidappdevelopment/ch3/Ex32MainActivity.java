package com.exmaple.casper.androidappdevelopment.ch3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex32MainActivity extends AppCompatActivity {
    Button btn1;
    EditText txt1;   //在例3-1的基础上增加了一个编辑框组件
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex32_main);
        btn1 = (Button)findViewById(R.id.button);
        txt1 = (EditText)findViewById(R.id.editText);
        btn1.setOnClickListener(new mClick());
    }
    class mClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent1 = new Intent(Ex32MainActivity.this, Ex32SecondActivity.class);
            String str = txt1.getText().toString();  //从编辑框中获取数据
            Bundle bundle1 = new Bundle();            //创建Bundle 对象
            bundle1.putString("user", str);          // 把编辑框中的字符串作为传递值，键名为user
            intent1.putExtras(bundle1);               //把Bundle对象放到Intent对象中
            startActivity(intent1);  //启动另一个页面，页面跳转
        }
    }

}
