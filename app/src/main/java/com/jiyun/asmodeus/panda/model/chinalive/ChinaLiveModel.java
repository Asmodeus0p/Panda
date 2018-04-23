package com.jiyun.asmodeus.panda.model.chinalive;

import com.jiyun.asmodeus.panda.model.entity.ChinaLive;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;
import com.jiyun.asmodeus.panda.model.http.OkHttpUtlis;

public class ChinaLiveModel implements IChinaLiveModel {
    @Override
    public void LoadNowLive(MyNetworkCallback<ChinaLive> callback) {
        OkHttpUtlis.getInstance().doGet("http://www.ipanda.com/kehuduan/liebiao/shanhaiguan/index.json",callback);
    }

    @Override
    public void LoadBaDaLin(MyNetworkCallback<ChinaLive> callback) {
        OkHttpUtlis.getInstance().doGet("http://www.ipanda.com/kehuduan/liebiao/badaling/index.json",callback);

    }

    @Override
    public void LoadTaiShan(MyNetworkCallback<ChinaLive> callback) {
        OkHttpUtlis.getInstance().doGet("http://www.ipanda.com/kehuduan/liebiao/taishan/index.json",callback);

    }

    @Override
    public void LoadHuangShan(MyNetworkCallback<ChinaLive> callback) {

        OkHttpUtlis.getInstance().doGet("http://www.ipanda.com/kehuduan/liebiao/huangshan/index.json",callback);
    }

    @Override
    public void LoadFengHuang(MyNetworkCallback<ChinaLive> callback) {

        OkHttpUtlis.getInstance().doGet("http://www.ipanda.com/kehuduan/liebiao/fenghuanggucheng/index.json",callback);
    }

    @Override
    public void LoadEMeiShan(MyNetworkCallback<ChinaLive> callback) {

        OkHttpUtlis.getInstance().doGet("http://www.ipanda.com/kehuduan/liebiao/emeishan/index.json",callback);
    }
}
