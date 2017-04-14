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
    private TextView tvName;
    private TextView tvMsg;

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
        TypedArray t = context.obtainStyledAttributes(attrs, R.styleable.PersonalItemLayout, 0, 0);
        String name = t.getString(R.styleable.PersonalItemLayout_item_name);
        String msg = t.getString(R.styleable.PersonalItemLayout_item_msg);
        t.recycle();

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(xmlRes, this, false);

        tvName = (TextView) view.findViewById(R.id.tv_name);
        setName(name);
        tvMsg = (TextView) view.findViewById(R.id.tv_msg);
        setMsg(msg);
        addView(view);
    }

    public void setMsg(String msg) {
        tvMsg.setText(msg);
    }

    public void setName(String name) {
        tvName.setText(name);
    }

    private String getMsg() {
        return tvMsg.getText().toString();
    }

    private String getName() {
        return tvName.getText().toString();
    }

}
