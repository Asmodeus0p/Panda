package com.jiyun.asmodeus.panda;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.jiyun.asmodeus.panda.view.adapter.register.RegisterViewPagerAdapter;
import com.jiyun.asmodeus.panda.view.fragment.register_fragments.Personal_EmilFragment;
import com.jiyun.asmodeus.panda.view.fragment.register_fragments.Personal_Phone_registerFragment;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    private ImageView register_return;
    private TabLayout RegisterTablayout;
    private ViewPager RegisterViewPager;
    private ArrayList<String> registerTitles = new ArrayList<>();
    private ArrayList<Fragment> registerFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initData();
        initView();
    }

    private void initData() {
        registerTitles.add("手机注册");
        registerTitles.add("邮箱注册");
        registerFragments.add(new Personal_Phone_registerFragment());
        registerFragments.add(new Personal_EmilFragment());
    }

    private void initView() {
        register_return = (ImageView) findViewById(R.id.register_return);
        RegisterTablayout = (TabLayout) findViewById(R.id.RegisterTablayout);
        RegisterViewPager = (ViewPager) findViewById(R.id.RegisterViewPager);
        RegisterTablayout.setupWithViewPager(RegisterViewPager);
        RegisterViewPager.setAdapter(new RegisterViewPagerAdapter(this.getSupportFragmentManager(),registerFragments,registerTitles));
        register_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
