package com.exmaple.casper.androidappdevelopment.ch3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex33MainActivity extends AppCompatActivity  {
    TextView txt;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex33_main);
        txt = (TextView)findViewById(R.id.textView1);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // 调用父类方法来加入系统菜单
        super.onCreateOptionsMenu(menu);
        // 添加菜单项
        menu.add(
                1,          //组号
                1,          //唯一的ID号
                1,          //排序号
                "菜单项1"); //标题
        menu.add( 1, 2, 2,  "菜单项2");
        menu.add( 1, 3, 3,  "菜单项3");
        menu.add( 1, 4, 4,  "菜单项4");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        String title = "选择了" + item.getTitle().toString();
        switch (item.getItemId())
        { //响应每个菜单项(通过菜单项的ID)
            case 1:
                txt.setText(title);
                break;
            case 2:
                txt.setText(title);
                break;
            case 3:
                txt.setText(title);
                break;
            case 4:
                txt.setText(title);
                break;
            default:
                //对没有处理的事件，交给父类来处理
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

}
