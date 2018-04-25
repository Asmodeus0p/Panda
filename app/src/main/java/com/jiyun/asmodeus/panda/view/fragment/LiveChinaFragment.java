package com.jiyun.asmodeus.panda.view.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.contract.livechina.IChinaLIveContract;
import com.jiyun.asmodeus.panda.model.entity.ChinaLive;
import com.jiyun.asmodeus.panda.presenter.chinalive.ChinaLivePresenter;
import com.jiyun.asmodeus.panda.view.adapter.chinalive.ChinaLiveVPAdapter;
import com.jiyun.asmodeus.panda.view.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;


public class LiveChinaFragment extends BaseFragment implements IChinaLIveContract.View {


    private TabLayout liveChina_tab;
    private ViewPager liveChina_viewPager;

    private List<String> tabList ;

    private List<Fragment> fragmentss;
    private ChinaLiveVPAdapter chinaLiveVPAdapter;


    @Override
    protected void init() {
        liveChina_tab = getActivity().findViewById(R.id.LiveChina_Tab);
        liveChina_viewPager = getActivity().findViewById(R.id.LiveChina_ViewPager);
        IChinaLIveContract.Presenter presenter = new ChinaLivePresenter(this);
        presenter.LoadChianLive();

    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_live_china;
    }


    @Override
    public void ShowData(ChinaLive data) {

        fragmentss = new ArrayList<>();
        tabList = new ArrayList<>();
        List<ChinaLive.TablistBean> tablist = data.getTablist();
        for (ChinaLive.TablistBean tablistBean : tablist) {
            Bundle bundle = new Bundle();
            bundle.putString("url",tablistBean.getUrl());
            tabList.add(tablistBean.getTitle());
            ChinaLiveFuYongFragment chinaLiveFuYongFragment = new ChinaLiveFuYongFragment();
            fragmentss.add(chinaLiveFuYongFragment);
            chinaLiveFuYongFragment.setArguments(bundle);
            Log.e("asdfgh",tablistBean.getTitle());
        }

        chinaLiveVPAdapter =new ChinaLiveVPAdapter(getActivity().getSupportFragmentManager(), fragmentss, tabList);
        chinaLiveVPAdapter.notifyDataSetChanged();
        liveChina_viewPager.setAdapter(chinaLiveVPAdapter);
        liveChina_tab.setupWithViewPager(liveChina_viewPager);

    }
}
