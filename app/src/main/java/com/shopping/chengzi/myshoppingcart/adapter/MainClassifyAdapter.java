package com.shopping.chengzi.myshoppingcart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.shopping.chengzi.myshoppingcart.R;
import com.shopping.chengzi.myshoppingcart.bean.BeanClassify;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import static com.shopping.chengzi.myshoppingcart.R.id.tv_main_classify_name;
import static com.shopping.chengzi.myshoppingcart.R.id.tv_main_classify_view;

/**
 * Created by chengzi on 2017/3/13.
 */

public class MainClassifyAdapter extends BaseAdapter {

    private Context context;
    private List<BeanClassify.DatasBean.ClassListBean> classListBeen;
    private int selectedId;

    public MainClassifyAdapter(Context context, List<BeanClassify.DatasBean.ClassListBean> classListBeen) {
        this.context = context;
        this.classListBeen = classListBeen;
    }


    @Override
    public int getCount() {
        return classListBeen.size();
    }

    @Override
    public Object getItem(int i) {
        return classListBeen.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void setSelected(int position) {
        this.selectedId = position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_main_goods_classify, viewGroup, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
            AutoUtils.autoSize(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (i == selectedId) {
            convertView.setBackgroundColor(convertView.getResources().getColor(R.color.background_tint));
            viewHolder.ClassifyView.setBackgroundColor(convertView.getResources().getColor(R.color.background_red));
            viewHolder.ClassifyName.setTextColor(convertView.getResources().getColor(R.color.background_red));
        } else {
            convertView.setBackgroundColor(convertView.getResources().getColor(R.color.white));
            viewHolder.ClassifyView.setBackgroundColor(convertView.getResources().getColor(R.color.white));
            viewHolder.ClassifyName.setTextColor(convertView.getResources().getColor(R.color.text));
        }

        viewHolder.setPosition(i);
        BeanClassify.DatasBean.ClassListBean classMainListBean = classListBeen.get(i);
        viewHolder.ClassifyName.setText(classMainListBean.getGc_name());
        return convertView;
    }

    class ViewHolder {

        View ClassifyView;
        TextView ClassifyName;
        int position;

        public ViewHolder(View view) {
            ClassifyName = (TextView) view.findViewById(tv_main_classify_name);
            ClassifyView = view.findViewById(tv_main_classify_view);
        }

        public void setPosition(int position) {
            this.position = position;
        }

    }
}
