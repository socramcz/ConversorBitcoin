package com.example.conversorbitcoin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Tela2_2 extends AppCompatActivity {

    private WebView webReal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2_2);

        webReal = findViewById(R.id.webReal);
        webReal.setWebViewClient(new WebViewClient());
        String url = "https://www.coinbase.com/pt/converter/btc/brl";
        webReal.loadUrl(url);
    }
}