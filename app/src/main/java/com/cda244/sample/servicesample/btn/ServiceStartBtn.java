package com.cda244.sample.servicesample.btn;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.cda244.sample.servicesample.MainActivity;

public class ServiceStartBtn extends Button implements View.OnClickListener {

	public ServiceStartBtn(Context context) {
		super(context);
		init();
	}

	public ServiceStartBtn(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		init();
	}

	public ServiceStartBtn(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}


	public void init() {
		setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		((MainActivity) getContext()).sStart();
	}
}
