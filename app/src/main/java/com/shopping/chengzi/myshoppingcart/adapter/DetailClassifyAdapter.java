package com.shopping.chengzi.myshoppingcart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.shopping.chengzi.myshoppingcart.R;
import com.shopping.chengzi.myshoppingcart.bean.BeanClassifyDetail;
import com.shopping.chengzi.myshoppingcart.widget.GridViewInScrollView;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by chengzi on 2017/3/14.
 */

public class DetailClassifyAdapter extends BaseAdapter {

    private Context context;
    private List<BeanClassifyDetail.DatasBean.ClassListBean> classListBeen;

    public DetailClassifyAdapter(Context context, List<BeanClassifyDetail.DatasBean.ClassListBean> classListBeen) {
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


    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_detail_goods_classify, viewGroup, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
            AutoUtils.autoSize(convertView);
        }
        holder = (ViewHolder) convertView.getTag();

        holder.setPosition(i);

        BeanClassifyDetail.DatasBean.ClassListBean beanDetailClassify = classListBeen.get(i);

        holder.classifyName.setText(beanDetailClassify.getGc_name());

        AdapterClassifyDetailPic adapter = new AdapterClassifyDetailPic(context, classListBeen);
        holder.listView.setAdapter(adapter);

        return convertView;
    }

    private class ViewHolder {

        TextView classifyName;

        GridViewInScrollView listView;

        int position;

        public ViewHolder(View itemView) {
            super();
            classifyName = (TextView) itemView.findViewById(R.id.tv_item_classify_detail_listview);
            listView = (GridViewInScrollView) itemView.findViewById(R.id.gv_classify_detail_goods_list);

        }

        public void setPosition(int position) {
            this.position = position;
        }
    }
}
