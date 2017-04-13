package com.teemo.sorttest.widget;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Asus on 2017/4/7.
 */

public class TaiGi extends View {

    private static final String TAG = "TaiGi";
    private Paint whitePaint;
    private Paint blackPaing;
    private float degrees;

    public TaiGi(Context context) {
        this(context, null);
    }

    public TaiGi(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TaiGi(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        whitePaint = new Paint();
        whitePaint.setStrokeWidth(20);
        whitePaint.setAntiAlias(true);
        whitePaint.setColor(Color.WHITE);

        blackPaing = new Paint(whitePaint);
        blackPaing.setColor(Color.BLACK);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int cx = canvas.getWidth() / 2;
        int cy = canvas.getHeight() / 2;

        //绘制背景色
        canvas.drawColor(Color.GRAY);
        //将画布移动到中心
        canvas.translate(cx, cy);

        //设置完背景色之后让Canvas旋转
        degrees += 0.1;
        canvas.rotate(degrees);

        //绘制两个半圆
        int radius = Math.min(cx, cy);
        RectF oval = new RectF(-radius, -radius, radius, radius);
        canvas.drawArc(oval, 0, 180, true, whitePaint);
        canvas.drawArc(oval, 180, 180, false, blackPaing);

        //绘制两个小圆
        int smallRadius = radius / 2;    //小圆半径为大圆的一般
        canvas.drawCircle(smallRadius, 0, smallRadius, blackPaing);
        canvas.drawCircle(-smallRadius, 0, smallRadius, whitePaint);

        //绘制鱼眼（两个更小的圆）
        int ssRadius = smallRadius / 4;
        canvas.drawCircle(smallRadius, 0, ssRadius, whitePaint);
        canvas.drawCircle(-smallRadius, 0, ssRadius, blackPaing);

        postInvalidateDelayed(1);
    }


}
