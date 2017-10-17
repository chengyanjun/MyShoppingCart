package com.shopping.chengzi.myshoppingcart.activity.user_info;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.Selection;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.shopping.chengzi.myshoppingcart.R;
import com.shopping.chengzi.myshoppingcart.https.ParseJson;
import com.shopping.chengzi.myshoppingcart.utils.LogUtil;
import com.shopping.chengzi.myshoppingcart.utils.ToastUtil;
import com.shopping.chengzi.myshoppingcart.utils.Url;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 用户登陆界面
 */

public class LoginActivity extends Activity implements CompoundButton.OnCheckedChangeListener {

    @BindView(R.id.phone_register)
    TextView phoneRegister;//用户注册
    @BindView(R.id.forget_pass)
    TextView forgetPass;//忘记密码
    @BindView(R.id.user_name)
    EditText userName;//用户名
    @BindView(R.id.user_pass)
    EditText userPassWord;//用户密码
    @BindView(R.id.login)
    TextView login;//登录按钮
    @BindView(R.id.iv_login_back)
    ImageView back;//后退按钮

    @BindView(R.id.pass_view_toggle)
    ToggleButton tbPassword;

    boolean isPasswordHide = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        tbPassword.setChecked(isPasswordHide);
        tbPassword.setOnCheckedChangeListener(this);
    }

    @OnClick({R.id.phone_register, R.id.forget_pass, R.id.login,R.id.iv_login_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.phone_register:
                startActivity(new Intent(this, UserRegisterActivity.class));
                break;
            case R.id.forget_pass:
                startActivity(new Intent(this, ForgetPasswordActivity.class));
                break;
            case R.id.login:
                getLoginData();
                break;
            case R.id.iv_login_back:
                finish();
                break;
        }
    }

    private void getLoginData() {

        String nameStr = userName.getText().toString();
        String passStr = userPassWord.getText().toString();
        if (!checkInput(nameStr, passStr)) return;

        OkHttpUtils.post()
                .url(Url.HOST + Url.LOGIN)
                .addParams("username", nameStr)
                .addParams("password", passStr)
                .addParams("client", "android")
                .build().execute(new LoginCallBack());
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (!isPasswordHide) {
            userPassWord.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            Editable etable = userPassWord.getText();
            Selection.setSelection(etable, etable.length());
        } else {
            userPassWord.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            Editable etable = userPassWord.getText();
            Selection.setSelection(etable, etable.length());
        }
        isPasswordHide = !isPasswordHide;
    }

    private boolean checkInput(String nameStr, String passStr) {
        if (nameStr.equals("") || passStr.equals("")) {
            ToastUtil.showShort(this, "请输入完整信息");
            return false;
        }
        return true;
    }

    private class LoginCallBack extends StringCallback {
        @Override
        public void onError(Request request, Exception e) {

        }

        @Override
        public void onResponse(String response) {
            LogUtil.i("登录信息返回===" + response.toString());
            ParseJson parseJson = new ParseJson(response);
            parseJson.parseLogin(getApplicationContext(),response);
            Url.NUM_MAIN_ACTIVITY_CART = true;
            finish();
//            ToastUtil.showShort(LoginActivity.this, JsonMessage.jsonMsg(response.toString()));
        }
    }
}

