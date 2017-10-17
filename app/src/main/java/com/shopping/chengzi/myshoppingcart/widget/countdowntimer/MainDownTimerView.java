package com.shopping.chengzi.myshoppingcart.widget.countdowntimer;

import android.content.Context;
import android.util.AttributeSet;

public class MainDownTimerView extends BaseCountDownTimerView {

	public MainDownTimerView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public MainDownTimerView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}

	public MainDownTimerView(Context context) {
		this(context,null);
	}

	@Override
	protected String getStrokeColor() {
		return "333333";
	}

	@Override
	protected String getTextColor() {
		return "000033";
	}

	@Override
	protected int getCornerRadius() {
		return 0;
	}

	@Override
	protected int getTextSize() {
		return 36;
	}

	@Override
	protected String getBackgroundColor() {
		return null;
	}

	
	
}
