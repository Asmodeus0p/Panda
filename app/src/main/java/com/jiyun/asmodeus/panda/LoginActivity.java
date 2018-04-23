package com.jiyun.asmodeus.panda;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jiyun.asmodeus.panda.model.SharedPreferencesUtils;
import com.jiyun.asmodeus.panda.model.entity.UserBean;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView Login_return;
    private TextView Logintext;
    private LinearLayout llweixinlogin;
    private LinearLayout llqqlogin;
    private LinearLayout llsinalogin;
    private EditText login_Username;
    private TextView hint_account;
    private EditText login_Password;
    private TextView hint_password;
    private TextView personal_login_forget_pwd;
    private TextView loding_btn;
    private LinearLayout login_in_layout;

    public final static String SEARCH_URL = "http://so.cntv.cn/service/panda.php";

    public final static String BASE_URL = "http://my.cntv.cn/intf/napi/api.php";

    public final static String LOGIN_URL = "https://reg.cntv.cn/login/login.action";

    public final static String VERFIICATION_URL = "http://reg.cntv.cn/simple/verificationCode.action";

    public final static String CNTV_WX_OAUTH_URL = "http://oauth.passport.cntv.cn/OauthClientWeixin/OAuthMobileWeixinServlet.do";

    public final static String REGCLINET_USER_URL = "http://cbox.regclientuser.cntv.cn";

    public final static String ARTICLE_URL = "http://api.cntv.cn/article/contentinfo";

    public static final String CLIENT = "ipanda_mobile";

    public static final String REFERER = "iPanda.Android";

    public static final String USER_AGENT = "CNTV_APP_CLIENT_CYNTV_MOBILE";
    private String nickname;
    private String mNickName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

    }


    private void initView() {
        Login_return = (ImageView) findViewById(R.id.Login_return);
        Logintext = (TextView) findViewById(R.id.Logintext);
        Login_return.setOnClickListener(this);
        Logintext.setOnClickListener(this);
        llweixinlogin = (LinearLayout) findViewById(R.id.llweixinlogin);
        llweixinlogin.setOnClickListener(this);
        llqqlogin = (LinearLayout) findViewById(R.id.llqqlogin);
        llqqlogin.setOnClickListener(this);
        llsinalogin = (LinearLayout) findViewById(R.id.llsinalogin);
        llsinalogin.setOnClickListener(this);
        login_Username = (EditText) findViewById(R.id.login_Username);
        login_Username.setOnClickListener(this);
        hint_account = (TextView) findViewById(R.id.hint_account);
        hint_account.setOnClickListener(this);
        login_Password = (EditText) findViewById(R.id.login_Password);
        login_Password.setOnClickListener(this);
        hint_password = (TextView) findViewById(R.id.hint_password);
        hint_password.setOnClickListener(this);
        personal_login_forget_pwd = (TextView) findViewById(R.id.personal_login_forget_pwd);
        personal_login_forget_pwd.setOnClickListener(this);
        loding_btn = (TextView) findViewById(R.id.loding_btn);
        loding_btn.setOnClickListener(this);
        login_in_layout = (LinearLayout) findViewById(R.id.login_in_layout);
        login_in_layout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Login_return:
                finish();
                break;
            case R.id.Logintext:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.loding_btn:
                goLogin();
                break;
        }
    }

    private void goLogin() {
        FormBody.Builder params = new FormBody.Builder();
        Request.Builder builder = new Request.Builder();
        String account = login_Username.getText().toString().trim();
        String password = login_Password.getText().toString().trim();
        builder.header("Referer", LOGIN_URL);
        builder.header("User-Agent", USER_AGENT);
        params.add("service", "client_transaction");
        params.add("username", account);
        params.add("password", password);
        params.add("from", "https://reg.cntv.cn/login/login.action");
        FormBody formBody = params.build();
        Request request = builder.url(LOGIN_URL).post(formBody).build();
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("LoginFragment", "e:" + e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Headers headers = response.headers();
                final String verifycode = headers.get("Set-Cookie");
                String string = response.body().string();
                UserBean userBean = new Gson().fromJson(string, UserBean.class);
                final String user_seq_id = userBean.getUser_seq_id();
                final String ticket = userBean.getTicket();
                final String errMsg = userBean.getErrMsg();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (errMsg.equals("成功")) {
                            Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                            getTicket(verifycode, user_seq_id, ticket);

                        }
                        if (errMsg.equals("密码错误，请重输。")) {
                            Toast.makeText(LoginActivity.this, "密码错误，请重输", Toast.LENGTH_SHORT).show();
                            hint_password.setText("密码错误，请重输");
                        }
                        if (errMsg.equals("输入格式有误，请使用邮箱或手机号登录")) {
                            Toast.makeText(LoginActivity.this, "输入格式有误，请使用邮箱或手机号登录", Toast.LENGTH_SHORT).show();
                            hint_account.setText("输入格式有误，请使用邮箱或手机号登录");
                        }
                        if (errMsg.equals("该帐号未注册")) {
                            Toast.makeText(LoginActivity.this, "该帐号未注册", Toast.LENGTH_SHORT).show();
                            hint_account.setText("该帐号未注册");
                        }
                    }
                });
            }
        });
    }

    private void getTicket(String verifycode, String user_seq_id, String ticket) {
        String client = "http://cbox_mobile.regclientuser.cntv.cn";
        String url = "http://my.cntv.cn/intf/napi/api.php" + "?client="
                + "cbox_mobile" + "&method=" + "user.getNickName"
                + "&userid=" + user_seq_id;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request.Builder builder = new Request.Builder();
        try {
            builder.addHeader("Referer", URLEncoder.encode(client, "UTF-8"))
                    .addHeader("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"))
                    .addHeader("Cookie", "verifycode=" + verifycode);
            Request request = builder.url(url).build();
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String string = response.body().string();
                    JSONObject jo = null;

                    try {
                        jo = new JSONObject(string);
                        if (jo.getString("code").equals("0")) {
                            if (jo.has("content")) {
                                JSONObject contentJSONObject = jo
                                        .getJSONObject("content");
                                if (contentJSONObject.has("nickname")) {
                                    nickname = contentJSONObject
                                            .getString("nickname");
                                    SharedPreferencesUtils.setParam(LoginActivity.this,"username",nickname);
                                    Log.e("12345",nickname);
                                    finish();
                                } else {
                                    mNickName = "default";
                                }
                            }
                        } else {
                            String codeErrorString = jo.getString("error");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}