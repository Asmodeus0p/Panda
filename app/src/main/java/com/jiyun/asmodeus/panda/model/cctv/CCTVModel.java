package com.jiyun.asmodeus.panda.model.cctv;

import com.jiyun.asmodeus.panda.model.entity.CCTVPingDao;
import com.jiyun.asmodeus.panda.model.entity.CCTVYangShi;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;
import com.jiyun.asmodeus.panda.model.http.OkHttpUtlis;

public class CCTVModel implements ICCTVModel {
    @Override
    public void LoadCCTVPingDao(MyNetworkCallback<CCTVPingDao> callback) {
        OkHttpUtlis.getInstance().doGet("http://www.ipanda.com/kehuduan/PAGE14501778924722682/index.json",callback);
    }

    @Override
    public void LoadCCTVYangShi(MyNetworkCallback<CCTVYangShi> callback) {
        OkHttpUtlis.getInstance().doGet("http://www.ipanda.com/kehuduan/PAGE14501780213812842/index.json",callback);

    }
}
