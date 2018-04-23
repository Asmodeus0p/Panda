package com.jiyun.asmodeus.panda.presenter.chinalive;

import com.jiyun.asmodeus.panda.contract.livechina.IChinaLIveContract;
import com.jiyun.asmodeus.panda.model.chinalive.ChinaLiveModel;
import com.jiyun.asmodeus.panda.model.chinalive.IChinaLiveModel;
import com.jiyun.asmodeus.panda.model.entity.ChinaLive;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;

public class ChinaLivePresenter implements IChinaLIveContract.Presenter {
    private IChinaLIveContract.View view;
    private IChinaLiveModel model;

    public ChinaLivePresenter(IChinaLIveContract.View view) {
        this.view = view;
        this.model = new ChinaLiveModel();
    }

    @Override
    public void LoadNowLive() {
        model.LoadNowLive(new MyNetworkCallback<ChinaLive>() {
            @Override
            public void onError(String Message) {

            }

            @Override
            public void onSuccess(ChinaLive data) {
                view.ShowNowLive(data);
            }
        });
    }

    @Override
    public void LoadBaDaLin() {
        model.LoadBaDaLin(new MyNetworkCallback<ChinaLive>() {
            @Override
            public void onError(String Message) {

            }

            @Override
            public void onSuccess(ChinaLive data) {
                view.ShowBaDaLin(data);
            }
        });
    }

    @Override
    public void LoadTaiShan() {
        model.LoadTaiShan(new MyNetworkCallback<ChinaLive>() {
            @Override
            public void onError(String Message) {

            }

            @Override
            public void onSuccess(ChinaLive data) {
                view.ShowTaiShan(data);
            }
        });
    }

    @Override
    public void LoadHuangShan() {
        model.LoadHuangShan(new MyNetworkCallback<ChinaLive>() {
            @Override
            public void onError(String Message) {

            }

            @Override
            public void onSuccess(ChinaLive data) {
                view.ShowHuangShan(data);
            }
        });
    }

    @Override
    public void LoadFengHuang() {
        model.LoadFengHuang(new MyNetworkCallback<ChinaLive>() {
            @Override
            public void onError(String Message) {

            }

            @Override
            public void onSuccess(ChinaLive data) {
                view.ShowFengHuang(data);
            }
        });
    }

    @Override
    public void LoadEMeiShan() {
        model.LoadEMeiShan(new MyNetworkCallback<ChinaLive>() {
            @Override
            public void onError(String Message) {

            }

            @Override
            public void onSuccess(ChinaLive data) {
                view.ShowEMeiShan(data);
            }
        });
    }
}
