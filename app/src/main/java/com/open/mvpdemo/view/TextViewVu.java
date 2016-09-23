package com.open.mvpdemo.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.open.mvpdemo.R;

/**
 * Created by longchao
 * 功能：
 * 创建：2016/9/23.
 * 修改：
 */

public class TextViewVu implements Vu {
    private View view;
    public TextView mTextView;

    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.activity_textview, container);
        mTextView = (TextView) view.findViewById(R.id.textview);
    }

    @Override
    public View getView() {
        return view;
    }
}
