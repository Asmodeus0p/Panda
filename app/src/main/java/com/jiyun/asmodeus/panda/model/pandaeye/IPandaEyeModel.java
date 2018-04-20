package com.jiyun.asmodeus.panda.model.pandaeye;

import com.jiyun.asmodeus.panda.model.entity.PandaEyeBean;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;

public interface IPandaEyeModel {
    void LoadPandaEyeData(MyNetworkCallback<PandaEyeBean> callback);
}
