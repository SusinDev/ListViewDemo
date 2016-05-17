package com.example.white.listviewdemo.util;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.ResponseHandlerInterface;

/**
 * Created by white on 2016/5/16.
 */
public class HttpUtil {

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, ResponseHandlerInterface responseHandler) {
        client.get(getAbsoluteUrl() + url, responseHandler);
    }

    private static String getAbsoluteUrl() {
        return "http://news-at.zhihu.com/api/4/";
    }


}
