package com.jiyun.asmodeus.panda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.asmodeus.panda.model.SharedPreferencesUtils;
import com.jiyun.asmodeus.panda.view.SignoutActivity;
import com.jiyun.asmodeus.panda.view.UpSetActivity;
import com.jiyun.asmodeus.panda.view.fragment.HistoryActivity;

public class PersonalCenterActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView returnimg;
    private RelativeLayout PersonalCenter_login;
    private RelativeLayout PersonalCenter_guanhistory;
    private RelativeLayout PersonalCenter_mycollection;
    private RelativeLayout PersonalCenter_Setup;
    private TextView PersonalCenter_nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_center);
        initView();

    }

    private void initView() {
        returnimg = (ImageView) findViewById(R.id.returnimg);
        PersonalCenter_login = (RelativeLayout) findViewById(R.id.PersonalCenter_login);
        PersonalCenter_guanhistory = (RelativeLayout) findViewById(R.id.PersonalCenter_guanhistory);
        PersonalCenter_mycollection = (RelativeLayout) findViewById(R.id.PersonalCenter_mycollection);
        PersonalCenter_Setup = (RelativeLayout) findViewById(R.id.PersonalCenter_Setup);
        returnimg.setOnClickListener(this);

        PersonalCenter_guanhistory.setOnClickListener(this);
        PersonalCenter_mycollection.setOnClickListener(this);
        PersonalCenter_Setup.setOnClickListener(this);
        PersonalCenter_nickname = (TextView) findViewById(R.id.PersonalCenter_nickname);
        String username = (String) SharedPreferencesUtils.getParam(this, "username", "请登陆");
        if (username != null) {
            PersonalCenter_nickname.setText(username);
        }
         PersonalCenter_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(PersonalCenterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.returnimg:
                finish();
                break;
            case R.id.PersonalCenter_guanhistory:
                startActivity(new Intent(this, HistoryActivity.class));
                break;
            case R.id.PersonalCenter_mycollection:

                break;
            case R.id.PersonalCenter_Setup:
                startActivity(new Intent(this, UpSetActivity.class));
                break;

        }
    }


}
