package com.jiyun.asmodeus.panda.contract.pandaeye;

import com.jiyun.asmodeus.panda.model.entity.PandaEyeBean;

public interface IPandaIEyeContract {
    public  interface  View {
        void showPandaEye(PandaEyeBean pandaEyeBean);
    }
    public interface Presenter{
        void LoadPandaEyeData();
    }
}
