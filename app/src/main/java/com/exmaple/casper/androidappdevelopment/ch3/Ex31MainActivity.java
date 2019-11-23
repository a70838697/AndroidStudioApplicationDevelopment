package com.exmaple.casper.androidappdevelopment.ch3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex31MainActivity extends AppCompatActivity {
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex31_main);
        btn1 = (Button)findViewById(R.id.button);
        btn1.setOnClickListener(new mClick());
    }
    class mClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent1 = new Intent(Ex31MainActivity.this, Ex31SecondActivity.class);
            startActivity(intent1);  //启动另一个页面，页面跳转
        }
    }

}
