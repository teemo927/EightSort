package com.teemo.sorttest.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.teemo.sorttest.R;

public class MultimediaActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_VIDEO_CAPTURE = 1;
    private static final String TAG = "MultimediaActivity";
    private Context mContext;
    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_multimedia);

        initView();
    }

    private void initView() {
        mVideoView = (VideoView) findViewById(R.id.video_view);
        findViewById(R.id.btn_video).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_video) {
            takeVideo();
        }
    }

    private void takeVideo() {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
        //先调用resolveActivity()，这个方法会返回能处理该Intent的第一个Activity（译注：即检查有没有能处理这个Intent的Activity）。
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_VIDEO_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_VIDEO_CAPTURE) {
            Uri uri = data.getData();
            Log.e(TAG, uri.toString());
            playVideoView(uri);
        }
    }

    //调用系统自带的播放器
    private void playVideo(Uri uri) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Log.v("URI:::::::::", uri.toString());
        intent.setDataAndType(uri, "video/mp4");
        startActivity(intent);
    }

    //调用系统自带的播放器
    private void playVideoView(Uri uri) {
        mVideoView.setVideoURI(uri);
        mVideoView.setMediaController(new MediaController(this));
        mVideoView.start();
        mVideoView.requestFocus();
    }


}
