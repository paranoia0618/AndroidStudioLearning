package com.example.lxy.trade;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyFragment1 extends Fragment {

    //仿淘宝首页的 淘宝头条滚动的自定义View
    private UPMarqueeView upview1;
    List<String> data = new ArrayList<>();
    List<View> views = new ArrayList<>();
    //bannerView
    private int[] imgs = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d};
    private List<View> viewList;
    BannerView bannerView;

    public MyFragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fargment_zhuye, container, false);
        viewList = new ArrayList<View>();

        //bannerview
        for (int i = 0; i < imgs.length; i++) {
            ImageView image = new ImageView(getActivity());
            image.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            //设置显示格式
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            image.setImageResource(imgs[i]);
            viewList.add(image);
        }
        bannerView = (BannerView) view.findViewById(R.id.banner);
        bannerView.startLoop(true);

        bannerView.setViewList(viewList);

        upview1 = (UPMarqueeView) view.findViewById(R.id.upview1);
        /*initParam();*/
        initdata();
        initView();
        return view;
    }

    /**
     * 实例化控件
     */
   /* private void initParam() {
        upview1 = (UPMarqueeView) view.findViewById(R.id.upview1);
    }*/

    /**
     * 初始化界面程序
     */
    private void initView() {
        setView();
        upview1.setViews(views);
        /**
         * 设置item_view的监听
         */
        upview1.setOnItemClickListener(new UPMarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Toast.makeText(getActivity(), "你点击了第几个items" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 初始化需要循环的View
     * 为了灵活的使用滚动的View，所以把滚动的内容让用户自定义
     * 假如滚动的是三条或者一条，或者是其他，只需要把对应的布局，和这个方法稍微改改就可以了，
     */
    private void setView() {
        for (int i = 0; i < data.size(); i = i + 2) {
            final int position = i;
            //设置滚动的单个布局
            LinearLayout moreView = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.item_view, null);
            //初始化布局的控件
            TextView tv1 = (TextView) moreView.findViewById(R.id.tv1);
            TextView tv2 = (TextView) moreView.findViewById(R.id.tv2);

            /**
             * 设置监听
             */
            moreView.findViewById(R.id.rl).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), position + "你点击了" + data.get(position).toString(), Toast.LENGTH_SHORT).show();
                }
            });
            /**
             * 设置监听
             */
            moreView.findViewById(R.id.rl2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), position + "你点击了" + data.get(position + 1).toString(), Toast.LENGTH_SHORT).show();
                }
            });
            //进行对控件赋值
            tv1.setText(data.get(i).toString());
            if (data.size() > i + 1) {
                //因为淘宝那儿是两条数据，但是当数据是奇数时就不需要赋值第二个，所以加了一个判断，还应该把第二个布局给隐藏掉
                tv2.setText(data.get(i + 1).toString());
            } else {
                moreView.findViewById(R.id.rl2).setVisibility(View.GONE);
            }

            //添加到循环滚动数组里面去
            views.add(moreView);
        }
    }

    /**
     * 初始化数据
     */
    private void initdata() {
        data = new ArrayList<>();
        data.add("因为快要毕业了，书本低价出售！！！");
        data.add("iPhone8感人二手价，必须买买买买!!!!");
        data.add("简直是白菜价！王者玩家低价甩卖游戏号");
        data.add("口红低价转卖，有意者请尽快联系！！");
        data.add("二手电脑低价转卖，友情价，速联系！");
//        data.add("竟不是小米乐视！看水抢了骁龙821首发了！！！");

    }

}
