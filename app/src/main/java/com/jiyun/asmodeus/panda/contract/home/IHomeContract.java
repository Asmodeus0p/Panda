package com.jiyun.asmodeus.panda.contract.home;

import com.jiyun.asmodeus.panda.model.entity.CCTV;
import com.jiyun.asmodeus.panda.model.entity.GYChina;
import com.jiyun.asmodeus.panda.model.entity.HomeBean;
import com.jiyun.asmodeus.panda.model.entity.HomePandaEye;

public interface IHomeContract {
    public interface View{
        void ShowData(HomeBean data);
        void ShowData(HomePandaEye eye);
        void ShowData(CCTV data);
        void ShowData(GYChina s);
    }
    public  interface  Presenter{
        void LoadRecord();
    }
}
