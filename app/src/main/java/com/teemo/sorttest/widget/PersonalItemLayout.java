package com.teemo.sorttest.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.teemo.sorttest.R;

/**
 * Created by Asus on 2017/4/13.
 */

public class PersonalItemLayout extends RelativeLayout {

    private int xmlRes = R.layout.layout_item;

    public PersonalItemLayout(Context context) {
        this(context, null);
    }

    public PersonalItemLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PersonalItemLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray t = context.obtainStyledAttributes(attrs,R.styleable.PersonalItemLayout,0,0);
        String name = t.getString(R.styleable.PersonalItemLayout_item_name);
        String msg = t.getString(R.styleable.PersonalItemLayout_item_msg);
        t.recycle();

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(xmlRes, this, false);
        TextView tvName = (TextView) view.findViewById(R.id.tv_name);
        tvName.setText(name);
        TextView tvMsg = (TextView) view.findViewById(R.id.tv_msg);
        tvMsg.setText(msg);
        addView(view);
    }

}
