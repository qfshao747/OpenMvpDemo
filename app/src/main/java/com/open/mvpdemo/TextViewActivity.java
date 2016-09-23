package com.open.mvpdemo;

import android.content.Context;
import android.content.Intent;

import com.open.mvpdemo.base.BasePresenterActivity;
import com.open.mvpdemo.view.TextViewVu;

/**
 * Created by longchao
 * 功能：
 * 创建：2016/9/23.
 * 修改：
 */

public class TextViewActivity extends BasePresenterActivity<TextViewVu> {
    public static void open(Context context) {
        Intent intent = new Intent(context, TextViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected Class<TextViewVu> getVuClass() {
        return TextViewVu.class;
    }

    @Override
    protected void onBindView() {
        super.onBindView();
        vu.mTextView.setText("哈哈");
    }
}
