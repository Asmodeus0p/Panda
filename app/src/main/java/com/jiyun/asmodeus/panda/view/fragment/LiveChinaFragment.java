package com.jiyun.asmodeus.panda.view.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.view.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveChinaFragment extends BaseFragment {


    private TabLayout liveChina_tab;
    private ViewPager liveChina_viewPager;

    public LiveChinaFragment() {

    }


    @Override
    protected void init() {
        liveChina_tab = getActivity().findViewById(R.id.LiveChina_Tab);
        liveChina_viewPager = getActivity().findViewById(R.id.LiveChina_ViewPager);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_live_china;
    }


}
