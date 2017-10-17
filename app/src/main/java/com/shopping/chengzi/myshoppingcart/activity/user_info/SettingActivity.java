package com.shopping.chengzi.myshoppingcart.activity.user_info;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.utils.StorageUtils;
import com.shopping.chengzi.myshoppingcart.R;
import com.shopping.chengzi.myshoppingcart.utils.InitTopBar;
import com.shopping.chengzi.myshoppingcart.utils.LogUtil;
import com.shopping.chengzi.myshoppingcart.utils.SPUtil;
import com.shopping.chengzi.myshoppingcart.utils.ToastUtil;
import com.shopping.chengzi.myshoppingcart.utils.Url;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 设置界面
 */
public class SettingActivity extends Activity {

    @BindView(R.id.tv_exit_login)
    TextView exitLogin;
    @BindView(R.id.rl_clear_cache)
    RelativeLayout clearCache;
    @BindView(R.id.about_app)
    RelativeLayout aboutApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        InitTopBar.initiTopText(this, "设置");
    }

    @OnClick({R.id.tv_exit_login, R.id.rl_clear_cache, R.id.about_app})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_exit_login:
                exitLogin();
                break;
            case R.id.rl_clear_cache://清除缓存
                AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);
                builder.setMessage("确认要清除缓存吗?");
                builder.setTitle("提示");

                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        File cacheDir = StorageUtils.getOwnCacheDirectory(getApplicationContext(), "yuanfengBBC/Cache");
                       if (deleteAllFile(cacheDir)) {
                            ToastUtil.showShort(getApplicationContext(), "清除缓存成功");
                        } else {
                           ToastUtil.showShort(getApplicationContext(), "清除缓存失败");
                        }

                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();

                break;
            case R.id.about_app:
                startActivity(new Intent(this, AboutAppActivity.class));
                break;
        }
    }

    private boolean deleteAllFile(File dir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (!deleteAllFile(file)) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    private void exitLogin() {
        OkHttpUtils.post()
                .url(Url.HOST + Url.LOGOUT)
                .addParams("username", Url.getUserId(this))
                .addParams("key", Url.getKey(this))
                .addParams("client", "android")
                .build().execute(new exitLoginCallBack());


        LogUtil.i("退出key" + Url.getKey(this));
    }

    private class exitLoginCallBack extends StringCallback {
        @Override
        public void onError(Request request, Exception e) {
            ToastUtil.showShort(getApplication(), "退出登录失败");
        }

        @Override
        public void onResponse(String response) {
            LogUtil.i("退出登录===" + response.toString());
            ToastUtil.showShort(getApplicationContext(), "退出登录成功");
            Url.NUM_MAIN_ACTIVITY_CART = true;
            SPUtil.clear(getApplicationContext());
            SettingActivity.this.finish();
            Url.NUM_MAIN_ACTIVITY_CART = true;
            SPUtil.clear(SettingActivity.this);
            finish();

        }
    }
}
