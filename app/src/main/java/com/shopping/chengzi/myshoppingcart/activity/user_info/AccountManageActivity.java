package com.shopping.chengzi.myshoppingcart.activity.user_info;

import android.app.Activity;
import android.os.Bundle;

import com.shopping.chengzi.myshoppingcart.R;
import com.shopping.chengzi.myshoppingcart.utils.InitTopBar;

/**
 * 账户管理界面
 */
public class AccountManageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_manage);
        InitTopBar.initiTopText(this,"个人资料");
    }
}
