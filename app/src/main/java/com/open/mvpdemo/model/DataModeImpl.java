package com.open.mvpdemo.model;

import com.open.mvpdemo.callback.OnLoadDataCallback;

/**
 * Created by longchao
 * 功能：
 * 创建：2016/9/21.
 * 修改：
 */

public interface DataModeImpl {
    void load(String params, OnLoadDataCallback callback);
}
