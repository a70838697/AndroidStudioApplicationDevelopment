package com.exmaple.casper.androidappdevelopment.ch3;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex36MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex36_main);
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        btn1.setOnClickListener(new mClick());
        btn2.setOnClickListener(new mClick());
        btn3.setOnClickListener(new mClick());
    }
    class mClick implements View.OnClickListener
    {
        int m_year = 2012;
        int m_month = 1;
        int m_day = 1;
        int m_hour = 12,   m_minute = 1;
        @Override
        public void onClick(View v)
        {
            if(v == btn1)
            {
                ProgressDialog d=new ProgressDialog (Ex36MainActivity.this);
                d.setTitle("进度对话框");
                d.setIndeterminate(true);
                d.setMessage("程序正在Loading...");
                d.setCancelable(true);
                d.setMax(10);
                d.show();
            }
            else  if(v == btn2)
            {
                //设置日期监听器
                DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener()
                {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth)
                    {
                        m_year = year;
                        m_month = monthOfYear;
                        m_day = dayOfMonth;
                    }
                };
                //创建日期对话框对象
                DatePickerDialog date = new DatePickerDialog(Ex36MainActivity.this,
                        dateListener, m_year, m_month, m_day);
                date.setTitle("日期对话框");
                date.show();
            }
            else  if(v == btn3)
            {    //设置时间监听器
                TimePickerDialog.OnTimeSetListener timeListener = new TimePickerDialog.OnTimeSetListener()
                {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute)
                    {
                        m_hour = hourOfDay;
                        m_minute = minute;
                    }
                };
                TimePickerDialog d = new TimePickerDialog(Ex36MainActivity.this,
                        timeListener, m_hour, m_minute, true);
                d.setTitle("时间对话框");
                d.show();
            }
        }
    }

}
