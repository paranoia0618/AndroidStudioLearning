package com.example.lxy.trade.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * 项目名：Trade
 * 包名：com.example.lxy.trade.base
 * 文件名：BaseActivity
 * 创建者：lxy
 * 创建时间：2018/3/11  17:07
 * 描述：为了方便管理，所有activity的基类
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setElevation(0);
        //显示返回键
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题拦

    }

    //菜单栏操作
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
