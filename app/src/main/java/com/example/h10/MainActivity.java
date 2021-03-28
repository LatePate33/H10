package com.example.h10;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView web;
    EditText searchbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.webbi);
        searchbar = findViewById(R.id.searchbar);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
    }

    public void search(View v){
        if (searchbar.getText().toString().equals("index.html")) {
            web.loadUrl("file:///android_asset/index.html");
        } else {
            String result = "http://";
            web.loadUrl(result + searchbar.getText());
        }
    }
    public void refresh(View v){
        web.loadUrl(web.getUrl());
    }

    public void s(View v){
        web.evaluateJavascript("javascript:shoutOut()", null);
    }

    public void i(View v){
        web.evaluateJavascript("javascript:initialize()", null);
    }

    public void forward(View v) {
        web.goForward();
    }

    public void backward(View v) {
        web.goBack();
    }
}