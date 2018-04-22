package com.jiyun.asmodeus.panda.view.fragment.cctvfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.contract.cctv.ICCTVContract;
import com.jiyun.asmodeus.panda.model.entity.CCTVPingDao;
import com.jiyun.asmodeus.panda.model.entity.CCTVYangShi;
import com.jiyun.asmodeus.panda.presenter.cctv.CCTVPresenter;
import com.jiyun.asmodeus.panda.view.adapter.cctv.CCTV_PinDao_Adapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CCTV_PindaoFragment extends Fragment implements ICCTVContract.View {


    private RecyclerView CCTV_PinDaoRecy;
    private CCTVPresenter presenter;
    private CCTV_PinDao_Adapter cctv_pinDao_adapter;

    public CCTV_PindaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cctv__pindao, container, false);
        initView(view);
        presenter = new CCTVPresenter(this);
        presenter.LoadData();
        return view;
    }

    @Override
    public void showCCTVPinDao(CCTVPingDao cctvpingdao) {
        cctv_pinDao_adapter = new CCTV_PinDao_Adapter((ArrayList<CCTVPingDao.ListBean>) cctvpingdao.getList(),getActivity());
    }

    @Override
    public void showCCTVYangShi(CCTVYangShi cctvYangShi) {

    }


    private void initView(View view) {
        CCTV_PinDaoRecy = (RecyclerView) view.findViewById(R.id.CCTV_PinDaoRecy);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        CCTV_PinDaoRecy.setLayoutManager(linearLayoutManager);
        CCTV_PinDaoRecy.setAdapter(cctv_pinDao_adapter);
    }
}
