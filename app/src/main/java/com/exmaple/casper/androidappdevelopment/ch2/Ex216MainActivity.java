package com.exmaple.casper.androidappdevelopment.ch2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex216MainActivity extends AppCompatActivity  {
    ListView list;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex216_main);
        list= (ListView)findViewById(R.id.ListView01);
        //定义数组
        String[] data ={
                "（1）荷塘月色",
                "（2）最炫民族风",
                "（3）天蓝蓝",
                "（4）最美天下",
                "（5）自由飞翔",
        };
        //为ListView设置数组适配器ArrayAdapter
        list.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, data));
        //为ListView设置列表选项监听器
        list.setOnItemClickListener(new mItemClick());
    }
    //定义列表选项监听器的事件
    class mItemClick implements AdapterView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
        {
            Toast.makeText(Ex216MainActivity.this,"您选择的项目是："
                    +((TextView)arg1).getText(), Toast.LENGTH_SHORT).show();
        }
    }
}
