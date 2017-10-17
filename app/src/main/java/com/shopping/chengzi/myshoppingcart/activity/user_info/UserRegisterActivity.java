package com.shopping.chengzi.myshoppingcart.activity.user_info;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.shopping.chengzi.myshoppingcart.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 用户注册
 */

public class UserRegisterActivity extends Activity {

    @BindView(R.id.register)
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.register} )
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register:
                break;
        }
    }
}
