package com.teemo.sorttest.http;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;

/**
 * Created by Asus on 2017/4/6.
 */

public class DownloadUtil {

    private DownloadManager manager;

    public void init(Context context, Uri uri) {

        String s = "";
        manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        long downloadId = manager.enqueue(request);

    }

}
