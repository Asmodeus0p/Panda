package com.jiyun.asmodeus.panda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
        PersonalCenter_login.setOnClickListener(this);
        PersonalCenter_guanhistory.setOnClickListener(this);
        PersonalCenter_mycollection.setOnClickListener(this);
        PersonalCenter_Setup.setOnClickListener(this);
        PersonalCenter_nickname = (TextView) findViewById(R.id.PersonalCenter_nickname);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.returnimg:
                finish();
                break;
            case R.id.PersonalCenter_login:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivityForResult(intent,100);

                break;
            case R.id.PersonalCenter_guanhistory:
                break;
            case R.id.PersonalCenter_mycollection:
                break;
            case R.id.PersonalCenter_Setup:
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==100&&resultCode==200) {
            String username = data.getStringExtra("username");
            PersonalCenter_nickname.setText(username);
        }
    }
}
