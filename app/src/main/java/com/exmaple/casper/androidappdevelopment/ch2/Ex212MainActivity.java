package com.exmaple.casper.androidappdevelopment.ch2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex212MainActivity extends AppCompatActivity {
    Button okBtn;
    EditText edit;
    TextView txt;
    RadioButton r1, r2;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex212_main);
        edit = (EditText) findViewById(R.id.edit1);
        okBtn = (Button) findViewById(R.id.myButton);
        txt = (TextView) findViewById(R.id.text02);
        r1 = (RadioButton) findViewById(R.id.boy01);
        r2 = (RadioButton) findViewById(R.id.girl01);
        okBtn.setOnClickListener(new mClick());
    }
    class mClick implements View.OnClickListener
    {
        public void onClick(View v)
        {
            CharSequence str = "",name = "";
            name = edit.getText();
            if (r1.isChecked())
                str = r1.getText();
            if (r2.isChecked())
                str = r2.getText();
            txt.setText("您输入的信息为: \n 姓名 " + name + "\t 性别 " + str);
        }
    }
}
