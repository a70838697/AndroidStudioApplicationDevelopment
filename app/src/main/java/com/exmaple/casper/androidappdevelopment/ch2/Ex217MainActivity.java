package com.exmaple.casper.androidappdevelopment.ch2;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex217MainActivity extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex217_main);
        //定义数组
        String[] data ={
                "（1）荷塘月色",
                "（2）最炫民族风",
                "（3）天蓝蓝",
                "（4）最美天下",
                "（5）自由飞翔",
        };
        //获取列表项
        ListView list=getListView();
        //设置列表项的头部
        TextView header=new TextView(this);
        header.setText("凤凰传奇经典歌曲");
        header.setTextSize(24);
        list.addHeaderView(header);
        //设置列表项的底部
        TextView foot=new TextView(this);
        foot.setText("请选择");
        foot.setTextSize(24);
        list.addFooterView(foot);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, data));
        list.setOnItemClickListener(new mItemClick());
    }
    //定义列表选项监听器
    class mItemClick implements AdapterView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
        {
            Toast.makeText(getApplicationContext(),
                    "您选择的项目是："+((TextView)arg1).getText(),
                    Toast.LENGTH_SHORT).show();
        }
    }
}

