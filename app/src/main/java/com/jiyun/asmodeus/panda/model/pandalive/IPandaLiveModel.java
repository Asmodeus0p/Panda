package com.jiyun.asmodeus.panda.model.pandalive;

import com.jiyun.asmodeus.panda.model.entity.PandaLivBean;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;

public interface IPandaLiveModel {
    void LoadPandaLive(MyNetworkCallback<PandaLivBean> callback);
}
