package com.jiyun.asmodeus.panda.presenter.pandalive;

import com.jiyun.asmodeus.panda.contract.pandalive.IPandaLiveContract;
import com.jiyun.asmodeus.panda.model.entity.PandaLivBean;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;
import com.jiyun.asmodeus.panda.model.pandalive.IPandaLiveModel;
import com.jiyun.asmodeus.panda.model.pandalive.PandaLiveModel;

public class PandaLivePresenter implements IPandaLiveContract.Presenter {
    private IPandaLiveContract.View view;
    private IPandaLiveModel model;

    public PandaLivePresenter(IPandaLiveContract.View view) {
        this.view = view;
        this.model = new PandaLiveModel();
    }

    @Override
    public void loadPandaLive() {
        model.LoadPandaLive(new MyNetworkCallback<PandaLivBean>() {
            @Override
            public void onError(String Message) {

            }

            @Override
            public void onSuccess(PandaLivBean data) {
                view.ShowPandaLiveData(data);
            }
        });
    }
}
