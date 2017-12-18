package com.example.lxy.shop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import  com.example.lxy.shop.bean.User;



public class BaseActivity extends AppCompatActivity{
    public  void StartActivity(Intent intent, boolean isNeedLogin){
        //判断是否需要登录
        if (isNeedLogin){
            User user= ContantsApplication.getInstance().getUser();
            //判断该是否正在登录
            if (user!=null){
                super.startActivity(intent);
            }else{
                ContantsApplication.getInstance().putIntent(intent);  //将intent进行保存
                Intent loginIntent=new Intent(this, LoginActivity.class);  //跳转到登录页面
                super.startActivity(loginIntent);
            }
        }else {
            super.startActivity(intent);
        }

    }


    public void StartActivityForResult(Intent intent, int requestCode) {

        User user = ContantsApplication.getInstance().getUser();
        if (user == null) {
            super.startActivityForResult(intent,requestCode);
        } else {
            ContantsApplication.getInstance().putIntent(intent);  //将intent进行保存
            Intent loginIntent = new Intent(this, TestActvity.class);  //跳转到登录页面
            super.startActivity(loginIntent);
        }
    }

}
