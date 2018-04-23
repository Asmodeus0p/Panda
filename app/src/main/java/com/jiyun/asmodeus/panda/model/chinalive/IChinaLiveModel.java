package com.jiyun.asmodeus.panda.model.chinalive;

import com.jiyun.asmodeus.panda.model.entity.ChinaLive;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;

public interface IChinaLiveModel {
    void LoadNowLive(MyNetworkCallback<ChinaLive>callback);
    void LoadBaDaLin(MyNetworkCallback<ChinaLive>callback);
    void LoadTaiShan(MyNetworkCallback<ChinaLive>callback);
    void LoadHuangShan(MyNetworkCallback<ChinaLive>callback);
    void LoadFengHuang(MyNetworkCallback<ChinaLive>callback);
    void LoadEMeiShan(MyNetworkCallback<ChinaLive>callback);
}
