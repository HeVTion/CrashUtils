package com.test.myapplication4;

import android.app.Application;

import com.hvx.crashlibrary.CrashHandler;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        CrashHandler.getInstance()
                .init(this) //初始化
                .setDebug(BuildConfig.DEBUG)//apk包是正式包还是测试包
                .setJumpError(true)//是否跳转指定页面
                .setCrashListener(ex -> {

                });//设置监听
    }
}
