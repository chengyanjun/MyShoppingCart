package com.shopping.chengzi.myshoppingcart.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shopping.chengzi.myshoppingcart.R;
import com.shopping.chengzi.myshoppingcart.activity.GoodsAndShopsFocusActivity;
import com.shopping.chengzi.myshoppingcart.activity.order.ShowOrderActivity;
import com.shopping.chengzi.myshoppingcart.activity.user_info.AccountManageActivity;
import com.shopping.chengzi.myshoppingcart.activity.user_info.LoginActivity;
import com.shopping.chengzi.myshoppingcart.activity.user_info.SettingActivity;
import com.shopping.chengzi.myshoppingcart.adapter.AdapterMyTools;
import com.shopping.chengzi.myshoppingcart.utils.Url;
import com.shopping.chengzi.myshoppingcart.widget.GridViewInScrollView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMy extends Fragment {

    @BindView(R.id.ll_no_login)
    LinearLayout noLogin;//未登录状态

    @BindView(R.id.ll_account_manage)
    RelativeLayout accountManage;//已登陆界面
    @BindView(R.id.tv_account_setting)
    TextView accountSetting;

    @BindView(R.id.rl_my_order)
    RelativeLayout myOrder;//我的订单
    @BindView(R.id.rl_wait_payment)
    RelativeLayout waitPayment;//待付款
    @BindView(R.id.rl_already_payment)
    RelativeLayout alreadyPayment;//待发货
    @BindView(R.id.rl_wait_for_receive_goods)
    RelativeLayout waitForReceivePayment;//待收货
    @BindView(R.id.rl_wait_for_evaluate)
    RelativeLayout waitEvaluate;//待评价
    @BindView(R.id.rl_wait_for_tui_huo)
    RelativeLayout waitTuiHuo;//退款
    @BindView(R.id.rl_must_tools)
    RelativeLayout mustTools;//必备工具


    // 拥有一个公开的TAG
    public static final String TAG = FragmentMy.class.getSimpleName();

    private GridViewInScrollView gvMyTools;
    private AdapterMyTools adapterMyTools;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        ButterKnife.bind(this, view);
        InitView(view);
        getKey();
        return view;
    }

    /**
     * 判断登陆状态
     */
    private void getKey() {
        String key = Url.getKey(getActivity());
        if ("".equals(key)) {
            noLogin.setVisibility(View.VISIBLE);
            accountManage.setVisibility(View.GONE);
        } else {
            noLogin.setVisibility(View.GONE);
            accountManage.setVisibility(View.VISIBLE);
        }
    }

    @OnClick({R.id.ll_no_login, R.id.ll_account_manage, R.id.tv_account_setting, R.id.rl_my_order, R.id.rl_must_tools,
            R.id.rl_wait_payment, R.id.rl_already_payment, R.id.rl_wait_for_receive_goods, R.id.rl_wait_for_evaluate, R.id.rl_wait_for_tui_huo,})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_no_login://未登陆时跳转到登陆界面
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.ll_account_manage://跳转到账户管理界面
                startActivity(new Intent(getActivity(), AccountManageActivity.class));
                break;
            case R.id.tv_account_setting://跳转到账户设置
                if ("".equals(Url.getKey(getActivity()))) {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                } else {
                    startActivity(new Intent(getActivity(), SettingActivity.class));
                }
                break;
            case R.id.rl_my_order://我的订单
                if ("".equals(Url.getKey(getActivity()))) {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                } else {
                    Intent intent7 = new Intent(getActivity(), ShowOrderActivity.class);
                    intent7.putExtra(Url.ALL_ORDER, Url.ALL_ORDER);
                    startActivity(intent7);
                }
                break;
            case R.id.rl_wait_payment://待付款
                if ("".equals(Url.getKey(getActivity()))) {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                } else {
                    Intent intent1 = new Intent(getActivity(), ShowOrderActivity.class);
                    intent1.putExtra(Url.WAIT_PAYMENT, Url.WAIT_PAYMENT);
                    startActivity(intent1);
                }
                break;
            case R.id.rl_already_payment://待发货
                if ("".equals(Url.getKey(getActivity()))) {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                } else {
                    Intent intent3 = new Intent(getActivity(), ShowOrderActivity.class);
                    intent3.putExtra(Url.ALREADY_PAYMENT, Url.ALREADY_PAYMENT);
                    startActivity(intent3);
                }
                break;
            case R.id.rl_wait_for_receive_goods://待收货
                if ("".equals(Url.getKey(getActivity()))) {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                } else {
                    Intent intent4 = new Intent(getActivity(), ShowOrderActivity.class);
                    intent4.putExtra(Url.WAIT_RECEIVE, Url.WAIT_RECEIVE);
                    startActivity(intent4);
                }
                break;
            case R.id.rl_wait_for_evaluate://待评价
                if ("".equals(Url.getKey(getActivity()))) {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                } else {
                    Intent intent5 = new Intent(getActivity(), ShowOrderActivity.class);
                    intent5.putExtra(Url.WAIT_EVALUATE, Url.WAIT_EVALUATE);
                    startActivity(intent5);
                }
                break;
            case R.id.rl_wait_for_tui_huo://退货退款
                if ("".equals(Url.getKey(getActivity()))) {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                } else {
                    startActivity(new Intent(getActivity(), ShowOrderActivity.class));
                }
                break;
            case R.id.rl_must_tools://必备工具
                if ("".equals(Url.getKey(getActivity()))) {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                } else {
                    startActivity(new Intent(getActivity(), SettingActivity.class));
                }
                break;
        }
    }


    private void InitView(View view) {
        gvMyTools = (GridViewInScrollView) view.findViewById(R.id.gv_my_tools);
        adapterMyTools = new AdapterMyTools(getActivity());
        gvMyTools.setAdapter(adapterMyTools);
        gvMyTools.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0://收藏宝贝
                        if ("".equals(Url.getKey(getActivity()))) {
                            startActivity(new Intent(getActivity(), LoginActivity.class));
                        } else {
                            Intent intent = new Intent(getActivity(), GoodsAndShopsFocusActivity.class);
                            intent.putExtra("GOODS_FOCUS", "GOODS_FOCUS");
                            intent.putExtra("SHOP_FOCUS", "0");
                            startActivity(intent);
                        }
                        break;
                    case 1://收藏内容
                        if ("".equals(Url.getKey(getActivity()))) {
                            startActivity(new Intent(getActivity(), LoginActivity.class));
                        } else {
                            Intent intent2 = new Intent(getActivity(), GoodsAndShopsFocusActivity.class);
                            intent2.putExtra("GOODS_FOCUS", "0");
                            intent2.putExtra("SHOP_FOCUS", "SHOP_FOCUS");
                            startActivity(intent2);
                        }
                        break;
                    case 2://订单查询
                        if ("".equals(Url.getKey(getActivity()))) {
                            startActivity(new Intent(getActivity(), LoginActivity.class));
                        } else {
                            startActivity(new Intent(getActivity(), SettingActivity.class));
                        }
                        break;
                    case 3://卡券包
                        if ("".equals(Url.getKey(getActivity()))) {
                            startActivity(new Intent(getActivity(), LoginActivity.class));
                        } else {
                            startActivity(new Intent(getActivity(), SettingActivity.class));
                        }
                        break;
                    case 4://优惠券
                        if ("".equals(Url.getKey(getActivity()))) {
                            startActivity(new Intent(getActivity(), LoginActivity.class));
                        } else {
                            startActivity(new Intent(getActivity(), SettingActivity.class));
                        }
                        break;
                    case 5://会员中心
                        if ("".equals(Url.getKey(getActivity()))) {
                            startActivity(new Intent(getActivity(), LoginActivity.class));
                        } else {
                            startActivity(new Intent(getActivity(), SettingActivity.class));
                        }
                        break;
                    case 6://我是商家
                        if ("".equals(Url.getKey(getActivity()))) {
                            startActivity(new Intent(getActivity(), LoginActivity.class));
                        } else {
                            startActivity(new Intent(getActivity(), SettingActivity.class));
                        }
                        break;
                    case 7://足迹
                        if ("".equals(Url.getKey(getActivity()))) {
                            startActivity(new Intent(getActivity(), LoginActivity.class));
                        } else {
                            startActivity(new Intent(getActivity(), SettingActivity.class));
                        }
                        break;
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        getKey();//判断登陆状态
    }
}
