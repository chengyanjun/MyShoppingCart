package com.shopping.chengzi.myshoppingcart.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.alibaba.fastjson.JSON;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.shopping.chengzi.myshoppingcart.R;
import com.shopping.chengzi.myshoppingcart.adapter.AdapterGoodsFoucs;
import com.shopping.chengzi.myshoppingcart.bean.BeanGoodsFocus;
import com.shopping.chengzi.myshoppingcart.utils.LogUtil;
import com.shopping.chengzi.myshoppingcart.utils.ToastUtil;
import com.shopping.chengzi.myshoppingcart.utils.Url;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * 商品收藏
 */
public class GoodsFoucsFragment extends Fragment {

    private LRecyclerView rlGoodsFoucs;
    private AdapterGoodsFoucs adapterGoodsFoucs;
    private List<BeanGoodsFocus.DatasBean.FavoritesListBean> list = new ArrayList<>();
    private LRecyclerViewAdapter lReAdapter;

    private int totalNum = 0;
    private int currentNum = 0;
    int page = 1;

    private View waitLayout;//进度条
    private LinearLayout goodsFocusEmptyLayout;//没有商品的时候显示的layout

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goods_foucs, container, false);
        initView(view);
        getMyGoodsFocusData();//获取商品收藏数据
        return view;
    }

    private void initView(View view) {

        waitLayout = view.findViewById(R.id.wait_layout);
        waitLayout.setVisibility(View.VISIBLE);
        goodsFocusEmptyLayout = (LinearLayout) view.findViewById(R.id.goods_focus_empty);

        rlGoodsFoucs = (LRecyclerView) view.findViewById(R.id.rl_goods_focus);
        rlGoodsFoucs.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapterGoodsFoucs = new AdapterGoodsFoucs(getActivity(), list);
        lReAdapter = new LRecyclerViewAdapter(adapterGoodsFoucs);
        rlGoodsFoucs.setAdapter(lReAdapter);

        rlGoodsFoucs.setPullRefreshEnabled(false);
        rlGoodsFoucs.setFooterViewColor(R.color.background_red, R.color.text, android.R.color.white);
        rlGoodsFoucs.setFooterViewHint("拼命加载中", "已经全部为你呈现了", "网络不给力啊，点击再试一次吧");

        rlGoodsFoucs.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                page++;
                if (currentNum < totalNum) {
                    getMyGoodsFocusData();//获取商品收藏数据
                } else {
                    ToastUtil.showShort(getActivity(), "太棒啦，你居然拉到底啦！");
                    rlGoodsFoucs.setLoadMoreEnabled(false);
                    rlGoodsFoucs.refreshComplete(0);
                }
            }
        });
    }

    /**
     * 获取商品收藏数据
     */
    private void getMyGoodsFocusData() {
        OkHttpUtils.post()
                .url(Url.HOST + Url.FOCUS_GOODS)
                .addParams("key", Url.getKey(getActivity()))
                .addParams("page", "" + page)
                .addParams("rows", "100")
                .build().execute(new MyGoodsFocusCallBack());
    }

    private class MyGoodsFocusCallBack extends StringCallback {
        @Override
        public void onError(Request request, Exception e) {
            ToastUtil.showShort(getActivity(), "数据加载失败");
            waitLayout.setVisibility(View.GONE);
        }

        @Override
        public void onResponse(String response) {
            waitLayout.setVisibility(View.GONE);
            LogUtil.i("商品收藏" + response.toString());
            BeanGoodsFocus beanGoodsFocus = JSON.parseObject(response, BeanGoodsFocus.class);
            list.addAll(beanGoodsFocus.getDatas().getFavorites_list());

            if (list.size() == 0) {
                goodsFocusEmptyLayout.setVisibility(View.VISIBLE);
            } else {
                goodsFocusEmptyLayout.setVisibility(View.GONE);
            }

            totalNum = beanGoodsFocus.getPage_total();
            adapterGoodsFoucs.notifyDataSetChanged();
            lReAdapter.notifyDataSetChanged();
            rlGoodsFoucs.refreshComplete(10);
            currentNum += 10;
        }
    }
}
