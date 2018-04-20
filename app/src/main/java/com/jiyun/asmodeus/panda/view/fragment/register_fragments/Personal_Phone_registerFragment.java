package com.jiyun.asmodeus.panda.view.fragment.register_fragments;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jiyun.asmodeus.panda.App;
import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.model.http.MyNetworkCallback;
import com.jiyun.asmodeus.panda.model.http.OkHttpUtlis;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class Personal_Phone_registerFragment extends Fragment {


    private EditText ed_phone;
    private TextView hint_phone;
    private EditText ed_phoneimgcheck;
    private ImageView personal_reg_phoneimgcheck;
    private TextView hint_phoneimagecheck;
    private EditText ed_phonecheck;
    private TextView personal_reg_phonecheck;
    private TextView hint_phonecheck;
    private EditText ed_phone_passwork;
    private TextView hint_phonepassword;
    private CheckBox ch_phone_xieyi_check;
    private TextView hint_phone_xieyi;
    private TextView btn_phone_register;
    private String jsessionid;

    public Personal_Phone_registerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal__phone_register, container, false);
        requestYanzhengma();

        initView(view);
        return view;
    }


    private void initView(View view) {
        requestYanzhengma();
        ed_phone = (EditText) view.findViewById(R.id.ed_phone);
        hint_phone = (TextView) view.findViewById(R.id.hint_phone);
        ed_phoneimgcheck = (EditText) view.findViewById(R.id.ed_phoneimgcheck);
        personal_reg_phoneimgcheck = (ImageView) view.findViewById(R.id.personal_reg_phoneimgcheck);
        hint_phoneimagecheck = (TextView) view.findViewById(R.id.hint_phoneimagecheck);
        ed_phonecheck = (EditText) view.findViewById(R.id.ed_phonecheck);
        personal_reg_phonecheck = (TextView) view.findViewById(R.id.personal_reg_phonecheck);
        hint_phonecheck = (TextView) view.findViewById(R.id.hint_phonecheck);
        ed_phone_passwork = (EditText) view.findViewById(R.id.ed_phone_passwork);
        hint_phonepassword = (TextView) view.findViewById(R.id.hint_phonepassword);
        ch_phone_xieyi_check = (CheckBox) view.findViewById(R.id.ch_phone_xieyi_check);
        hint_phone_xieyi = (TextView) view.findViewById(R.id.hint_phone_xieyi);
        btn_phone_register = (TextView) view.findViewById(R.id.btn_phone_register);
        btn_phone_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
                sendPhoneRegistHttp();
            }
        });
        personal_reg_phoneimgcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestYanzhengma();
            }
        });
        personal_reg_phonecheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPhone();
            }
        });
    }

    private void requestYanzhengma() {
        final Request request = new Request.Builder().url("http://reg.cntv.cn/simple/verificationCode.action").build();
        OkHttpClient build = new OkHttpClient.Builder().build();
        build.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(final Call call, Response response) throws IOException {


                Headers headers = response.headers();//获取服务器所有响应头
                jsessionid = headers.get("Set-Cookie");
                Log.e("12345", jsessionid);
                final byte[] result = response.body().bytes();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(getActivity()).load(result).into(personal_reg_phoneimgcheck);
                    }
                });


            }
        });
    }

    /*
     * 请求手机验证码
     * */
    private void requestPhone() {
        final FormBody.Builder builder = new FormBody.Builder();
        String phoneString = ed_phone.getText().toString().trim();
        String phoneyanzhengma = ed_phoneimgcheck.getText().toString().trim();
        String url = "http://reg.cntv.cn/regist/getVerifiCode.action";
        String from = "http://cbox_mobile.regclientuser.cntv.cn";
        final HashMap<String, String> tHeaders = new HashMap<String, String>();
        try {

            tHeaders.put("Referer", URLEncoder.encode(from, "UTF-8"));
            tHeaders.put("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"));
            tHeaders.put("Cookie", jsessionid);
        } catch (Exception e) {
        }
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("method", "getRequestVerifiCodeM");
        params.put("mobile", phoneString);
        params.put("verfiCodeType", "1");
        params.put("verificationCode", phoneyanzhengma);
        if (params != null && params.size() > 0) {
            Set<String> keySet = params.keySet();

            for (String key : keySet) {
                String value = params.get(key);
                builder.add(key, value);
            }
        }
        FormBody formBody = builder.build();
        OkHttpClient build = new OkHttpClient.Builder().build();
        Request.Builder url1 = new Request.Builder().url(url);
        Set<String> name = tHeaders.keySet();
        for (String s : name) {
            String s1 = tHeaders.get(s);
            url1.addHeader(s, s1);
        }
        Request request = url1.post(formBody).build();
        build.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("12345", response.body().string());
            }
        });
    }

    private void sendPhoneRegistHttp() {
        final FormBody.Builder builder = new FormBody.Builder();
        String url = "https://reg.cntv.cn/regist/mobileRegist.do";
        String tPhoneNumber = ed_phone.getText().toString().trim();
        String tCheckPhone = ed_phonecheck.getText().toString().trim();
        String tPassWord = ed_phone_passwork.getText().toString();

        HashMap<String, String> tHeader = new HashMap<String, String>();
        try {

            tHeader.put("Referer", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"));
            tHeader.put("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        HashMap<String, String> tParams = new HashMap<String, String>();
        tParams.put("method", "saveMobileRegisterM");
        tParams.put("mobile", tPhoneNumber);
        tParams.put("verfiCode", tCheckPhone);
        try {
            tParams.put("passWd", URLEncoder.encode(tPassWord, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        tParams.put("verfiCodeType", "1");
        try {
            tParams.put("addons", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (tParams != null && tParams.size() > 0) {
            Set<String> keySet = tParams.keySet();

            for (String key : keySet) {
                String value = tParams.get(key);
                builder.add(key, value);

            }
        }
        FormBody formBody = builder.build();
        OkHttpClient build = new OkHttpClient.Builder().build();
        Request.Builder url1 = new Request.Builder().url(url);
        Set<String> name = tHeader.keySet();
        for (String s : name) {
            String s1 = tHeader.get(s);
            url1.addHeader(s, s1);
        }

        final Request request = url1.post(formBody).build();
        build.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String string = response.body().string();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(),string , Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

    private void submit() {
        // validate
        String phone = ed_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(getContext(), "账号：请输入手机账号", Toast.LENGTH_SHORT).show();
            return;
        }
        String phoneimgcheck = ed_phoneimgcheck.getText().toString().trim();
        if (TextUtils.isEmpty(phoneimgcheck)) {
            Toast.makeText(getContext(), "请输入图片验证码", Toast.LENGTH_SHORT).show();
            return;
        }
        String phonecheck = ed_phonecheck.getText().toString().trim();
        if (TextUtils.isEmpty(phonecheck)) {
            Toast.makeText(getContext(), "请输入收到验证码", Toast.LENGTH_SHORT).show();
            return;
        }
        String passwork = ed_phone_passwork.getText().toString().trim();
        if (TextUtils.isEmpty(passwork)) {
            Toast.makeText(getContext(), "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!ch_phone_xieyi_check.isChecked()) {
            hint_phone_xieyi.setText("未勾选《央视网网络服务使用协议》");
        } else {
            hint_phone_xieyi.setText("");
        }
    }

}
