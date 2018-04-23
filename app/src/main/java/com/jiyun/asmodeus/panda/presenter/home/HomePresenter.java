package com.jiyun.asmodeus.panda.presenter.home;

import android.util.Log;

import com.jiyun.asmodeus.panda.contract.home.IHomeContract;
import com.jiyun.asmodeus.panda.model.entity.CCTV;
import com.jiyun.asmodeus.panda.model.entity.GYChina;
import com.jiyun.asmodeus.panda.model.entity.HomeBean;
import com.jiyun.asmodeus.panda.model.entity.HomePandaEye;
import com.jiyun.asmodeus.panda.model.entity.HuDong;
import com.jiyun.asmodeus.panda.model.home.HomeModel;
import com.jiyun.asmodeus.panda.model.home.IHomeModel;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;

public class HomePresenter implements IHomeContract.Presenter {
    public IHomeContract.View iHomeView;
    public IHomeModel homeModel;

    public HomePresenter(IHomeContract.View iHomeView) {
        this.iHomeView = iHomeView;
        this.homeModel = new HomeModel();
    }


    @Override
    public void LoadRecord() {
        homeModel.loadData(new MyNetworkCallback<HomeBean>() {
            @Override
            public void onError(String Message) {

            }

            @Override
            public void onSuccess(HomeBean data) {
                Log.e("sadfg", data.toString());
                iHomeView.ShowData(data);
            }
        });
        homeModel.loadPandaEye(new MyNetworkCallback<HomePandaEye>() {
            @Override
            public void onError(String Message) {

            }

            @Override
            public void onSuccess(HomePandaEye data) {
                iHomeView.ShowData(data);
            }
        });
        homeModel.loadCCTv(new MyNetworkCallback<CCTV>() {
            @Override
            public void onError(String Message) {

            }

            @Override
            public void onSuccess(CCTV data) {
                iHomeView.ShowData(data);
            }
        });
        homeModel.loadGYChina(new MyNetworkCallback<GYChina>() {
            @Override
            public void onError(String Message) {

            }

            @Override
            public void onSuccess(GYChina data) {
                iHomeView.ShowData(data);
            }
        });

    }
}
