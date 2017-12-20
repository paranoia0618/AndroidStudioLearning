package com.example.lxy.taobaodemo.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.lxy.taobaodemo.ui.fragment.NavCartFragment;
import com.example.lxy.taobaodemo.ui.fragment.NavHelpFragment;
import com.example.lxy.taobaodemo.ui.fragment.NavHomeFragment;
import com.example.lxy.taobaodemo.ui.fragment.NavMyFragment;
import com.example.lxy.taobaodemo.ui.fragment.NavWeFragment;

import java.util.ArrayList;
import java.util.List;



public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);

        fragments.clear();
        fragments.add(NavHomeFragment.newInstance());
        fragments.add(NavWeFragment.newInstance());
        fragments.add(NavHelpFragment.newInstance());
        fragments.add(NavCartFragment.newInstance());
        fragments.add(NavMyFragment.newInstance());

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

}
