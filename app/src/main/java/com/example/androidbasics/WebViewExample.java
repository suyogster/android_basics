package com.example.androidbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_example);

        WebView webViewExample = findViewById(R.id.webViewExample);
        webViewExample.loadUrl("https://google.com");
        webViewExample.setWebViewClient(new WebViewClient());
        webViewExample.getSettings().setJavaScriptEnabled(true);
    }
}