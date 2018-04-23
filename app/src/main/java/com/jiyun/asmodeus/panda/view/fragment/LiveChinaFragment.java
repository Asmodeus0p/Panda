package com.jiyun.asmodeus.panda.view.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.view.adapter.chinalive.ChinaLiveVPAdapter;
import com.jiyun.asmodeus.panda.view.base.BaseFragment;
import com.jiyun.asmodeus.panda.view.fragment.chinalivefragments.ChinaLiveBadalinFragment;
import com.jiyun.asmodeus.panda.view.fragment.chinalivefragments.ChinaLiveEMeiShanFragment;
import com.jiyun.asmodeus.panda.view.fragment.chinalivefragments.ChinaLiveFengHuangFragment;
import com.jiyun.asmodeus.panda.view.fragment.chinalivefragments.ChinaLiveHuangshanFragment;
import com.jiyun.asmodeus.panda.view.fragment.chinalivefragments.ChinaLiveNowFragment;
import com.jiyun.asmodeus.panda.view.fragment.chinalivefragments.ChinaLiveTaishanFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveChinaFragment extends BaseFragment {


    private TabLayout liveChina_tab;
    private ViewPager liveChina_viewPager;
    private ArrayList<String> title = new ArrayList<>();
    private ArrayList<Fragment> fragments  = new ArrayList<>();



    @Override
    protected void init() {
        liveChina_tab = getActivity().findViewById(R.id.LiveChina_Tab);
        liveChina_viewPager = getActivity().findViewById(R.id.LiveChina_ViewPager);
        title.add("精彩直播");
        title.add("八达岭");
        title.add("泰山");
        title.add("黄山");
        title.add("凤凰古城");
        title.add("峨眉山");
        fragments.add(new ChinaLiveNowFragment());
        fragments.add(new ChinaLiveBadalinFragment());
        fragments.add(new ChinaLiveTaishanFragment());
        fragments.add(new ChinaLiveHuangshanFragment());
        fragments.add(new ChinaLiveFengHuangFragment());
        fragments.add(new ChinaLiveEMeiShanFragment());
        ChinaLiveVPAdapter chinaLiveVPAdapter = new ChinaLiveVPAdapter(getActivity().getSupportFragmentManager(), fragments, title);
        liveChina_viewPager.setAdapter(chinaLiveVPAdapter);
        liveChina_tab.setupWithViewPager(liveChina_viewPager);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_live_china;
    }


}
