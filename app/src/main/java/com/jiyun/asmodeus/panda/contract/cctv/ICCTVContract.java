package com.jiyun.asmodeus.panda.contract.cctv;

import com.jiyun.asmodeus.panda.model.entity.CCTVPingDao;
import com.jiyun.asmodeus.panda.model.entity.CCTVYangShi;

public interface ICCTVContract {
    public interface Presenter{
        void LoadData();
    }
    public interface View{
        void showCCTVPinDao(CCTVPingDao cctvpingdao);
        void showCCTVYangShi(CCTVYangShi cctvYangShi);
    }
}
