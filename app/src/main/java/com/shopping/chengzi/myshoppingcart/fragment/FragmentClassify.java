package com.shopping.chengzi.myshoppingcart.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.shopping.chengzi.myshoppingcart.R;
import com.shopping.chengzi.myshoppingcart.activity.user_info.UserSettingActivity;
import com.shopping.chengzi.myshoppingcart.adapter.DetailClassifyAdapter;
import com.shopping.chengzi.myshoppingcart.adapter.MainClassifyAdapter;
import com.shopping.chengzi.myshoppingcart.bean.BeanClassify;
import com.shopping.chengzi.myshoppingcart.bean.BeanClassifyDetail;
import com.shopping.chengzi.myshoppingcart.utils.ToastUtil;
import com.shopping.chengzi.myshoppingcart.utils.Url;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * 商品分类页
 */
public class FragmentClassify extends Fragment {

    // 拥有一个公开的TAG
    public static final String TAG = FragmentClassify.class.getSimpleName();

    @BindView(R.id.ll_classify_search_goods)
    LinearLayout classifySearchGoods;

    @BindView(R.id.lv_classify)
    ListView lvClassify;//分类页list view

    @BindView(R.id.lv_detail_classify_listview)
    ListView lvDetailClassify;

    private List<BeanClassifyDetail.DatasBean.ClassListBean> classDetailList = new ArrayList<>();
    private DetailClassifyAdapter detailClassifyAdapter;

    private List<BeanClassify.DatasBean.ClassListBean> classListBeen = new ArrayList<>();
    private MainClassifyAdapter mainClassifyAdapter;


    //可见列表项的数量
    private int visibleCount = 0;
    //上次点击的位置
    private int lastPosition = 0;
    private int ce = 0;
    //实际列表是否超出屏幕
    private boolean isOut = true;

    View header;//为右边的list view添加头布局

    private View waitLayout;
    private View detailWaitLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_classify, container, false);

        //为右边的list view添加头布局
        header = View.inflate(getActivity(), R.layout.classify_top_layout, null);

        ButterKnife.bind(this, view);
        getMainClassifyData();
        getDetailClassifyData();
        init(view);
        return view;
    }

    @OnClick(R.id.ll_classify_search_goods)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_classify_search_goods:
                startActivity(new Intent(getActivity(), UserSettingActivity.class));
                break;
        }
    }


    private void init(View view) {
        waitLayout = view.findViewById(R.id.wait_layout);
        waitLayout.setVisibility(View.VISIBLE);
        detailWaitLayout = view.findViewById(R.id.detail_classify_wait_layout);
        lvClassify.setOnItemClickListener(new MainClassifyItemOnClick());

    }

    private class MainClassifyItemOnClick implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            //计算滑动
            if (visibleCount == 0) {
                visibleCount = lvClassify.getChildCount();
                if (visibleCount == classListBeen.size())
                    isOut = false;
                else {
                    ce = visibleCount / 2;
                }
            }

            if (position <= (parent.getFirstVisiblePosition() + ce)) {   //上移
                lvClassify.smoothScrollToPosition(position - ce);
            } else {   //下移
                if ((parent.getLastVisiblePosition() + ce + 1) <= parent.getCount()) {
                    lvClassify.smoothScrollToPosition(position + ce);
                } else {
                    lvClassify.smoothScrollToPosition(parent.getCount() - 1);
                }
            }
            lastPosition = position;
            mainClassifyAdapter.setSelected(position);
            mainClassifyAdapter.notifyDataSetChanged();

            classDetailList.clear(); //当点击list view的时候清除之前的数据
            detailClassifyAdapter.notifyDataSetChanged();
            lvDetailClassify.removeHeaderView(header);
            detailWaitLayout.setVisibility(View.VISIBLE);
            //更新右边的listview数据
            getDetailClassifyData();

        }
    }

    /**
     * 获取商品分类右边的数据
     */
    private void getDetailClassifyData() {
        OkHttpUtils.post().url(Url.HOST + Url.CATEGORY2)
                .addParams("", "")
                .build().execute(new DetailClassifyCallBack());
    }

    private class DetailClassifyCallBack extends StringCallback {
        @Override
        public void onError(Request request, Exception e) {
            detailWaitLayout.setVisibility(View.GONE);
            waitLayout.setVisibility(View.GONE);
            ToastUtil.showShort(getActivity(), "网络错误，加载数据失败！");
        }

        @Override
        public void onResponse(String response) {
            detailWaitLayout.setVisibility(View.GONE);
            waitLayout.setVisibility(View.GONE);
            BeanClassifyDetail beanClassifyDetail = JSON.parseObject(response.toString(), BeanClassifyDetail.class);
            classDetailList = beanClassifyDetail.getDatas().getClass_list();
            detailClassifyAdapter = new DetailClassifyAdapter(getActivity(), classDetailList);
            lvDetailClassify.addHeaderView(header);
            lvDetailClassify.setAdapter(detailClassifyAdapter);
        }
    }

    /**
     * 获取商品分类左边数据
     */
    private void getMainClassifyData() {
        OkHttpUtils.post().url(Url.HOST + Url.CATEGORY)
                .addParams("", "")
                .build().execute(new MainClassifyCallBack());
    }

    private class MainClassifyCallBack extends StringCallback {
        @Override
        public void onError(Request request, Exception e) {
            ToastUtil.showShort(getActivity(), "网络错误，加载数据失败！");
        }

        @Override
        public void onResponse(String response) {

            BeanClassify beanClassify = JSON.parseObject(response.toString(), BeanClassify.class);
            classListBeen = beanClassify.getDatas().getClass_list();
            mainClassifyAdapter = new MainClassifyAdapter(getActivity(), classListBeen);
            lvClassify.setAdapter(mainClassifyAdapter);

        }
    }


}
