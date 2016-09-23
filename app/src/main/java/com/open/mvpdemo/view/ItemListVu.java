package com.open.mvpdemo.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.open.mvpdemo.R;


public class ItemListVu implements Vu {

    public TextView titleTV;
    public View view;

    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.item_listview, container, false);
        titleTV = (TextView) view.findViewById(R.id.textview);
    }

    public void setTitle(String title) {
        titleTV.setText(title);
    }

    @Override
    public View getView() {
        return view;
    }
}
