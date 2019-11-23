package com.exmaple.casper.androidappdevelopment.ch4;
import android.util.AttributeSet;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Ex42TestView extends View
{
    int x, y;
    public Ex42TestView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }
    void setXY(int _x, int _y)
    {
        x = _x;
        y = _y;
    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        /*设置背景为青色*/
        canvas.drawColor(Color.CYAN);
        Paint paint=new Paint();
        /*去锯齿*/
        paint.setAntiAlias(true);
        /*设置paint的颜色*/
        paint.setColor(Color.BLACK);
        /*画一个实心圆*/
        canvas.drawCircle(x, y, 15, paint);
        /*画一个实心圆上的小白点*/
        paint.setColor(Color.WHITE);
        canvas.drawCircle(x-6, y-6, 3, paint);
    }
}
