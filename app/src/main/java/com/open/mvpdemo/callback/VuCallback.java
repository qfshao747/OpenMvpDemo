package com.open.mvpdemo.callback;

/**
 * listview点击事件的回调接口
 */
public interface VuCallback<T> {
    void execute(T t);

}
