package com.open.mvpdemo.adapter;

import com.open.mvpdemo.base.BasePresenterAdapter;
import com.open.mvpdemo.view.ItemListVu;

import java.util.List;

public class ItemListAdapter extends BasePresenterAdapter<ItemListVu> {

    private List<String> list;

    public ItemListAdapter() {
    }

    public void updata(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    //在这里设置数据
    @Override
    protected void onBindListItemView(int position) {
        vu.setTitle(list.get(position));
    }

    @Override
    protected Class<ItemListVu> getVuClass() {
        return ItemListVu.class;
    }

    @Override
    public int getCount() {
        if (null != list) {
            return list.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}
