package com.jiyun.asmodeus.panda.view;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.jiyun.asmodeus.panda.PersonalCenterActivity;
import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.view.base.BaseActivity;
import com.jiyun.asmodeus.panda.view.fragment.CCTVFragment;
import com.jiyun.asmodeus.panda.view.fragment.HomeFragment;
import com.jiyun.asmodeus.panda.view.fragment.LiveChinaFragment;
import com.jiyun.asmodeus.panda.view.fragment.PandaEyeFragment;
import com.jiyun.asmodeus.panda.view.fragment.PandaLiveFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageView2;
    private ImageView hudongsign;
    private ImageView personsign;
    private FrameLayout container;
    private RadioButton homebtn;
    private RadioButton pandaeyebtn;
    private RadioButton pandalivebtn;
    private RadioButton chinalivebtn;
    private RadioButton cctvbtn;
    private TextView title;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }


    @Override
    protected void initView() {
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        hudongsign = (ImageView) findViewById(R.id.hudongsign);
        personsign = (ImageView) findViewById(R.id.personsign);
        container = (FrameLayout) findViewById(R.id.container);
        homebtn = (RadioButton) findViewById(R.id.homebtn);
        pandaeyebtn = (RadioButton) findViewById(R.id.pandaeyebtn);
        pandalivebtn = (RadioButton) findViewById(R.id.pandalivebtn);
        chinalivebtn = (RadioButton) findViewById(R.id.chinalivebtn);
        cctvbtn = (RadioButton) findViewById(R.id.cctvbtn);
        title = (TextView) findViewById(R.id.title);
        cctvbtn.setOnClickListener(this);
        homebtn.setOnClickListener(this);
        pandaeyebtn.setOnClickListener(this);
        pandalivebtn.setOnClickListener(this);
        chinalivebtn.setOnClickListener(this);
        hudongsign.setOnClickListener(this);
        personsign.setOnClickListener(this);
        setContentView(HomeFragment.class);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hudongsign:

                break;
            case R.id.personsign:
                startActivity(new Intent(this, PersonalCenterActivity.class));
                break;
            case R.id.homebtn:
                setContentView(HomeFragment.class);
                imageView2.setVisibility(View.VISIBLE);
                hudongsign.setVisibility(View.VISIBLE);
                personsign.setVisibility(View.VISIBLE);
                title.setVisibility(View.GONE);
                break;
            case R.id.pandaeyebtn:
                setContentView(PandaEyeFragment.class);
                imageView2.setVisibility(View.GONE);
                hudongsign.setVisibility(View.GONE);
                personsign.setVisibility(View.VISIBLE);
                title.setVisibility(View.VISIBLE);
                title.setText("熊猫观察");
                break;
            case R.id.pandalivebtn:
                setContentView(PandaLiveFragment.class);
                imageView2.setVisibility(View.GONE);
                hudongsign.setVisibility(View.GONE);
                personsign.setVisibility(View.VISIBLE);
                title.setVisibility(View.VISIBLE);
                title.setText("熊猫直播");
                break;
            case R.id.chinalivebtn:
                setContentView(LiveChinaFragment.class);
                imageView2.setVisibility(View.GONE);
                hudongsign.setVisibility(View.GONE);
                personsign.setVisibility(View.VISIBLE);
                title.setVisibility(View.VISIBLE);
                title.setText("直播中国");
                break;
            case R.id.cctvbtn:
                setContentView(CCTVFragment.class);
                imageView2.setVisibility(View.GONE);
                hudongsign.setVisibility(View.GONE);
                personsign.setVisibility(View.VISIBLE);
                title.setVisibility(View.VISIBLE);
                title.setText("CCTV");
                break;
        }
    }


}
