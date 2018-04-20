package com.jiyun.asmodeus.panda.model.home;

import com.jiyun.asmodeus.panda.model.entity.CCTV;
import com.jiyun.asmodeus.panda.model.entity.GYChina;
import com.jiyun.asmodeus.panda.model.entity.HomeBean;
import com.jiyun.asmodeus.panda.model.entity.HomePandaEye;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;
import com.jiyun.asmodeus.panda.model.http.OkHttpUtlis;

public class HomeModel implements IHomeModel {
    @Override
    public void loadData(MyNetworkCallback<HomeBean> callback) {
        OkHttpUtlis.getInstance().doGet("http://www.ipanda.com/kehuduan/PAGE14501749764071042/index.json",callback);
    }

    @Override
    public void loadPandaEye(MyNetworkCallback<HomePandaEye>callback){
        OkHttpUtlis.getInstance().doGet(" http://www.ipanda.com/kehuduan/shipinliebieye/xiongmaoguancha/index.json",callback);
    }

    @Override
    public void loadCCTv(MyNetworkCallback<CCTV> callback) {
        OkHttpUtlis.getInstance().doGet(" http://www.ipanda.com/kehuduan/shipinliebieye/cctvshipindicengye/index.json",callback);
    }

    @Override
    public void loadGYChina(MyNetworkCallback<GYChina> callback) {
        OkHttpUtlis.getInstance().doGet("http://www.ipanda.com/kehuduan/shipinliebieye/guangyingzhongguo/index.json",callback);
    }
}
