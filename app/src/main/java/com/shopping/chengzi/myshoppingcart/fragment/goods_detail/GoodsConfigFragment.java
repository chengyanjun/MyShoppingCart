package com.shopping.chengzi.myshoppingcart.fragment.goods_detail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shopping.chengzi.myshoppingcart.R;

/**
 * A simple {@link Fragment} subclass.
 * 商品的规格参数
 */
public class GoodsConfigFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_goods_config, container, false);
    }

}
