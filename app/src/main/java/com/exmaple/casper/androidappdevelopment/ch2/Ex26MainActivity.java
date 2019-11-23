package com.exmaple.casper.androidappdevelopment.ch2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex26MainActivity extends AppCompatActivity {

    ImageView imageview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex26_main);
        imageview = (ImageView) this.findViewById(R.id.mImageView);
        imageview.setImageResource(R.drawable.moli);
    }

}
