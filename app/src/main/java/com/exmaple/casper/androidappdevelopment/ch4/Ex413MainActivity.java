package com.exmaple.casper.androidappdevelopment.ch4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex413MainActivity extends AppCompatActivity {
    Button rotateButton,alphaButton,scaleButton;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex413_main);
        img = (ImageView)findViewById(R.id.imageView);
        rotateButton = (Button)findViewById(R.id.button1);
        alphaButton = (Button)findViewById(R.id.button2);
        scaleButton = (Button)findViewById(R.id.button3);
        rotateButton.setOnClickListener(new mClick());
        alphaButton.setOnClickListener(new mClick());
        scaleButton.setOnClickListener(new mClick());
    }

    public class mClick implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            if(v == rotateButton) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(img, "rotation", 0.0F, 360.0F);
                animator.setDuration(1000);
                animator.start();
            }
            else if(v == alphaButton){
                ObjectAnimator animator = ObjectAnimator.ofFloat(img, "alpha",1.0F, 0.0F, 1.0F);
                animator.setDuration(3000);
                animator.start();
            }
            else if(v == scaleButton){
                ObjectAnimator animator = ObjectAnimator.ofFloat(img, "ScaleY", 1.0F, 0.5F, 1.0F);
                animator.setDuration(5000);
                animator.start();
            }
        }
    }

}
