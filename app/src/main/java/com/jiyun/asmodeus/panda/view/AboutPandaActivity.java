package com.jiyun.asmodeus.panda.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.asmodeus.panda.R;

public class AboutPandaActivity extends AppCompatActivity {

    private ImageView AboutPanda_return;
    private TextView about_version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_panda);
        initView();
    }

    private void initView() {
        AboutPanda_return = (ImageView) findViewById(R.id.AboutPanda_return);
        about_version = (TextView) findViewById(R.id.about_version);
        AboutPanda_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
