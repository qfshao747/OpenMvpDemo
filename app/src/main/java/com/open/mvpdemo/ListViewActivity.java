package com.open.mvpdemo;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.open.mvpdemo.adapter.ItemListAdapter;
import com.open.mvpdemo.base.BasePresenterActivity;
import com.open.mvpdemo.callback.OnLoadDataCallback;
import com.open.mvpdemo.callback.VuCallback;
import com.open.mvpdemo.model.DataModeImpl;
import com.open.mvpdemo.model.DataModel;
import com.open.mvpdemo.view.ListviewVu;

import java.util.List;

/**
 * Created by longchao
 * 功能：
 * 创建：2016/9/21.
 * 修改：
 */

public class ListViewActivity extends BasePresenterActivity<ListviewVu>  {
    private DataModeImpl mDataModel; //数据层，可以从网络，本地，数据获取数据
    private ItemListAdapter mAdapter;


    //假设开启activity要传一个参数，用以获取数据
    public static void open(Context context, String params) {
        Intent intent = new Intent(context,ListViewActivity.class);
        intent.putExtra("params", params);
        context.startActivity(intent);
    }

    @Override
    protected void onBindView() {
        Intent intent = getIntent();
        String params = intent.getStringExtra("params");

        mAdapter = new ItemListAdapter();
        vu.setAdapter(mAdapter);

        mDataModel = new DataModel();

        vu.showLoading();
        mDataModel.load(params, new OnLoadDataCallback() {
            @Override
            public void onLoadSuccess(List<String> data) {
                mAdapter.updata(data);
                vu.showSuccessView();
            }

            @Override
            public void onLoadError(String errorMsg) {
                vu.showErrorView();
            }
        });

        vu.setVuCallback(new VuCallback<Integer>() {
            @Override
            public void execute(Integer integer) {
//             startActivity(new Intent());
                Toast.makeText(ListViewActivity.this,"点击条目，进入新的界面",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected Class<ListviewVu> getVuClass() {
        return ListviewVu.class;
    }
}
