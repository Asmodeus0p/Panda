package com.jiyun.asmodeus.panda.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.view.adapter.userfeedback.UserFeedBackAdapter;
import com.jiyun.asmodeus.panda.view.fragment.userfeedback.CommonFragment;
import com.jiyun.asmodeus.panda.view.fragment.userfeedback.MeetRequestFragment;

import java.util.ArrayList;

public class UserfeedbackActivity extends AppCompatActivity {

    private ImageView Userfeedback_return;
    private TabLayout Userfeedback_tablayout;
    private ViewPager Userfeedback_ViewPager;
    private ArrayList<String> titles = new ArrayList<>();
    private ArrayList<Fragment> fragments =  new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userfeedback);
        initData();
        initView();
    }

    private void initData() {
        titles.add("我遇到的问题");
        titles.add("常见问题");
        fragments.add(new CommonFragment());
        fragments.add(new MeetRequestFragment());
    }

    private void initView() {
        Userfeedback_return = (ImageView) findViewById(R.id.Userfeedback_return);
        Userfeedback_tablayout = (TabLayout) findViewById(R.id.Userfeedback_tablayout);
        Userfeedback_ViewPager = (ViewPager) findViewById(R.id.Userfeedback_ViewPager);
        Userfeedback_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Userfeedback_ViewPager.setAdapter(new UserFeedBackAdapter(getSupportFragmentManager(),fragments,titles));
        Userfeedback_tablayout.setupWithViewPager(Userfeedback_ViewPager);
    }
}
