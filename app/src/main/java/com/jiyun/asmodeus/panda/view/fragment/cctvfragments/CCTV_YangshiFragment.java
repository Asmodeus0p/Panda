package com.jiyun.asmodeus.panda.view.fragment.cctvfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.contract.cctv.ICCTVContract;
import com.jiyun.asmodeus.panda.model.entity.CCTVPingDao;
import com.jiyun.asmodeus.panda.model.entity.CCTVYangShi;

/**
 * A simple {@link Fragment} subclass.
 */
public class CCTV_YangshiFragment extends Fragment implements ICCTVContract.View {


    private RecyclerView CCTV_YangShiRecy;

    public CCTV_YangshiFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cctv__yangshi, container, false);
        initView(view);
        return view;
    }

    @Override
    public void showCCTVPinDao(CCTVPingDao cctvpingdao) {

    }

    @Override
    public void showCCTVYangShi(CCTVYangShi cctvYangShi) {

    }


    private void initView(View view) {
        CCTV_YangShiRecy = (RecyclerView) view.findViewById(R.id.CCTV_YangShiRecy);
    }
}