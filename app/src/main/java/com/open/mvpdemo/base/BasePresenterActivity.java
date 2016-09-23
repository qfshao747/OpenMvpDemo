package com.open.mvpdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.open.mvpdemo.view.Vu;

public abstract class BasePresenterActivity<V extends Vu> extends AppCompatActivity {

    protected V vu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            //创建Vu类的实例
            vu = getVuClass().newInstance();
            //初始化view，也就是inflater，findViewByID等操作
            vu.init(getLayoutInflater(),null);
            //再把inflater出来的view设置到Activity中
            setContentView(vu.getView());
            //绑定数据
            onBindView();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 绑定数据
     */
    protected void onBindView() {

    }

    /**
     * 返回当前的view的对象,由子类确定具体的类
     * @return
     */
    protected abstract Class<V> getVuClass();
}
