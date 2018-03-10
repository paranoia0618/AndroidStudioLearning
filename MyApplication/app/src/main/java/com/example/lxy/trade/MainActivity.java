package com.example.lxy.trade;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener {


    //UI Objects
    private RadioGroup rg_tab_bar;
    private RadioButton rb_zhuye;
    private RadioButton rb_lianxiren;
    private RadioButton rb_quanzi;
    private RadioButton rb_wode;
    private ViewPager vpager;

    private MyFragment1 firstFragment;
    private MyFragment2 secondFragment;
    private MyFragment3 thirdFragment;
    private MyFragment4 fourFragment;

    private MyFragmentPagerAdapter mAdapter;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //显示第一个fragment
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        bindViews();
        rb_zhuye.setChecked(true);
    }

    private void bindViews() {
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rb_zhuye = (RadioButton) findViewById(R.id.rb_zhuye);
        rb_lianxiren = (RadioButton) findViewById(R.id.rb_lianxiren);
        rb_quanzi = (RadioButton) findViewById(R.id.rb_quanzi);
        rb_wode = (RadioButton) findViewById(R.id.rb_wode);
        rg_tab_bar.setOnCheckedChangeListener(this);

        vpager = (ViewPager) findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_zhuye:
                vpager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rb_lianxiren:
                vpager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rb_quanzi:
                vpager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.rb_wode:
                vpager.setCurrentItem(PAGE_FOUR);
                break;
        }
    }



    //重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (vpager.getCurrentItem()) {
                case PAGE_ONE:
                    rb_zhuye.setChecked(true);
                    break;
                case PAGE_TWO:
                    rb_lianxiren.setChecked(true);
                    break;
                case PAGE_THREE:
                    rb_quanzi.setChecked(true);
                    break;
                case PAGE_FOUR:
                    rb_wode.setChecked(true);
                    break;
            }
        }
    }

}
