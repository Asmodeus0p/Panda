package com.jiyun.asmodeus.panda.presenter.chinalive;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.jiyun.asmodeus.panda.App;
import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.contract.livechina.IChinaLIveContract;
import com.jiyun.asmodeus.panda.model.chinalive.ChinaLiveModel;
import com.jiyun.asmodeus.panda.model.chinalive.IChinaLiveModel;
import com.jiyun.asmodeus.panda.model.entity.Bean;
import com.jiyun.asmodeus.panda.model.entity.ChinaLive;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;
import com.jiyun.asmodeus.panda.view.fragment.ChinaLiveFuYongFragment;

import java.util.ArrayList;
import java.util.List;

public class ChinaLivePresenter implements IChinaLIveContract.Presenter {
    private IChinaLIveContract.View view;
    private IChinaLiveModel model;



    public ChinaLivePresenter(IChinaLIveContract.View view) {
        this.view = view;
        this.model = new ChinaLiveModel();
    }


    @Override
    public void LoadChianLive() {
        model.LoadNowLive(new MyNetworkCallback<ChinaLive>() {
            @Override
            public void onError(String Message) {
                Log.e("1234567", Message);
            }

            @Override
            public void onSuccess(ChinaLive data) {
             view.ShowData(data);
            }
        });


    }
}
