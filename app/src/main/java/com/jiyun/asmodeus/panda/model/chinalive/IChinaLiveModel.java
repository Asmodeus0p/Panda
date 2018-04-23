package com.jiyun.asmodeus.panda.model.chinalive;

import com.jiyun.asmodeus.panda.model.entity.ChinaLive;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;

public interface IChinaLiveModel {
    void LoadNowLive(MyNetworkCallback<ChinaLive> callback);

}
