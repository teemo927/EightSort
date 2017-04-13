package com.teemo.sorttest.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.teemo.sorttest.R;

public class PersonalActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        initView();
    }

    private void initView() {
        View viewName = findViewById(R.id.l_name);
        viewName.setOnClickListener(this);
//        TextView tvNameN = (TextView) viewName.findViewById(R.id.tv_name);
//        TextView tvMsgN = (TextView) viewName.findViewById(R.id.tv_msg);
//        tvNameN.setText("姓名");
//        tvMsgN.setText("其他");

        View vPhone = findViewById(R.id.l_photo);
        vPhone.setOnClickListener(this);
//        TextView tvNameP = (TextView) vPhone.findViewById(R.id.tv_name);
//        TextView tvMsgP = (TextView) vPhone.findViewById(R.id.tv_msg);
//        tvNameP.setText("图像");
//        tvMsgP.setText("选择");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.l_name:
                switchFragment();
                break;
            case R.id.l_photo:
                switchFragment();
                break;
        }
    }

    private void switchFragment() {

    }
}
