package com.exmaple.casper.androidappdevelopment.ch2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex27MainActivity extends AppCompatActivity {

    ImageView img1, img2, img3, img4, img5;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex27_main);
        img1 = (ImageView) this.findViewById(R.id.mImageView1);
        img2 = (ImageView) this.findViewById(R.id.mImageView2);
        img3 = (ImageView) this.findViewById(R.id.mImageView3);
        img4 = (ImageView) this.findViewById(R.id.mImageView4);
        img5 = (ImageView) this.findViewById(R.id.mImageView5);
        img1.setImageResource(R.drawable.img1);
        img2.setImageResource(R.drawable.img2);
        img3.setImageResource(R.drawable.img3);
        img4.setImageResource(R.drawable.img4);
        img5.setImageResource(R.drawable.img5);
    }

}
