package com.example.admin.one.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by admin on 2017/9/22.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }
    public  List<Fragment> list;
    public void setFragment(List<Fragment> lists ){
        list=lists;
    }
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = list.get(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
