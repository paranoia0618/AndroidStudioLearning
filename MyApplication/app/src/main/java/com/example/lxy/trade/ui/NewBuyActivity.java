package com.example.lxy.trade.ui;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lxy.trade.R;
import com.example.lxy.trade.base.BaseActivity;
import com.example.lxy.trade.entity.Buy;
import com.example.lxy.trade.entity.MyUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * 项目名：Trade
 * 包名：com.example.lxy.trade.ui
 * 文件名：NewBuyActivity
 * 创建者：lxy
 * 创建时间：2018/3/14  16:38
 * 描述：添加出售
 */

public class NewBuyActivity extends BaseActivity {

    private Buy buy;
    private String mname;
    private String image;
    private String mtitle;
    private  String mcontent;
    private String messageid;


    @BindView(R.id.newbuy_title)
    EditText newbuyTitle;
    @BindView(R.id.newbuy_content)
    EditText newbuyContent;
    @BindView(R.id.newbuy_bt)
    Button newbuyBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newbuy);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.newbuy_bt)
    public void onViewClicked() {
        MyUser userInfo = BmobUser.getCurrentUser(MyUser.class);
        mname=userInfo.getUsername();
        image=userInfo.getImage();
        messageid=userInfo.getObjectId();
        mtitle=newbuyTitle.getText().toString().trim();
        mcontent=newbuyContent.getText().toString().trim();

        if (!TextUtils.isEmpty(mname)&& !TextUtils.isEmpty(mtitle)&&!TextUtils.isEmpty(mcontent)){
            buy=new Buy();
            buy.setName(mname);
            buy.setImage(image);
            buy.setTitle(mtitle);
            buy.setMessageid(messageid);
            buy.setContent(mcontent);
            saveBuy();
        }
        else {
            Toast.makeText(NewBuyActivity.this,"亲，输入框不能为空哦~~~",Toast.LENGTH_SHORT).show();
        }

    }

    private void saveBuy() {
        buy.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {

                if(e==null){
                    Toast.makeText(NewBuyActivity.this,"添加成功~~~",Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(NewBuyActivity.this,"添加失败~~~~~~",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
