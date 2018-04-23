package com.jiyun.asmodeus.panda.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.jiyun.asmodeus.panda.R;

public class WebActivity extends Activity {

    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initView();

    }

    private void initView() {
        webview = (WebView) findViewById(R.id.webview);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        webview.loadUrl(url);
    }
}
