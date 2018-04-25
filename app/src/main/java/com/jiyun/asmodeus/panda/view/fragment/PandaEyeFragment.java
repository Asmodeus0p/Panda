package com.jiyun.asmodeus.panda.view.fragment;



import android.widget.ListView;
import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.contract.pandaeye.IPandaIEyeContract;
import com.jiyun.asmodeus.panda.model.entity.PandaEyeBean;
import com.jiyun.asmodeus.panda.presenter.pandaeye.PandaEyePresenter;
import com.jiyun.asmodeus.panda.view.adapter.pandaeye.PandaEyeAdapter;
import com.jiyun.asmodeus.panda.view.base.BaseFragment;
import java.util.ArrayList;


public class PandaEyeFragment extends BaseFragment implements IPandaIEyeContract.View {
    private ListView pandaeyeRecy;
    @Override
    protected void init() {
        pandaeyeRecy = getView().findViewById(R.id.pandaeyeRecy);
        IPandaIEyeContract.Presenter presenter = new PandaEyePresenter(this);
        presenter.LoadPandaEyeData();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panda_eye;
    }
    @Override
    public void showPandaEye(PandaEyeBean pandaEyeBean) {
        PandaEyeAdapter pandaEyeAdapter = new PandaEyeAdapter(getContext(), (ArrayList<PandaEyeBean.ListBean>) pandaEyeBean.getList());
        pandaeyeRecy.addHeaderView(getLayoutInflater().inflate(R.layout.pandaeye_head,null));
        pandaeyeRecy.setAdapter(pandaEyeAdapter);
    }
}
