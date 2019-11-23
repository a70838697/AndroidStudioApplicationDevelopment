package com.exmaple.casper.androidappdevelopment.ch4;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex41MainActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        TestView tView=new TestView(this);
        setContentView(tView);
    }
    private class TestView extends View
    {
        public TestView(Context context)
        {
            super(context);
        }
        /*重写onDraw（）*/
        @Override
        protected void onDraw(Canvas canvas)
        {
            /*设置背景为青色*/
            canvas.drawColor(Color.CYAN);
            Paint paint=new Paint();
            /*设置画笔宽度*/
            paint.setStrokeWidth(3);
            /*设置画空心图形*/
            paint.setStyle(Paint.Style.STROKE);
            /*去锯齿*/
            paint.setAntiAlias(true);
            /*画空心矩形（正方形）*/
            canvas.drawRect(10,10,70,70,paint);
            /*设置画实心图形*/
            paint.setStyle(Paint.Style.FILL);
            /*画实心矩形（正方形）*/
            canvas.drawRect(100,10,170,70,paint);
            /*设置画笔颜色为蓝色*/
            paint.setColor(Color.BLUE);
            /*画圆心为（100，120），半径为30的实心圆*/
            canvas.drawCircle(100,120,30,paint);
            /*在上面的实心圆上画一个小白点*/
            paint.setColor(Color.WHITE);
            canvas.drawCircle(91,111,6,paint);
            /*设置画笔颜色为红色*/
            paint.setColor(Color.RED);
            /*画三角形*/
            Path path=new Path();
            path.moveTo(100, 170);
            path.lineTo(70, 230);
            path.lineTo(130,230);
            path.close();
            canvas.drawPath(path,paint);
            /*文字*/
            paint.setTextSize(28);
            paint.setColor(Color.BLUE);
            canvas.drawText(getResources().getString(R.string.hello_world),
                    30,270,paint);
        }
    }
}

