package com.teemo.sorttest.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by Asus on 2017/4/5.
 */

public class BeautifulLayout extends ViewGroup {
    private int totleHeight;
    private int maxChildWidth;

    public BeautifulLayout(Context context) {
        this(context, null);
    }

    public BeautifulLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BeautifulLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (getChildCount() > 0) {
            for (int i = 0; i < getChildCount(); i++) {
//                getChildAt(i).layout();
            }
        }
    }

    public int getTotleHeight() {
        return totleHeight;
    }

    public int getMaxChildWidth() {
        return maxChildWidth;
    }
}
