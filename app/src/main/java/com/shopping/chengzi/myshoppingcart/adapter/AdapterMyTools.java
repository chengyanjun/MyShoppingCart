package com.shopping.chengzi.myshoppingcart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shopping.chengzi.myshoppingcart.R;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by chengzi on 2017/3/7.
 */

public class AdapterMyTools extends BaseAdapter {

    private final String[] buttonsTitles = new String[]{"收藏宝贝", "收藏内容", "订单查询", "卡券包", "优惠券", "会员中心", "我是商家", "足迹"};
    //首页精品分类图标
    private final int[] buttonsImgs = new int[]{R.mipmap.home_btn0, R.mipmap.home_btn1, R.mipmap.home_btn2, R.mipmap.home_btn3,
            R.mipmap.home_btn4, R.mipmap.home_btn5, R.mipmap.home_btn6, R.mipmap.home_btn7};

    private Context context;

    public AdapterMyTools(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return buttonsTitles.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    ViewHolder holder;

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_home_buttons, viewGroup, false);

            holder = new ViewHolder();
            holder.textView = (TextView) view.findViewById(R.id.text);
            holder.imageView = (ImageView) view.findViewById(R.id.image);
            view.setTag(holder);
            AutoUtils.autoSize(view);
        }

        holder = (ViewHolder) view.getTag();
        holder.imageView.setImageResource(buttonsImgs[position]);
        holder.textView.setText(buttonsTitles[position]);

        return view;
    }

    private class ViewHolder {
        TextView textView;
        ImageView imageView;
    }
}
