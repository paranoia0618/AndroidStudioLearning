package com.example.lxy.shop.adapter;

import android.content.Context;

import java.util.List;



public abstract class SimpleAdapter<T> extends BaseAdapter<T,BaseViewHolder> {


    public SimpleAdapter(Context context, List<T> data, int layoutResId) {
        super(context, data, layoutResId);
    }


}
