package com.shopping.chengzi.myshoppingcart.utils;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shopping.chengzi.myshoppingcart.R;


/**
 * Created by yuanfeng on 2016/12/16.
 */

public class InitTopBar {
    public static void initiTopText(final Activity activity, String topText) {
        if (topText != null) {
            TextView topTextView = (TextView) activity.findViewById(R.id.top_text);
            topTextView.setText(topText);
        }
        ImageView back = (ImageView) activity.findViewById(R.id.iv_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }

    public static void initiTopText(Activity activity, String topText, String topRightText) {
        initiTopText(activity, topText);
        TextView topRightTextView = (TextView) activity.findViewById(R.id.top_right_text);
        topRightTextView.setVisibility(View.VISIBLE);
        topRightTextView.setText(topRightText);
    }

    public static void initiTopImg(final Activity activity, String topText, int rightImg) {
        initiTopText(activity, topText);

        ImageView imageView = (ImageView) activity.findViewById(R.id.right_img);

        activity.findViewById(R.id.right_img).setVisibility(View.VISIBLE);
        imageView.setImageResource(rightImg);
    }
}
