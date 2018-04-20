package com.jiyun.asmodeus.panda.view.fragment.pandalivelive;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.asmodeus.panda.App;
import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.contract.pandalive.IPandaLiveContract;
import com.jiyun.asmodeus.panda.model.entity.PandaLivBean;
import com.jiyun.asmodeus.panda.presenter.pandalive.PandaLivePresenter;
import com.jiyun.asmodeus.panda.view.adapter.pandalive.PandaLiveMoreAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PandaLiveMoreFragment extends Fragment implements IPandaLiveContract.View {


    private RecyclerView PandaLiveLiveRecy;

    public PandaLiveMoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_panda_live_more, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        PandaLiveLiveRecy = (RecyclerView) view.findViewById(R.id.PandaLiveLiveRecy);
        PandaLiveLiveRecy.setLayoutManager(new GridLayoutManager(App.context,3));
        IPandaLiveContract.Presenter presenter = new PandaLivePresenter(this);
        presenter.loadPandaLive();
    }

    @Override
    public void ShowPandaLiveData(PandaLivBean livBean) {
        PandaLiveLiveRecy.setAdapter(new PandaLiveMoreAdapter((ArrayList<PandaLivBean.ListBean>) livBean.getList()));

    }
}
