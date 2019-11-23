package com.exmaple.casper.androidappdevelopment.ch4;

import android.content.Context;
import android.graphics.*;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex45HandWrite extends View {
    Paint paint = null;             //定义画笔
    Bitmap originalBitmap = null;   //存放原始图像
    Bitmap new1_Bitmap = null;      //存放从原始图像复制的位图图像
    Bitmap new2_Bitmap = null;      //存放处理后的图像
    float startX = 0, startY = 0;    //画线的起点坐标
    float clickX = 0, clickY = 0;    //画线的终点坐标
    boolean isMove = true;        //设置是否画线的标记
    boolean isClear = false;        //设置是否清除涂鸦的标记
    int color = Color.GREEN;        //设置画笔的颜色（绿色）
    float strokeWidth = 2.0f;       //设置画笔的宽度

    public Ex45HandWrite(Context context, AttributeSet attrs) {
        super(context, attrs);
        originalBitmap = BitmapFactory
                .decodeResource(getResources(), R.drawable.cy).copy(Bitmap.Config.ARGB_8888, true);;
        new1_Bitmap = Bitmap.createBitmap(originalBitmap);
    }

    public void clear() {
        isClear = true;
        new2_Bitmap = Bitmap.createBitmap(originalBitmap);
        invalidate();
    }

    public void setstyle(float strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(HandWriting(new1_Bitmap), 0, 0, null);
    }

    public Bitmap HandWriting(Bitmap o_Bitmap) {
        Canvas canvas = null;
        if (isClear) {
            canvas = new Canvas(new2_Bitmap);
        } else {
            canvas = new Canvas(o_Bitmap);
        }
        paint = new Paint();
        paint.setStyle(Style.STROKE);
        paint.setAntiAlias(true);
        paint.setColor(color);
        paint.setStrokeWidth(strokeWidth);
        if (isMove) {
            canvas.drawLine(startX, startY, clickX, clickY, paint);
        }
        startX = clickX;
        startY = clickY;
        if (isClear) {
            return new2_Bitmap;
        }
        return o_Bitmap;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        clickX = event.getX();
        clickY = event.getY();
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            isMove = false;
            invalidate();
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            isMove = true;
            invalidate();
            return true;
        }
        return super.onTouchEvent(event);
    }
}

