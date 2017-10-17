package com.shopping.chengzi.myshoppingcart.activity.user_info;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.ybq.android.spinkit.SpinKitView;
import com.shopping.chengzi.myshoppingcart.R;

/**
 * 用户设置界面
 */
public class UserSettingActivity extends AppCompatActivity {

    SpinKitView spinKitView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setting);

        spinKitView = (SpinKitView) findViewById(R.id.spin_kit);
        spinKitView.setColor(R.color.background_red);

    }
}
