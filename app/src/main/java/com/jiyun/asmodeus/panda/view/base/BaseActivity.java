package com.jiyun.asmodeus.panda.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.jiyun.asmodeus.panda.App;
import com.jiyun.asmodeus.panda.R;

public abstract class BaseActivity extends AppCompatActivity {
    private BaseFragment lastFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.context = this;
        setContentView(getLayoutId());
        initData();
        initView();
    }

    protected abstract int getLayoutId();

    protected abstract void initData();

    protected abstract void initView();
    protected BaseFragment setContentView(Class<? extends BaseFragment> fragmentClass) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //获取Fragment的类名 用做Tag
        String fragmentName = fragmentClass.getSimpleName();
        /**
         * 1、如何创建Fragment对象
         * 2、如何知道该Fragment已经创建过  如果已创建 直接查询到显示 没有创建 才创建
         */

        //根据Tag来查找Fragment
        BaseFragment fragment = (BaseFragment) fragmentManager.findFragmentByTag(fragmentName);
        try {
            if(fragment == null) {
                fragment = fragmentClass.newInstance(); // new Fragment()
                //如果Fragment等于null 代表Fragment还没有被创建 采用java的动态代理创建对象并把Fragment对象添加到事务中
                transaction.add(R.id.fragmentcontainer, fragment, fragmentName);
            }
            //隐藏上一个Fragment
            if(lastFragment != null)
                transaction.hide(lastFragment);

            //显示当前Fragment
            transaction.show(fragment);


        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        lastFragment = fragment;
        transaction.commit();

        return fragment;
    }

    @Override
    protected void onResume() {
        super.onResume();
        App.context =this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.context = null;
    }
}
