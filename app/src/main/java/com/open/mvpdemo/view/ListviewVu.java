package com.open.mvpdemo.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.open.mvpdemo.R;
import com.open.mvpdemo.callback.VuCallback;

/**
 * Created by longchao
 * 功能：
 * 创建：2016/9/21.
 * 修改：
 */

public class ListviewVu implements Vu {
    private View view;
    private ListView mListview;
    private View mErrorView; //显示数据加载错误的界面
    private View mLoadingView; //显示正在加载中的界面，也就是中间有一个圈圈一直转啊转
    private VuCallback<Integer> mVuCallback; //用于点击事件的回调接口

    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.activity_listview, container);
        mErrorView = view.findViewById(R.id.error_view);
        mLoadingView = view.findViewById(R.id.loading_view);
        mListview = (ListView) view.findViewById(R.id.listview);
        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (mVuCallback != null) {
                    mVuCallback.execute(i);
                }
            }
        });
    }

    //用于在Activity设置条目点击事件
    public void setVuCallback(VuCallback<Integer> mVuCallback) {
        this.mVuCallback = mVuCallback;
    }

    @Override
    public View getView() {
        return view;
    }

    public void showLoading() {
        mLoadingView.setVisibility(View.VISIBLE);
        mListview.setVisibility(View.GONE);
        mErrorView.setVisibility(View.GONE);
    }

    //在Activity中new出adapter后，设置到listview中
    public void setAdapter(BaseAdapter adapter) {
        mListview.setAdapter(adapter);
    }

    public void showSuccessView() {
        mLoadingView.setVisibility(View.GONE);
        mListview.setVisibility(View.VISIBLE);
        mErrorView.setVisibility(View.GONE);
    }

    public void showErrorView() {
        mLoadingView.setVisibility(View.GONE);
        mListview.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
    }
}
