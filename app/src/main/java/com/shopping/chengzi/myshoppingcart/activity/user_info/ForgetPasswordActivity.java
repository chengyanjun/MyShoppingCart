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
 * 忘记密码
 */
public class ForgetPasswordActivity extends Activity {

    @BindView(R.id.forget_next_step)
    TextView nextStep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.forget_next_step})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.forget_next_step:
                startActivity(new Intent(this, ResetPasswordActivity.class));
                break;
        }
    }

}
