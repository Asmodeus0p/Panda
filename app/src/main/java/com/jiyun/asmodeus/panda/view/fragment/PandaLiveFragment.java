package com.jiyun.asmodeus.panda.view.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.contract.pandalive.IPandaLiveContract;
import com.jiyun.asmodeus.panda.model.entity.PandaLivBean;
import com.jiyun.asmodeus.panda.presenter.pandalive.PandaLivePresenter;
import com.jiyun.asmodeus.panda.view.adapter.pandalive.PandaLiveAdapter;
import com.jiyun.asmodeus.panda.view.base.BaseFragment;
import com.jiyun.asmodeus.panda.view.fragment.pandalivefragments.PAndaLive_ShowTimeFragment;
import com.jiyun.asmodeus.panda.view.fragment.pandalivefragments.PandaLive_ArchivesFragment;
import com.jiyun.asmodeus.panda.view.fragment.pandalivefragments.PandaLive_LiveFragment;
import com.jiyun.asmodeus.panda.view.fragment.pandalivefragments.PandaLive_NewsFragment;
import com.jiyun.asmodeus.panda.view.fragment.pandalivefragments.PandaLive_NoPandaFragment;
import com.jiyun.asmodeus.panda.view.fragment.pandalivefragments.PandaLive_SpecialFragment;
import com.jiyun.asmodeus.panda.view.fragment.pandalivefragments.PandaLive_ThingsFragment;
import com.jiyun.asmodeus.panda.view.fragment.pandalivefragments.PandaLive_TopFragment;
import com.jiyun.asmodeus.panda.view.fragment.pandalivefragments.PandaLive_wonderfulmomentFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PandaLiveFragment extends BaseFragment {

    private TabLayout pandaLiveTabLayout;
    private ViewPager pandaLiveViewpager;
   private ArrayList<String> title = new ArrayList<>();
   private ArrayList<Fragment> fragments = new ArrayList<>();
    @Override
    protected void init() {

        pandaLiveTabLayout = getView().findViewById(R.id.pandaLiveTabLayout);

        pandaLiveViewpager = getView().findViewById(R.id.pandaLiveViewpager);

        title.add("直播");

        title.add("精彩一刻");

        title.add("当熊不让");

        title.add("超萌滚滚秀");

        title.add("熊猫TOP榜");

        title.add("特别节目");

        title.add("熊猫档案");

        title.add("熊猫那些事儿");

        title.add("原创新闻");

        fragments.add(new PandaLive_LiveFragment());

        fragments.add(new PandaLive_wonderfulmomentFragment());

        fragments.add(new PandaLive_NoPandaFragment());

        fragments.add(new PAndaLive_ShowTimeFragment());

        fragments.add(new PandaLive_TopFragment());

        fragments.add(new PandaLive_SpecialFragment());

        fragments.add(new PandaLive_ArchivesFragment());

        fragments.add(new PandaLive_ThingsFragment());

        fragments.add(new PandaLive_NewsFragment());

        PandaLiveAdapter pandaLiveAdapter = new PandaLiveAdapter(getActivity().getSupportFragmentManager(), fragments, title);

        pandaLiveViewpager.setAdapter(pandaLiveAdapter);

        pandaLiveTabLayout.setupWithViewPager(pandaLiveViewpager);



    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panda_live;
    }



}
