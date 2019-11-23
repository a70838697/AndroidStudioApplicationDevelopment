package com.exmaple.casper.androidappdevelopment.ch4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex44MainActivity extends AppCompatActivity {

    Ex44TestView testView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex44_main);
        testView =(Ex44TestView)findViewById(R.id.testview1);
        testView.setOnTouchListener(new mOnTouch());
    }

    private class mOnTouch implements View.OnTouchListener {
        public boolean onTouch(View v, MotionEvent event) {
            int x1,y1;
            if (event.getAction() == MotionEvent.ACTION_MOVE) {
                x1 = (int) event.getX();
                y1 = (int) event.getY();
                testView.getXY(x1, y1);
                testView.invalidate();
                return true;
            }
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                x1 = (int) event.getX();
                y1 = (int) event.getY();
                testView.getXY(x1, y1);
                testView.invalidate();
                return true;
            }
            return testView.onTouchEvent(event);
        }
    }
}
