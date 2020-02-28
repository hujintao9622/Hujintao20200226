package com.bawei.hujintao.widget;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/2/28 0028 下午 4:28
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
