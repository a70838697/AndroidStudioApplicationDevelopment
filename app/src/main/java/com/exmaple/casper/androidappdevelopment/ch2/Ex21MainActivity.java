package com.exmaple.casper.androidappdevelopment.ch2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex21MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex21_main);
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setTextColor(Color.BLUE);

    }

}
