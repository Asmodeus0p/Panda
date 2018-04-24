package com.jiyun.asmodeus.panda;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import cn.jpush.android.api.JPushInterface;

public class App extends Application {
    public  static AppCompatActivity context;
    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}
