package com.shopping.chengzi.myshoppingcart.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shopping.chengzi.myshoppingcart.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class  FragmentShoppingCart extends Fragment {

    // 拥有一个公开的TAG
    public static final String TAG = FragmentShoppingCart.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shopping_cart, container, false);
    }

}
