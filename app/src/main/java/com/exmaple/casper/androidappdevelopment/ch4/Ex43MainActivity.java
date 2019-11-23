package com.exmaple.casper.androidappdevelopment.ch4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex43MainActivity extends AppCompatActivity {

    Ex43TestView tView = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tView =(Ex43TestView)findViewById(R.id.testview1);
        setContentView(R.layout.activity_ex43_main);
    }

}
