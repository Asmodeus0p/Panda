package com.jiyun.asmodeus.panda.model.hudong;

import com.jiyun.asmodeus.panda.model.entity.HuDong;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;
import com.jiyun.asmodeus.panda.model.http.OkHttpUtlis;

public class HuDongModel implements IHuDongModel {
    @Override
    public void loadData(MyNetworkCallback<HuDong> callback) {
        OkHttpUtlis.getInstance().doGet("http://www.ipanda.com/kehuduan/PAGE14501767715521482/index.json",callback);
    }
}
