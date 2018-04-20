package com.jiyun.asmodeus.panda.model.pandaeye;

import com.jiyun.asmodeus.panda.model.entity.PandaEyeBean;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;
import com.jiyun.asmodeus.panda.model.http.OkHttpUtlis;

public class PandaEyeModel implements IPandaEyeModel {
    @Override
    public void LoadPandaEyeData(MyNetworkCallback<PandaEyeBean> callback) {
        OkHttpUtlis.getInstance().doGet("http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1449807494852603,PAGE1451473625420136,PAGE1449807502866458,PAGE1451473627439140,PAGE1451473547108278,PAGE1451473628934144&serviceId=panda", callback
        );
    }
}
