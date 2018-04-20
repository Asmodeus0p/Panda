package com.jiyun.asmodeus.panda.view.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.view.adapter.cctv.CCTVViewpagerAdapter;
import com.jiyun.asmodeus.panda.view.base.BaseFragment;
import com.jiyun.asmodeus.panda.view.fragment.cctvfragments.CCTV_PindaoFragment;
import com.jiyun.asmodeus.panda.view.fragment.cctvfragments.CCTV_YangshiFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CCTVFragment extends BaseFragment {


    private TabLayout cctv_tablayout;
    private ViewPager cctv_viewpager;
    private ArrayList<String> CCTVTabTitle = new ArrayList<>();
    private ArrayList<Fragment> CCTVfragments = new ArrayList<>();
    public CCTVFragment() {
        // Required empty public constructor
    }

    @Override
    protected void init() {
        cctv_tablayout = getView().findViewById(R.id.CCTV_Tablayout);
        cctv_viewpager = getView().findViewById(R.id.CCTV_ViewPager);
        CCTVTabTitle.add("频道直播");
        CCTVTabTitle.add("央视名栏");
        CCTVfragments.add(new CCTV_PindaoFragment());
        CCTVfragments.add(new CCTV_YangshiFragment());
        cctv_viewpager.setAdapter(new CCTVViewpagerAdapter(getActivity().getSupportFragmentManager(),CCTVfragments,CCTVTabTitle));
        cctv_tablayout.setupWithViewPager(cctv_viewpager);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cctv;
    }
}
