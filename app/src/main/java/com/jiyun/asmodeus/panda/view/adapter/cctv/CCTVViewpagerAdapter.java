package com.jiyun.asmodeus.panda.view.adapter.cctv;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;


public class CCTVViewpagerAdapter extends FragmentPagerAdapter {
    private ArrayList<String> title = new ArrayList<>();
    private ArrayList <Fragment> fragments = new ArrayList<>();

    public CCTVViewpagerAdapter(FragmentManager fm, ArrayList <Fragment> fragments, ArrayList <String> title) {
        super(fm);
        this.fragments = fragments;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}