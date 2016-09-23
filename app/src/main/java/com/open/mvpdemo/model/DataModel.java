package com.open.mvpdemo.model;

import android.os.AsyncTask;
import android.os.SystemClock;

import com.open.mvpdemo.callback.OnLoadDataCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by longchao
 * 功能：模拟获取数据，可以是网络，本地，数据。
 *          这个例子中，这个类不重要
 * 创建：2016/9/21.
 * 修改：
 */

public class DataModel implements DataModeImpl {
    @Override
    public void load(String params, OnLoadDataCallback callback) {
        new DataTask(callback).execute(params);
    }

    private class DataTask extends AsyncTask<String,String,List<String>>{
        private OnLoadDataCallback callback;

        public DataTask(OnLoadDataCallback callback) {
            this.callback = callback;
        }

        @Override
        protected List<String> doInBackground(String... strings) {
            SystemClock.sleep(2000);

            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add("数据=========== " + i);
            }
            return list;
        }

        @Override
        protected void onPostExecute(List<String> list) {
            super.onPostExecute(list);
            if (null != list && list.size() > 0) {
                callback.onLoadSuccess(list);
            } else {
                callback.onLoadError("数据加载错误");
            }
        }
    }

}
