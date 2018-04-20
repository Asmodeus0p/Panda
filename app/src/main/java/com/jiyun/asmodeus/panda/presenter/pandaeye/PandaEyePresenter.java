package com.jiyun.asmodeus.panda.presenter.pandaeye;

import com.jiyun.asmodeus.panda.contract.pandaeye.IPandaIEyeContract;
import com.jiyun.asmodeus.panda.model.entity.PandaEyeBean;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;
import com.jiyun.asmodeus.panda.model.pandaeye.IPandaEyeModel;
import com.jiyun.asmodeus.panda.model.pandaeye.PandaEyeModel;

public class PandaEyePresenter implements IPandaIEyeContract.Presenter {
    private IPandaEyeModel iPandaEyeModel;
    private IPandaIEyeContract.View view;

    public PandaEyePresenter(IPandaIEyeContract.View view) {
        this.view = view;
        iPandaEyeModel = new PandaEyeModel();
    }

    @Override
    public void LoadPandaEyeData() {
        iPandaEyeModel.LoadPandaEyeData(new MyNetworkCallback<PandaEyeBean>() {
            @Override
            public void onError(String Message) {

            }

            @Override
            public void onSuccess(PandaEyeBean data) {
                view.showPandaEye(data);
            }
        });
    }
}
