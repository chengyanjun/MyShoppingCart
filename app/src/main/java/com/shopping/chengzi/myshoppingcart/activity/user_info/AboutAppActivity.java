package com.shopping.chengzi.myshoppingcart.activity.user_info;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.shopping.chengzi.myshoppingcart.R;
import com.shopping.chengzi.myshoppingcart.utils.InitTopBar;

/**
 * 关于app
 */
public class AboutAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
        InitTopBar.initiTopImg(this,"关于捡宝",R.mipmap.moresu);
    }
}
