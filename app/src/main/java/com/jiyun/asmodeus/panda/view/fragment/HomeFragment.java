package com.jiyun.asmodeus.panda.view.fragment;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jiyun.asmodeus.panda.App;
import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.contract.home.IHomeContract;
import com.jiyun.asmodeus.panda.model.GreenDaoUtils;
import com.jiyun.asmodeus.panda.model.entity.CCTV;
import com.jiyun.asmodeus.panda.model.entity.GYChina;
import com.jiyun.asmodeus.panda.model.entity.GreenDaoBean;
import com.jiyun.asmodeus.panda.model.entity.HomeBean;
import com.jiyun.asmodeus.panda.model.entity.HomePandaEye;
import com.jiyun.asmodeus.panda.presenter.home.HomePresenter;
import com.jiyun.asmodeus.panda.view.adapter.home.HomeCCTVAdapter;
import com.jiyun.asmodeus.panda.view.adapter.home.HomeGYAdapter;
import com.jiyun.asmodeus.panda.view.adapter.home.HomePandaEyeAdapter;
import com.jiyun.asmodeus.panda.view.adapter.home.RecyAdapter;
import com.jiyun.asmodeus.panda.view.base.BaseFragment;
import com.maple.mylicecenter.greendao.GreenDaoBeanDao;

import java.util.ArrayList;


public class HomeFragment extends BaseFragment implements IHomeContract.View {


    private RecyclerView recy;
    private ArrayList<Object> mlist =new ArrayList<>();
    private RecyAdapter recyAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        recyAdapter = new RecyAdapter(mlist);
    }

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    protected void init() {
        recy = getView().findViewById(R.id.homeRecy);
        IHomeContract.Presenter presenter =  new HomePresenter(this);
        presenter.LoadRecord();
        recy.setLayoutManager(new LinearLayoutManager(App.context));


    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }




    @Override
    public void ShowData(HomeBean data) {
        HomeBean.DataBean dataBean = data.getData();
        mlist.add(dataBean.getBigImg());
        mlist.add(dataBean.getArea());
        mlist.add(dataBean.getPandaeye());
        mlist.add(dataBean.getPandalive());
        mlist.add(dataBean.getWalllive());
        mlist.add(dataBean.getChinalive());
        mlist.add(dataBean.getInteractive());
        mlist.add(dataBean.getCctv());
        mlist.add(dataBean.getList());


    }

    @Override
    public void ShowData(final HomePandaEye eye) {

        recy.setAdapter(recyAdapter);
        recyAdapter.getData(new RecyAdapter.UpdataInter() {
            @Override
            public void setData(RecyclerView recyclerView) {

                recyclerView.setLayoutManager(new LinearLayoutManager(App.context));
                HomePandaEyeAdapter eyeAdapter = new HomePandaEyeAdapter((ArrayList<HomePandaEye.ListBean>) eye.getList());
               recyclerView.setAdapter(eyeAdapter);
            }
        });

    }

    @Override
    public void ShowData(final CCTV data) {

        recyAdapter.getDataTwo(new RecyAdapter.UpdataIntertwo() {
            @Override
            public void setDataTwo(RecyclerView stu) {
                stu.setLayoutManager(new GridLayoutManager(App.context,2));
                stu.setAdapter(new HomeCCTVAdapter((ArrayList<CCTV.ListBean>) data.getList()));
            }
        });
    }

    @Override
    public void ShowData(final GYChina s) {
        recyAdapter.getDataThree(new RecyAdapter.UpdataInterthree() {
            @Override
            public void setDataThree(RecyclerView stu) {
                stu.setLayoutManager(new LinearLayoutManager(App.context));
                final ArrayList<GYChina.ListBean> list = (ArrayList<GYChina.ListBean>) s.getList();
                HomeGYAdapter homeGYAdapter = new HomeGYAdapter(list);
                homeGYAdapter.setOnItem(new HomeGYAdapter.OnItemClick() {
                    @Override
                    public void setOnItemClick(View v, int position) {
                        GreenDaoBean greenDaoBean = new GreenDaoBean(list.get(position).getUrl(), list.get(position).getTitle(), list.get(position).getImage());
                        GreenDaoBeanDao instance = GreenDaoUtils.getInstance(getContext());
                        instance.insert(greenDaoBean);
                    }
                });
                stu.setAdapter(homeGYAdapter);
            }
        });
    }


}
