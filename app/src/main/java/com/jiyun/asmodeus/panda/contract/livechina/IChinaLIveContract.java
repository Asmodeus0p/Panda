package com.jiyun.asmodeus.panda.contract.livechina;

import com.jiyun.asmodeus.panda.model.entity.ChinaLive;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;

public interface IChinaLIveContract {
    public interface Presenter{
        void LoadChianLive();

    }
    public interface View {
        void ShowData(ChinaLive chinaLive);

    }
}
