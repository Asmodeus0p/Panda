package com.jiyun.asmodeus.panda.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jiyun.asmodeus.panda.R;
import com.jiyun.asmodeus.panda.model.SharedPreferencesUtils;

public class SignoutActivity extends Activity implements View.OnClickListener {

    private Button SignoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signout);
        initView();
    }

    private void initView() {
        SignoutButton = (Button) findViewById(R.id.SignoutButton);

        SignoutButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.SignoutButton:
                SharedPreferencesUtils.clear(this);
                break;
        }
    }
}
