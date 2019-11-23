package com.exmaple.casper.androidappdevelopment.ch2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex210MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Button btn1,btn2;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex210_main);
        progressBar = (ProgressBar)findViewById(R.id.ProgressBar01);
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        btn1.setOnClickListener(new click1());
        btn2.setOnClickListener(new click2());
    }
    class click1 implements View.OnClickListener
    {
        public void onClick(View v)
        { progressBar.incrementProgressBy(5);  }
    }
    class click2 implements View.OnClickListener
    {
        public void onClick(View v)
        { progressBar.incrementProgressBy(-5);  }
    }
}
