package com.exmaple.casper.androidappdevelopment.ch3;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex35MainActivity extends AppCompatActivity {
    ProgressDialog mydialog;
    Button btn1,btn2;
    LinearLayout login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex35_main);
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        btn1.setOnClickListener(new mClick());
        btn2.setOnClickListener(new mClick());
    }
    class mClick implements View.OnClickListener
    {
        AlertDialog.Builder dialog=new AlertDialog.Builder(Ex35MainActivity.this);
        @Override
        public void onClick(View arg0)
        {
            if(arg0 == btn1)
            {
                //设置对话框的标题
                dialog.setTitle("警告");
                //设置对话框的图标
                dialog.setIcon(R.drawable.icon1);
                //设置对话框显示的内容
                dialog.setMessage("本项操作可能导致信息泄漏！");
                //设置对话框的“确定”按钮
                dialog.setPositiveButton("确定", new okClick());
                //创建对象框
                dialog.create();
                //显示对象框
                dialog.show();
            }
            else  if(arg0 == btn2)
            {
                login = (LinearLayout)getLayoutInflater().inflate(R.layout.ex35login, null);

                dialog.setTitle("用户登录").setMessage("请输入用户名和密码")
                        .setView(login);
                dialog.setPositiveButton("确定", new loginClick());
                dialog.setNegativeButton("退出", new exitClick());
                dialog.setIcon(R.drawable.icon2);
                dialog.create();
                dialog.show();
            }
        }
    }
    /*  普通对话框的“确定”按钮事件 */
    class okClick implements DialogInterface.OnClickListener
    {
        @Override
        public void onClick(DialogInterface dialog, int which)
        {
            dialog.cancel();
        }
    }
    /*  输入对话框的“确定”按钮事件   */
    class loginClick implements  DialogInterface.OnClickListener
    {
        EditText txt;
        @Override
        public void onClick(DialogInterface dialog, int which)
        {
            txt = (EditText)login.findViewById(R.id.paswdEdit);
            //取出输入编辑框的值与密码“admin”比较
            if((txt.getText().toString()).equals("admin"))
                Toast.makeText(getApplicationContext(),
                        "登录成功", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getApplicationContext(),
                        "密码错误", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        }
    }
    /*  输入对话框的“退出”按钮事件   */
    class exitClick implements DialogInterface.OnClickListener
    {
        @Override
        public void onClick(DialogInterface dialog, int which)
        {
            Ex35MainActivity.this.finish();
        }
    }



}
