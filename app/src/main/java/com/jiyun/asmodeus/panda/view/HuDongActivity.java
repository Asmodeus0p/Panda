package com.jiyun.asmodeus.panda.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.contract.hudong.IHuDongContract;
import com.jiyun.asmodeus.panda.model.entity.HuDong;
import com.jiyun.asmodeus.panda.presenter.hudong.HuDongPresenter;
import com.jiyun.asmodeus.panda.view.adapter.hudong.HuDongRecyAdapter;

import java.util.ArrayList;
import java.util.List;

public class HuDongActivity extends Activity implements IHuDongContract.View {

    private RecyclerView hudongRecy;
    private ArrayList<HuDong.InteractiveBean> mlist  =  new ArrayList<>();
    private HuDongRecyAdapter huDongRecyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hu_dong);

        initView();
        IHuDongContract.Presenter presenter =  new HuDongPresenter(this);
        presenter.loadData();

    }

    @Override
    public void showData(HuDong huDong) {
        List<HuDong.InteractiveBean> interactive = huDong.getInteractive();
        mlist.addAll(interactive);
        huDongRecyAdapter.notifyDataSetChanged();
    }

    private void initView() {
        hudongRecy = (RecyclerView) findViewById(R.id.hudongRecy);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        huDongRecyAdapter = new HuDongRecyAdapter(mlist);
        hudongRecy.setLayoutManager(linearLayoutManager);
        hudongRecy.setAdapter(huDongRecyAdapter);
        huDongRecyAdapter.setOnItem(new HuDongRecyAdapter.OnItemClick() {
            @Override
            public void setOnItemClick(View v, int position) {
                String url = mlist.get(position).getUrl();
                Intent intent = new Intent(HuDongActivity.this, WebActivity.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });
    }
}
