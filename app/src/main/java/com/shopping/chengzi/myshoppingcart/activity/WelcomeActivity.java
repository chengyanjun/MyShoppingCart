package com.shopping.chengzi.myshoppingcart.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.shopping.chengzi.myshoppingcart.MainActivity;
import com.shopping.chengzi.myshoppingcart.R;

public class WelcomeActivity extends AppCompatActivity {

    protected static final String tag = "WelcomeActivity";

    ImageView welcomeLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        welcomeLogo = (ImageView) findViewById(R.id.iv_welcome_logo);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.enlarge);
        animation.setFillAfter(true);
        welcomeLogo.startAnimation(animation);


        final SharedPreferences sharedPreferences = getSharedPreferences("config", Context.MODE_PRIVATE);

        //发送一个颜色的消息
        new Handler() {
            public void handleMessage(android.os.Message msg) {
                //接受到消息后的处理
                boolean b = sharedPreferences.getBoolean("is_first", true);

                if (b) {
                    //第一次进入应用，进入导航界面
                    sharedPreferences.edit().putBoolean("is_first", false).commit();
                    Intent intent = new Intent(WelcomeActivity.this, GuideActivity.class);
                    startActivity(intent);
                    Log.i(tag, "是第一次进入");
                } else {
                    //不是第一次进入应用,直接跳转到主界面
                    Log.i(tag, "是第二次进入");
                    Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                    startActivity(intent);
                }

                finish();
            }
        }.sendEmptyMessageDelayed(0, 3000);
    }
}
