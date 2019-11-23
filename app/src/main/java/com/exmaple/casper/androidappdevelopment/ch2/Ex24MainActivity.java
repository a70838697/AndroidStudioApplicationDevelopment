package com.exmaple.casper.androidappdevelopment.ch2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex24MainActivity extends AppCompatActivity {

    EditText edit;
    TextView txt;
    Button mBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex24_main);
        edit = (EditText)findViewById(R.id.editText);
        txt = (TextView)findViewById(R.id.textView2);
        mBtn = (Button)findViewById(R.id.button);
        mBtn.setOnClickListener(new mClick());
    }
    class mClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            String passwd;
            passwd = edit.getText().toString();  //获取文本编辑框中的文本内容
            if(passwd.equals("abc123"))  //判断两个字符串是否相等
                txt.setText("欢迎进入快乐大本营！");
            else
                txt.setText("非法用户，请立刻离开！");
        }
    }
}

