package com.apps.kondratenko.platizhka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class OnlinePay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_pay);
        WebView webView = new WebView(this);
        setContentView(webView);
        webView.loadUrl("https://easypay.ua/ua/utility");
    }

    }

