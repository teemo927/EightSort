package com.teemo.sorttest.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 自定义德国国旗
 * Created by Asus on 2017/4/5.
 */

public class ClockView extends View {

    private static final String TAG = "ClockView";
    private double RATIO = 0.6;
    private int DEFAULT_WIDTH = 500;
    private int DEFAULT_HEIGHT = (int) (DEFAULT_WIDTH * RATIO);
    private Paint mPaint;

    public ClockView(Context context) {
        this(context, null);
    }

    public ClockView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getDefaultSize(DEFAULT_WIDTH, widthMeasureSpec);
        int height = getDefaultSize(DEFAULT_HEIGHT, heightMeasureSpec);
        Log.e(TAG, "height---:" + height + ", width:" + width);
        if (width * RATIO > height) {
            width = (int) (height / RATIO);
        } else {
            height = (int) (width * RATIO);
        }
        Log.e(TAG, "height:" + height + ", width:" + width);

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int left = getLeft();
        int top = getTop();
        int deng = getHeight() / 3;

        mPaint.setColor(Color.BLACK);
        canvas.drawRect(left, top, getRight(), top + deng, mPaint);
        mPaint.setColor(Color.RED);
        canvas.drawRect(left, top + deng, getRight(), top + 2 * deng, mPaint);
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(left, top + 2 * deng, getRight(), getBottom(), mPaint);

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mPaint = null;
    }
}
