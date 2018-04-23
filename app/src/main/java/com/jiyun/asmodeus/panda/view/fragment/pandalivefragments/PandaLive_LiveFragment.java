package com.jiyun.asmodeus.panda.view.fragment.pandalivefragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TextView;

import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.contract.pandalive.IPandaLiveContract;
import com.jiyun.asmodeus.panda.model.entity.PandaLivBean;
import com.jiyun.asmodeus.panda.view.adapter.pandalive.PandaLiveLiveViewPagerAdapter;
import com.jiyun.asmodeus.panda.view.fragment.pandalivelive.PandaLiveMoreFragment;
import com.jiyun.asmodeus.panda.view.fragment.pandalivelive.PandaLiveZhiboye_chatFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PandaLive_LiveFragment extends Fragment implements View.OnClickListener {


    private ImageView PandaLiveLiveImgBtn;
    private TextView PandaLiveLiveText;
    private TabLayout pandaLiveLiveTabLayout;
    private ViewPager PAndaLiveLiveViewPager;
    private ArrayList<String> titles = new ArrayList<>();
    private ArrayList<Fragment> fragments = new ArrayList<>();

    public PandaLive_LiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_panda_live__live, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        PandaLiveLiveImgBtn = (ImageView) view.findViewById(R.id.PandaLiveLiveImgBtn);
        PandaLiveLiveText = (TextView) view.findViewById(R.id.PandaLiveLiveText);
        pandaLiveLiveTabLayout = (TabLayout) view.findViewById(R.id.pandaLiveLiveTabLayout);

        PandaLiveLiveImgBtn.setOnClickListener(this);
        PAndaLiveLiveViewPager = (ViewPager) view.findViewById(R.id.PAndaLiveLiveViewPager);
        titles.add("多视角直播");
        titles.add("边看边聊");
        fragments.add(new PandaLiveMoreFragment());
        fragments.add(new PandaLiveZhiboye_chatFragment());
        PandaLiveLiveViewPagerAdapter pagerAdapter = new PandaLiveLiveViewPagerAdapter(getActivity().getSupportFragmentManager(), fragments, titles);
        PAndaLiveLiveViewPager.setAdapter(pagerAdapter);
        pandaLiveLiveTabLayout.setupWithViewPager(PAndaLiveLiveViewPager);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.PandaLiveLiveImgBtn) {
            if (PandaLiveLiveText.getVisibility() == View.GONE) {
                PandaLiveLiveText.setVisibility(View.VISIBLE);
                PandaLiveLiveImgBtn.setImageResource(R.mipmap.com_facebook_tooltip_blue_bottomnub);
            } else {
                PandaLiveLiveText.setVisibility(View.GONE);
                PandaLiveLiveImgBtn.setImageResource(R.mipmap.com_facebook_tooltip_blue_topnub);
            }


        }

    }
}
