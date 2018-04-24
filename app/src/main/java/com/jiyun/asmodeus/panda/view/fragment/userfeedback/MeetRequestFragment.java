package com.jiyun.asmodeus.panda.view.fragment.userfeedback;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.view.adapter.userfeedback.CommonListViewAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MeetRequestFragment extends Fragment {

    private ArrayList<String> titles = new ArrayList<>();
    private ArrayList<String> cocent = new ArrayList<>();

    private ListView common_listview;

    public MeetRequestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meet_request, container, false);
        initData();
        initView(view);
        return view;
    }

    private void initData() {
        titles.add("1.观看熊猫频道视频对手机网络有什么要求");
        titles.add("2.如何清除缓存");
        titles.add("3.如何进行版本更新");
        titles.add("4.启动或使用时闪退该怎么办？");
        titles.add("5.我有问题，如何反馈？");
        cocent.add("建议您在有WiFi的情况下观看视频，不建议您在2G网络下观看视频熊猫频道可以对您的联网类型进行自动识别，当您在3G、4G情况下观看视频时，手机会自动提示您在使用数据流量环境下观看视频，可能会产生高额费用，是否继续观看。");
        cocent.add("在“个人中心”页面里点击“设置”，在设置页面里选择“清除缓存”。");
        cocent.add("新版本更新以后，用户首次启动客户端，会自动接收到升级提示。点击“升级”即可。IOS用户手机自动跳转至AppStore下载页面，Android用户手机自动后台下载更新。");
        cocent.add("登录或使用熊猫频道时出现闪退，可能是手机运行空间不足或软件数据包丢失导致，请您尝试重启手机或卸载软件后，下载安装最新版本使用。");
        cocent.add("在“个人中心”页面里点击 “设置”，在设置页面里选择“用户反馈及帮助”。根据页面提示提交反馈，我们收到后将及时处理。");
    }
    private void initView(View view) {
        common_listview = (ListView) view.findViewById(R.id.common_listview);
        CommonListViewAdapter commonListViewAdapter = new CommonListViewAdapter(getContext(), titles, cocent);
        common_listview.setAdapter(commonListViewAdapter);
    }
}
