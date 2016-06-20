package com.kevin.zwk.kt_customview_qianming_0620_1;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016/6/20.
 */
public class MyCustomView extends View {
    private int mWight;
    private int mHeight;
    private Paint mPaintLine;
    private Path mPath;

    public MyCustomView(Context context) {
        super(context);
        init();
    }


    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyCustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaintLine = new Paint();
        mPaintLine.setColor(Color.BLACK);
        mPaintLine.setStrokeWidth(15);
        mPaintLine.setStyle(Paint.Style.STROKE);
        mPaintLine.setStrokeCap(Paint.Cap.ROUND);

        mPath = new Path();//新生成的路径


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWight = getWidth();
        mHeight = getHeight();
    }


    /**
     * 为了拦截消费事件
     *
     * @param event
     * @return 设置为true 设置为要消费触摸事件
     */
    private float startX;
    private float startY;
    private float moveX;
    private float moveY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();//手指按下时，X轴的位置 浮点型
                startY = event.getY();//Y轴位置
                Log.i("tag", "___Down___X" + startX + "_Y_" + startY);
                //设置路径的起始点
                mPath.moveTo(startX, startY);
                break;
            case MotionEvent.ACTION_MOVE:
                moveX = event.getX();
                moveY = event.getY();
                Log.i("tag", "___Move___X" + moveX + "_Y_" + moveY);


                mPath.lineTo(moveX, moveY);

                invalidate();//重新绘制
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawLine(startX, startY, moveX, moveY, mPaintLine);

        //路径 添加多个线段，二次曲线
        canvas.drawPath(mPath, mPaintLine);
    }

    public void reset() {
        mPath.reset();
        invalidate();
    }
}
