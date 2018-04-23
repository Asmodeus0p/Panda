package com.jiyun.asmodeus.panda.presenter.hudong;

import com.jiyun.asmodeus.panda.contract.hudong.IHuDongContract;
import com.jiyun.asmodeus.panda.model.entity.HuDong;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;
import com.jiyun.asmodeus.panda.model.hudong.HuDongModel;
import com.jiyun.asmodeus.panda.model.hudong.IHuDongModel;

public class HuDongPresenter implements IHuDongContract.Presenter {
    private IHuDongContract.View view;
    private IHuDongModel huDongModel;

    public HuDongPresenter(IHuDongContract.View view) {
        this.view = view;
        this.huDongModel = new HuDongModel();
    }

    @Override
    public void loadData() {
        huDongModel.loadData(new MyNetworkCallback<HuDong>() {
            @Override
            public void onError(String Message) {

            }

            @Override
            public void onSuccess(HuDong data) {
                view.showData(data);
            }
        });
    }
}
