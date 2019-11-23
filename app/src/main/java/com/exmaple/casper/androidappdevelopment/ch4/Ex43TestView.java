package com.exmaple.casper.androidappdevelopment.ch4;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
class Ex43TestView extends View
{
    public Ex43TestView(Context context, AttributeSet attrs)
    {   super(context, attrs);  }
    /* 重写View的抽象方法 onDraw()方法  */
    protected void onDraw(Canvas canvas)
    {
        canvas.drawColor(Color.CYAN);  //设置组件的背景颜色为青色
        Paint paint=new Paint();       //定义画笔
        paint.setStyle(Paint.Style.FILL); //设置画实心图形
        paint.setAntiAlias(true);     //去锯齿
        paint.setColor(Color.BLUE); /*设置画笔颜色为蓝色*/
        canvas.drawCircle(100,120,30,paint); /*圆心为（100，120），半径为30的实心圆*/
        paint.setColor(Color.WHITE); /*在上面的实心圆上画一个小白点*/
        canvas.drawCircle(91,111,6,paint);
    }
}
