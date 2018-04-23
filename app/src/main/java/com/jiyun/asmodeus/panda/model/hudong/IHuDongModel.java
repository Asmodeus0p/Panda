package com.jiyun.asmodeus.panda.model.hudong;

import com.jiyun.asmodeus.panda.model.entity.HuDong;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;

public interface IHuDongModel {
    void loadData(MyNetworkCallback<HuDong>callback);
}
