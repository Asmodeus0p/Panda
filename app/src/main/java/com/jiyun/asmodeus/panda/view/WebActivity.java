package com.jiyun.asmodeus.panda.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
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
        WebSettings webSettings = webview.getSettings();
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);//把html中的内容放大webview等宽的一列中
        webSettings.setJavaScriptEnabled(true);//支持js
        webSettings.setBuiltInZoomControls(true); // 显示放大缩小
        webSettings.setSupportZoom(true); // 可以缩放
        webview.loadUrl(url);
    }
}
