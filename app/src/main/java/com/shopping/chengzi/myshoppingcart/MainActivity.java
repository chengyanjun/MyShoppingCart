package com.shopping.chengzi.myshoppingcart;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.shopping.chengzi.myshoppingcart.fragment.FragmentClassify;
import com.shopping.chengzi.myshoppingcart.fragment.FragmentHome;
import com.shopping.chengzi.myshoppingcart.fragment.FragmentMy;
import com.shopping.chengzi.myshoppingcart.fragment.FragmentShoppingCart;

import java.lang.reflect.InvocationTargetException;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.shopping.chengzi.myshoppingcart.R.id.rg_tab_bar;


public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(rg_tab_bar)
    RadioGroup mController;
    @BindView(R.id.rb_home)
    RadioButton rbHome;
    @BindView(R.id.rb_classify)
    RadioButton rbClassify;
    @BindView(R.id.rb_shopping_cart)
    RadioButton rbCart;
    @BindView(R.id.rb_my)
    RadioButton rbMy;

    private Fragment mCacheFragment;//承载fragment的布局

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initSettings();

    }

    private void initSettings() {

        if (mController!=null){
            mController.setOnCheckedChangeListener(this);
        }
        /**
         * Fragment动态加载
         * ① 获取FragmentManager
         * ② 开启Fragment事务（需保证整个事务可执行完成，如果其中一个环节出错误，那么先前的操作会被回滚）
         * ③ 在事务中添加自己的操作（hide show add replace）
         * ④ 提交事务（每个事物只能被提交一次）
         */
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction tr = fm.beginTransaction();
        mCacheFragment = new FragmentHome();
        tr.add(R.id.main_container, mCacheFragment);
        tr.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                switchPage(FragmentHome.TAG, FragmentHome.class);
                break;
            case R.id.rb_classify:
                switchPage(FragmentClassify.TAG, FragmentClassify.class);
                break;
            case R.id.rb_shopping_cart:
                switchPage(FragmentShoppingCart.TAG, FragmentShoppingCart.class);
                break;
            case R.id.rb_my:
                switchPage(FragmentMy.TAG, FragmentMy.class);
                break;
            default:
                break;
        }
    }
    public void switchPage(String tag, Class<? extends Fragment> cls) {
        // 切换页面
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        // 隐藏当前显示的页面
        if (mCacheFragment != null) {
            transaction.hide(mCacheFragment);
        }
        // 去FragmentManager的栈中查找将要显示的页面是否存在
        mCacheFragment = fm.findFragmentByTag(tag);
        if (mCacheFragment != null) {
            // 显示要显示的页面
            transaction.show(mCacheFragment);
        } else {
            try {
                mCacheFragment = cls.getConstructor().newInstance();
                transaction.add(R.id.main_container, mCacheFragment, tag);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        transaction.commit();
    }
}

