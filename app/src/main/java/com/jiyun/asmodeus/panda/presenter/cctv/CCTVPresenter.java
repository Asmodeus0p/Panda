package com.jiyun.asmodeus.panda.presenter.cctv;

import com.jiyun.asmodeus.panda.contract.cctv.ICCTVContract;
import com.jiyun.asmodeus.panda.model.cctv.CCTVModel;
import com.jiyun.asmodeus.panda.model.cctv.ICCTVModel;

public class CCTVPresenter implements ICCTVContract.Presenter {
    private ICCTVModel model;
    private ICCTVContract.View view;

    public CCTVPresenter(ICCTVContract.View view) {
        this.view = view;
        this.model = new CCTVModel();
    }

    @Override
    public void LoadData() {

    }
}
