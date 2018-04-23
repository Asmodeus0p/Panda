package com.jiyun.asmodeus.panda.view.fragment.chinalivefragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.contract.livechina.IChinaLIveContract;
import com.jiyun.asmodeus.panda.model.entity.ChinaLive;
import com.jiyun.asmodeus.panda.presenter.chinalive.ChinaLivePresenter;
import com.jiyun.asmodeus.panda.view.adapter.chinalive.ChinaLiveRecyAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChinaLiveEMeiShanFragment extends Fragment implements IChinaLIveContract.View {

    private ArrayList<ChinaLive.LiveBean> mlist = new ArrayList<>();
    private RecyclerView ChinaLiveEMeiShanRecy;
    private ChinaLiveRecyAdapter chinaLiveRecyAdapter;

    public ChinaLiveEMeiShanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_emei_shan, container, false);
        IChinaLIveContract.Presenter presenter = new ChinaLivePresenter(this);
        presenter.LoadEMeiShan();
        initView(view);
        return view;
    }

    @Override
    public void ShowNowLive(ChinaLive chinaLive) {

    }

    @Override
    public void ShowBaDaLin(ChinaLive chinaLive) {

    }

    @Override
    public void ShowTaiShan(ChinaLive chinaLive) {

    }

    @Override
    public void ShowHuangShan(ChinaLive chinaLive) {

    }

    @Override
    public void ShowFengHuang(ChinaLive chinaLive) {

    }

    @Override
    public void ShowEMeiShan(ChinaLive chinaLive) {
        mlist.clear();
        mlist.addAll(chinaLive.getLive());
        chinaLiveRecyAdapter.notifyDataSetChanged();
    }

    private void initView(View view) {
        ChinaLiveEMeiShanRecy = (RecyclerView) view.findViewById(R.id.ChinaLiveEMeiShanRecy);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        ChinaLiveEMeiShanRecy.setLayoutManager(linearLayoutManager);
        chinaLiveRecyAdapter = new ChinaLiveRecyAdapter(mlist, getContext());
        ChinaLiveEMeiShanRecy.setAdapter(chinaLiveRecyAdapter);
    }
}
