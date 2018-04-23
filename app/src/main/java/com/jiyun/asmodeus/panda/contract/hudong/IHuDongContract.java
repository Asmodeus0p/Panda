package com.jiyun.asmodeus.panda.contract.hudong;

import com.jiyun.asmodeus.panda.model.entity.HuDong;

public interface IHuDongContract {
    public interface Presenter{
        void loadData();
    }
    public interface View{
        void showData(HuDong huDong);
    }
}
