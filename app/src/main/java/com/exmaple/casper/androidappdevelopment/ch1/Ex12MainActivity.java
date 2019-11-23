package com.exmaple.casper.androidappdevelopment.ch1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex12MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.moli);
        setContentView(imageView);
   }
}
