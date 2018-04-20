package com.jiyun.asmodeus.panda.model.cctv;

import com.jiyun.asmodeus.panda.model.entity.CCTVPingDao;
import com.jiyun.asmodeus.panda.model.entity.CCTVYangShi;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;

public interface ICCTVModel {
    void LoadCCTVPingDao(MyNetworkCallback<CCTVPingDao>callback);
    void LoadCCTVYangShi(MyNetworkCallback<CCTVYangShi>callback);
}
