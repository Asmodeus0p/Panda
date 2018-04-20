package com.jiyun.asmodeus.panda.model.pandalive;

import com.jiyun.asmodeus.panda.model.entity.PandaLivBean;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;
import com.jiyun.asmodeus.panda.model.http.OkHttpUtlis;

public class PandaLiveModel implements IPandaLiveModel {
    @Override
    public void LoadPandaLive(MyNetworkCallback<PandaLivBean> callback) {

        OkHttpUtlis.getInstance().doGet("http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE14501787896813312/index.json",callback);
    }
}
