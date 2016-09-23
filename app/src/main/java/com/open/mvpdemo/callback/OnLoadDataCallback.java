package com.open.mvpdemo.callback;

import java.util.List;

/**
 * Created by longchao
 * 功能：
 * 创建：2016/9/21.
 * 修改：
 */

public interface OnLoadDataCallback {
    void onLoadSuccess(List<String> data);

    void onLoadError(String errorMsg);
}
