package com.jiyun.asmodeus.panda.presenter.cctv;

import com.jiyun.asmodeus.panda.contract.cctv.ICCTVContract;
import com.jiyun.asmodeus.panda.model.cctv.CCTVModel;
import com.jiyun.asmodeus.panda.model.cctv.ICCTVModel;
import com.jiyun.asmodeus.panda.model.entity.CCTVPingDao;
import com.jiyun.asmodeus.panda.model.entity.CCTVYangShi;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;

public class CCTVPresenter implements ICCTVContract.Presenter {
    private ICCTVModel model;
    private ICCTVContract.View view;

    public CCTVPresenter(ICCTVContract.View view) {
        this.view = view;
        this.model = new CCTVModel();
    }

    @Override
    public void LoadData() {
        model.LoadCCTVPingDao(new MyNetworkCallback<CCTVPingDao>() {
            @Override
            public void onError(String Message) {

            }

            @Override
            public void onSuccess(CCTVPingDao data) {
                view.showCCTVPinDao(data);
            }
        });
        model.LoadCCTVYangShi(new MyNetworkCallback<CCTVYangShi>() {
            @Override
            public void onError(String Message) {

            }

            @Override
            public void onSuccess(CCTVYangShi data) {
                view.showCCTVYangShi(data);
            }
        });
    }
}
