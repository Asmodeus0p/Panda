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
    private ArrayList<String> title = new ArrayList<>();
    private ArrayList<Fragment> fragments  = new ArrayList<>();
    private ChinaLiveVPAdapter chinaLiveVPAdapter;


    @Override
    protected void init() {

        liveChina_tab = getActivity().findViewById(R.id.LiveChina_Tab);
        liveChina_viewPager = getActivity().findViewById(R.id.LiveChina_ViewPager);
        chinaLiveVPAdapter = new ChinaLiveVPAdapter(getActivity().getSupportFragmentManager(), fragments, title);

        liveChina_viewPager.setAdapter(chinaLiveVPAdapter);
        liveChina_tab.setupWithViewPager(liveChina_viewPager);
        IChinaLIveContract.Presenter presenter =  new ChinaLivePresenter(this);
        presenter.LoadChianLive();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_live_china;
    }


    @Override
    public void ShowData(ChinaLive chinaLive) {

        List<ChinaLive.TablistBean> tablist = chinaLive.getTablist();
        for (ChinaLive.TablistBean tablistBean : tablist) {
            Log.e("123456",tablistBean.getTitle());
            ChinaLiveFuYongFragment chinaLiveFuYongFragment = new ChinaLiveFuYongFragment();
            title.add(tablistBean.getTitle());
            Bundle bundle = new Bundle();
            bundle.putString("url",tablistBean.getUrl());
            chinaLiveFuYongFragment.setArguments(bundle);
            fragments.add(chinaLiveFuYongFragment);

        }
        chinaLiveVPAdapter.notifyDataSetChanged();
    }
}
