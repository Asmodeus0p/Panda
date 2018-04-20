package com.jiyun.asmodeus.panda.view.fragment.register_fragments;


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
import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.model.http.OkHttpUtlis;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class Personal_EmilFragment extends Fragment {


    private EditText ed_emil;
    private TextView hint_emil;
    private EditText ed_emilcheck;
    private TextView hint_emilcheck;
    private EditText ed_reg_emilcheck;
    private TextView hint_reg_emilcheck;
    private EditText ed_emil_imgcheck;
    private ImageView personal_reg_emil_imgcheck;
    private TextView hint_emil_imgcheck;
    private CheckBox ch_emil_xieyi_check;
    private TextView hint_emil_xieyi;
    private TextView btn_emil_register;
    private String jsessionid;
    public Personal_EmilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal__emil, container, false);
        initView(view);
        requestYanzhengma();
        return view;
    }

    private void initView(View view) {
        ed_emil = (EditText) view.findViewById(R.id.ed_emil);
        hint_emil = (TextView) view.findViewById(R.id.hint_emil);
        ed_emilcheck = (EditText) view.findViewById(R.id.ed_emilcheck);
        hint_emilcheck = (TextView) view.findViewById(R.id.hint_emilcheck);
        ed_reg_emilcheck = (EditText) view.findViewById(R.id.ed_reg_emilcheck);
        hint_reg_emilcheck = (TextView) view.findViewById(R.id.hint_reg_emilcheck);
        ed_emil_imgcheck = (EditText) view.findViewById(R.id.ed_emil_imgcheck);
        personal_reg_emil_imgcheck = (ImageView) view.findViewById(R.id.personal_reg_emil_imgcheck);
        hint_emil_imgcheck = (TextView) view.findViewById(R.id.hint_emil_imgcheck);
        ch_emil_xieyi_check = (CheckBox) view.findViewById(R.id.ch_emil_xieyi_check);
        hint_emil_xieyi = (TextView) view.findViewById(R.id.hint_emil_xieyi);
        btn_emil_register = (TextView) view.findViewById(R.id.btn_emil_register);
        btn_emil_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    requestEmil();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
        personal_reg_emil_imgcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestYanzhengma();
            }
        });

        btn_emil_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
    }

    private void submit() {

        inspectEmil();
        inspectPassword();
        inspectRegPassword();
        String imgcheck = ed_emil_imgcheck.getText().toString().trim();
        if (TextUtils.isEmpty(imgcheck)) {
            Toast.makeText(getContext(), "请输入图片验证码", Toast.LENGTH_SHORT).show();
            return;
        }
    }
    private void inspectEmil(){
        String emil = ed_emil.getText().toString().trim();

        if (TextUtils.isEmpty(emil)) {
            hint_emil.setText("邮箱不能为空");
            // shakeViewToNotifyUser(edit_email);
            return ;
        }
        Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher matcher = pattern.matcher(emil);
        if (matcher.matches()) {
            hint_emil.setText("");
            return ;
        } else {
            hint_emil.setText("邮箱格式不正确");
            return ;
        }
    }
    private void inspectPassword(){
        String emilcheck = ed_emilcheck.getText().toString().trim();


        if (TextUtils.isEmpty(emilcheck)) {
            hint_emilcheck.setText("密码不能为空");
            // shakeViewToNotifyUser(edit_password);
            return ;
        } else if (emilcheck.length() < 6 || emilcheck.length() > 16) {
            hint_emilcheck.setText("密码仅限6-16个字符");
            return ;
        } else {
            hint_emilcheck.setText("");
            return ;
        }
    }
    private void inspectRegPassword(){
        String eregmilcheck = ed_reg_emilcheck.getText().toString().trim();
        if (TextUtils.isEmpty(eregmilcheck)) {
            hint_reg_emilcheck.setText("确认密码不能为空");
            // shakeViewToNotifyUser(edit_again_password);
            return ;
        } else {
            hint_reg_emilcheck.setText("");
            String passwordsString = ed_emilcheck.getText().toString();
            if (!passwordsString.equals(eregmilcheck)) {
                hint_reg_emilcheck.setText("密码不一致");
                return ;
            } else {
                return ;
            }
        }
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
                        Glide.with(getActivity()).load(result).into(personal_reg_emil_imgcheck);
                    }
                });


            }
        });
    }
    private void requestEmil() throws UnsupportedEncodingException {
        String emailString = ed_emil.getText().toString().trim();
        String passwordString = ed_emilcheck.getText().toString();
        String from = "iPanda.Android";
        String url = "https://reg.cntv.cn/api/register.action" + "?mailAdd="
                + emailString + "&passWd=" + URLEncoder.encode(passwordString, "UTF-8")
                + "&verificationCode=" + ed_emil_imgcheck.getText().toString().trim() + "&addons="
                + URLEncoder.encode(from, "UTF-8");
        Request.Builder builder = new Request.Builder();
        builder.addHeader("Referer", URLEncoder.encode(from, "UTF-8"));
        builder.addHeader("User-Agent",
                URLEncoder.encode("CNTV_APP_CLIENT_CNTV_MOBILE", "UTF-8"));
        builder.addHeader("Cookie", jsessionid);
        Request build1 = builder.url(url).build();
        OkHttpClient build = new OkHttpClient.Builder().build();
        build.newCall(build1).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                try {
                    JSONObject errtype = new JSONObject(string);
                    if ("0".equals(errtype)) { // success
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getContext(), "注册成功", Toast.LENGTH_SHORT).show();
                            }
                        });

                    } else { // failure


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
