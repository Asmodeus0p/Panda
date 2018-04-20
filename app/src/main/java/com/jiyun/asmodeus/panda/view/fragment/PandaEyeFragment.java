package com.jiyun.asmodeus.panda.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.asmodeus.panda.App;
import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.contract.pandaeye.IPandaIEyeContract;
import com.jiyun.asmodeus.panda.model.entity.PandaEyeBean;
import com.jiyun.asmodeus.panda.presenter.pandaeye.PandaEyePresenter;
import com.jiyun.asmodeus.panda.view.adapter.pandaeye.PandaEyeAdapter;
import com.jiyun.asmodeus.panda.view.base.BaseFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PandaEyeFragment extends BaseFragment implements IPandaIEyeContract.View {

    private RecyclerView pandaeyeRecy;

    @Override
    protected void init() {
        pandaeyeRecy = getView().findViewById(R.id.pandaeyeRecy);
        IPandaIEyeContract.Presenter presenter = new PandaEyePresenter(this);
        presenter.LoadPandaEyeData();


    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panda_eye;
    }


    @Override
    public void showPandaEye(PandaEyeBean pandaEyeBean) {
        pandaeyeRecy.setLayoutManager(new LinearLayoutManager(App.context));
        PandaEyeAdapter pandaEyeAdapter = new PandaEyeAdapter((ArrayList<PandaEyeBean.ListBean>) pandaEyeBean.getList());
        pandaeyeRecy.setAdapter(pandaEyeAdapter);

    }
}
