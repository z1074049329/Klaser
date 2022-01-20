package com.app.klaser;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.app.klaser.home.activity.HomeActivity;

/**
 * 加载页
 */
public class SplashActivity extends Activity {

    private static final int SPLASH_DISPLAY_LENGHT= 2000;    //延迟2秒

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);//去掉标题
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);	//第二个参数即为执行完跳转后的Activity
                startActivity(intent);
                SplashActivity.this.finish();   //关闭splashActivity，将其回收，否则按返回键会返回此界面
            }
        }, SPLASH_DISPLAY_LENGHT);
    }
}



