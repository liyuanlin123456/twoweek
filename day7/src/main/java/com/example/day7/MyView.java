package com.example.day7;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {
    private Paint mPaint;
    private int circleX;
    private int circleY;
    private int mRaduis=100;
    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);//抗锯齿
        mPaint.setStyle(Paint.Style.STROKE);//空心
        mPaint.setStrokeWidth(20);
    }
    /*
    * 测量
    * */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /*
    * 在onmeasure之后
    * */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    /*
    * 摆放
    * */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
    /*
    * 绘制
    * */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(circleX,circleY,mRaduis,mPaint);
    }
    /*
    * 触摸事件
    * */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN://按下
                circleX= (int) event.getX();
                circleY= (int) event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE://滑动
                circleX= (int) event.getX();
                circleY= (int) event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_UP://抬起
                circleX= (int) event.getX();
                circleY= (int) event.getY();
                invalidate();
                break;
        }
        return true;
    }
}
