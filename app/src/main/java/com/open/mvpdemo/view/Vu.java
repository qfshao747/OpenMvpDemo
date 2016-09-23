package com.open.mvpdemo.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/4/23.
 * 所有mvp view的基类，用来初始化view和返回view
 */
public interface Vu {
    /**
     * 初始化view
     * @param inflater
     * @param container
     */
    void init(LayoutInflater inflater, ViewGroup container);


    /**
     * 返回一个根的view
     * @return
     */
    View getView();
}
