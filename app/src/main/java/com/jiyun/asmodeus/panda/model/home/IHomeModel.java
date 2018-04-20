package com.jiyun.asmodeus.panda.model.home;

import com.jiyun.asmodeus.panda.model.entity.CCTV;
import com.jiyun.asmodeus.panda.model.entity.GYChina;
import com.jiyun.asmodeus.panda.model.entity.HomeBean;
import com.jiyun.asmodeus.panda.model.entity.HomePandaEye;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;

public interface IHomeModel {
    void loadData(MyNetworkCallback<HomeBean> callback);

    void loadPandaEye(MyNetworkCallback<HomePandaEye> callback);
    void loadCCTv(MyNetworkCallback<CCTV> callback);
    void loadGYChina(MyNetworkCallback<GYChina> callback);
}
