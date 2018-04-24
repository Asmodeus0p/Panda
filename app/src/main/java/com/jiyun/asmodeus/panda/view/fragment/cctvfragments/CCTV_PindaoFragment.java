package com.jiyun.asmodeus.panda.view.fragment.cctvfragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.contract.cctv.ICCTVContract;
import com.jiyun.asmodeus.panda.model.GreenDaoUtils;
import com.jiyun.asmodeus.panda.model.entity.CCTVPingDao;
import com.jiyun.asmodeus.panda.model.entity.CCTVYangShi;
import com.jiyun.asmodeus.panda.model.entity.GreenDaoBean;
import com.jiyun.asmodeus.panda.presenter.cctv.CCTVPresenter;
import com.jiyun.asmodeus.panda.view.adapter.cctv.CCTV_PinDao_Adapter;
import com.maple.mylicecenter.greendao.GreenDaoBeanDao;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CCTV_PindaoFragment extends Fragment implements ICCTVContract.View {


    private RecyclerView CCTV_PinDaoRecy;
    private ICCTVContract.Presenter presenter;
    private CCTV_PinDao_Adapter cctv_pinDao_adapter;
    private ArrayList<CCTVPingDao.ListBean>   mlist = new ArrayList<>();
    public CCTV_PindaoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new CCTVPresenter(this);
        presenter.LoadData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cctv__pindao, container, false);

        initView(view);

        return view;
    }

    @Override
    public void showCCTVPinDao(CCTVPingDao cctvpingdao) {
        mlist.addAll((ArrayList<CCTVPingDao.ListBean>) cctvpingdao.getList());

        cctv_pinDao_adapter.notifyDataSetChanged();
    }

    @Override
    public void showCCTVYangShi(CCTVYangShi cctvYangShi) {

    }


    private void initView(View view) {
        CCTV_PinDaoRecy = (RecyclerView) view.findViewById(R.id.CCTV_PinDaoRecy);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        CCTV_PinDaoRecy.setLayoutManager(linearLayoutManager);
        cctv_pinDao_adapter = new CCTV_PinDao_Adapter(mlist,getContext());
        cctv_pinDao_adapter.setOnItem(new CCTV_PinDao_Adapter.OnItemClick() {
            @Override
            public void setOnItemClick(View v, int position) {
                GreenDaoBean greenDaoBean = new GreenDaoBean(mlist.get(position).getUrl(), mlist.get(position).getTitle(), mlist.get(position).getImage());
                GreenDaoBeanDao instance = GreenDaoUtils.getInstance(getContext());
                instance.insert(greenDaoBean);
            }
        });
        CCTV_PinDaoRecy.setAdapter(cctv_pinDao_adapter);
    }
}
