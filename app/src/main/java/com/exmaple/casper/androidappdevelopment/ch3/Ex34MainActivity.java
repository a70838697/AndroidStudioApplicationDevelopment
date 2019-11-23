package com.exmaple.casper.androidappdevelopment.ch3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex34MainActivity extends AppCompatActivity {

    TextView txt1, txt2, txt3;
    private static final int item1 = Menu.FIRST;
    private static final int item2 = Menu.FIRST+1;
    private static final int item3 = Menu.FIRST+2;
    String  str[] = {" 令狐冲", "杨   过", "萧   峰 "  };
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex34_main);
        txt1=(TextView)findViewById(R.id.textView1);
        txt2=(TextView)findViewById(R.id.textView2);
        txt3=(TextView)findViewById(R.id.textView3);
        txt1.setText(str[0].toString());
        txt2.setText(str[1].toString());
        txt3.setText(str[2].toString());
        registerForContextMenu(txt1);
        registerForContextMenu(txt2);
        registerForContextMenu(txt3);
    }
    //上下文菜单，本例会通过长按条目激活上下文菜单
    @Override
    public void onCreateContextMenu(ContextMenu menu, View view,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("人物简介");
        //添加菜单项
        menu.add(0, item1, 0, "武功");
        menu.add(0, item2, 0, "战斗力");
        menu.add(0, item3, 0, "经典语录");
    }
    //菜单单击响应
    @Override
    public boolean onContextItemSelected(MenuItem item){
        //获取当前被选择的菜单项的信息
        switch(item.getItemId())
        {
            case item1:
                //在这里添加处理代码
                break;
            case item2:
                //在这里添加处理代码
                break;
            case item3:
                //在这里添加处理代码
                break;
        }
        return true;
    }

}
