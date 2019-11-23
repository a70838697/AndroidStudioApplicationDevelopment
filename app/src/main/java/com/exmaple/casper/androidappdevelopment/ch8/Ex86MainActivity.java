package com.exmaple.casper.androidappdevelopment.ch8;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex86MainActivity extends Activity
{
    SharedPreferences settings;
    Button saveBtn;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex86_main);
        saveBtn=(Button)findViewById(R.id.button1);
        saveBtn.setOnClickListener(new mClick());
    }
    //按钮事件
    class mClick implements OnClickListener
    {
        public void onClick(View arg0)
        {
            settings = getSharedPreferences("phoneBook", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("name", "zsm");
            editor.putString("phone", "123456");
            editor.commit();
            Toast.makeText(Ex86MainActivity.this, "保存成功！", Toast.LENGTH_LONG);
        }
    }
}
