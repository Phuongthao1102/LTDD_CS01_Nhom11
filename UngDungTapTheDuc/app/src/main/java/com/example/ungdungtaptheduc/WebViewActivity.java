package com.example.ungdungtaptheduc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);
        webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.facebook.com/duythien.ngotran");
    }
}