package com.jiyun.asmodeus.panda.contract.livechina;

import android.support.v4.app.Fragment;
import android.widget.PopupWindow;

import com.jiyun.asmodeus.panda.model.entity.Bean;
import com.jiyun.asmodeus.panda.model.entity.ChinaLive;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;

import java.util.List;

public interface IChinaLIveContract {
    public interface Presenter {
        void LoadChianLive();

    }

    public interface View {
        void ShowData(ChinaLive data);

    }
}
