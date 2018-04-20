package com.jiyun.asmodeus.panda.contract.pandalive;

import com.jiyun.asmodeus.panda.model.entity.PandaLivBean;

public interface IPandaLiveContract {
    public interface Presenter{
           void loadPandaLive();
    }
    public interface View{
        void ShowPandaLiveData(PandaLivBean livBean);
    }
}
