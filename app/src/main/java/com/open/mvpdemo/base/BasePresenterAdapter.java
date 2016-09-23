package com.open.mvpdemo.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.open.mvpdemo.view.Vu;


/**
 * 用于mvp的listviewadapter
 */
public abstract class BasePresenterAdapter<V extends Vu> extends BaseAdapter {
    protected V vu;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflate = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            try {
                vu = getVuClass().newInstance();
                vu.init(inflate, parent);
                //获取到当前view
                convertView = vu.getView();
                //设置标记
                convertView.setTag(vu);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            vu = (V) convertView.getTag();
        }

        if (null != convertView) {
            //绑定数据
            onBindListItemView(position);
        }
        return convertView;
    }

    protected abstract void onBindListItemView(int position);

    protected abstract Class<V> getVuClass();
}
