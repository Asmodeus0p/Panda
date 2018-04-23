package com.jiyun.asmodeus.panda.model.chinalive;

import com.jiyun.asmodeus.panda.model.entity.ChinaLive;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;
import com.jiyun.asmodeus.panda.model.http.OkHttpUtlis;

public class ChinaLiveModel implements IChinaLiveModel {


    @Override
    public void LoadNowLive(MyNetworkCallback callback) {
        OkHttpUtlis.getInstance().doGet("http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json", callback);
    }
}
