package com.jiyun.asmodeus.panda.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.model.DataCleanCaChe;

import cn.jpush.android.api.JPushInterface;

public class UpSetActivity extends Activity implements View.OnClickListener {

    private ImageView upset_return;
    private ImageView pe_set_push_view;
    private ImageView pe_set_play_view;
    private TextView set_cache_size_tv;
    private RelativeLayout personal_set_delete_cache_layout;
    private RelativeLayout personal_set_fankui_layout;
    private RelativeLayout personal_set_udpate_layout;
    private RelativeLayout personal_set_ping_layout;
    private RelativeLayout personal_set_about_layout;
    private String totalCacheSize;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upset);
        initView();
    }

    private void initView() {
        upset_return = (ImageView) findViewById(R.id.upset_return);
        pe_set_push_view = (ImageView) findViewById(R.id.pe_set_push_view);
        pe_set_play_view = (ImageView) findViewById(R.id.pe_set_play_view);
        set_cache_size_tv = (TextView) findViewById(R.id.set_cache_size_tv);
        personal_set_delete_cache_layout = (RelativeLayout) findViewById(R.id.personal_set_delete_cache_layout);
        personal_set_fankui_layout = (RelativeLayout) findViewById(R.id.personal_set_fankui_layout);
        personal_set_udpate_layout = (RelativeLayout) findViewById(R.id.personal_set_udpate_layout);
        personal_set_ping_layout = (RelativeLayout) findViewById(R.id.personal_set_ping_layout);
        personal_set_about_layout = (RelativeLayout) findViewById(R.id.personal_set_about_layout);
        try {
            totalCacheSize = DataCleanCaChe.getTotalCacheSize(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        set_cache_size_tv.setText(totalCacheSize);
        upset_return.setOnClickListener(this);
        pe_set_push_view.setOnClickListener(this);
        pe_set_play_view.setOnClickListener(this);
        personal_set_delete_cache_layout.setOnClickListener(this);
        personal_set_fankui_layout.setOnClickListener(this);
        personal_set_udpate_layout.setOnClickListener(this);
        personal_set_ping_layout.setOnClickListener(this);
        personal_set_about_layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.upset_return:
                finish();
                break;
            case R.id.pe_set_push_view:
                count++;
                if (count%2 ==0){
                    pe_set_push_view.setImageResource(R.mipmap.switch_close);
                    JPushInterface.resumePush(this);
                }
                else {
                    pe_set_push_view.setImageResource(R.mipmap.switch_open);
                    JPushInterface.stopPush(this);
                }

                break;
            case R.id.pe_set_play_view:
                count++;
                if (count%2 ==0){
                    pe_set_play_view.setImageResource(R.mipmap.switch_close);

                }
                else {
                    pe_set_play_view.setImageResource(R.mipmap.switch_open);
                }

                break;
            case R.id.personal_set_delete_cache_layout:
               DataCleanCaChe.clearAllCache(this);
                set_cache_size_tv.setText("0KB");
                break;
            case R.id.personal_set_fankui_layout:
                    startActivity(new Intent(this,UserfeedbackActivity.class));
                break;
            case R.id.personal_set_udpate_layout:
                Toast.makeText(this, "已经是最新版本！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.personal_set_ping_layout:
                break;
            case R.id.personal_set_about_layout:
                startActivity(new Intent(UpSetActivity.this,AboutPandaActivity.class));
                break;

        }
    }

}
