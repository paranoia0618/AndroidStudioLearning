package com.example.lxy.taobaodemo.model;

import android.content.Context;

import com.example.lxy.taobaodemo.model.entity.HomeBottom;
import com.example.lxy.taobaodemo.model.entity.HomeTop;
import com.example.lxy.taobaodemo.presenter.OnLoadListener;



public interface HomeLoadModel extends LoadModel {

    void load(OnLoadListener<HomeTop> listener, Context context, int type);

    void load(OnLoadListener<HomeBottom> listener, Context context, int type, int page, int pageSize);
}
