package com.jiyun.asmodeus.panda.contract.livechina;

import com.jiyun.asmodeus.panda.model.entity.ChinaLive;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;

public interface IChinaLIveContract {
    public interface Presenter{
        void LoadNowLive();
        void LoadBaDaLin();
        void LoadTaiShan();
        void LoadHuangShan();
        void LoadFengHuang();
        void LoadEMeiShan();
    }
    public interface View {
        void ShowNowLive(ChinaLive chinaLive);
        void ShowBaDaLin(ChinaLive chinaLive);
        void ShowTaiShan(ChinaLive chinaLive);
        void ShowHuangShan(ChinaLive chinaLive);
        void ShowFengHuang(ChinaLive chinaLive);
        void ShowEMeiShan(ChinaLive chinaLive);
    }
}
