package com.example.conversorbitcoin;

import static com.example.conversorbitcoin.R.id.webDolar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Tela2_1 extends AppCompatActivity {

    private WebView webDolar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2_1);

        webDolar = findViewById(R.id.webDolar);
        webDolar.setWebViewClient(new WebViewClient());
        String url = "https://www.infomoney.com.br/cotacoes/cripto/ativo/bitcoin-btc/";
        webDolar.loadUrl(url);
    }
}