package com.jiyun.asmodeus.panda.view.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.model.GreenDaoUtils;
import com.jiyun.asmodeus.panda.model.entity.GreenDaoBean;
import com.jiyun.asmodeus.panda.view.adapter.history.HistoryListAdapter;
import com.maple.mylicecenter.greendao.GreenDaoBeanDao;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView History_return;
    private TextView History_delect;
    private ListView HistoryList;
    private HistoryListAdapter historyListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initView();
    }

    private void initView() {
        History_return = (ImageView) findViewById(R.id.History_return);
        History_delect = (TextView) findViewById(R.id.History_delect);
        HistoryList = (ListView) findViewById(R.id.HistoryList);
        History_return.setOnClickListener(this);
        History_delect.setOnClickListener(this);
        List<GreenDaoBean> greenDaoBeans = GreenDaoUtils.getInstance(this).loadAll();
        historyListAdapter = new HistoryListAdapter(this, (ArrayList<GreenDaoBean>) greenDaoBeans);
        HistoryList.setAdapter(historyListAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.History_delect:
                GreenDaoBeanDao instance = GreenDaoUtils.getInstance(this);
                instance.deleteAll();
                List<GreenDaoBean> greenDaoBeans = instance.loadAll();
                HistoryListAdapter historyListAdapter = new HistoryListAdapter(this, (ArrayList<GreenDaoBean>) greenDaoBeans);
                HistoryList.setAdapter(historyListAdapter);
                this.historyListAdapter.notifyDataSetChanged();
                break;
            case R.id.History_return:
                finish();
                break;

        }
    }
}
