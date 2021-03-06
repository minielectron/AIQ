package com.androidcodeshop.aiq.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.androidcodeshop.aiq.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewActivity extends AppCompatActivity {
    private static final String DEFAULT_URL = "https://androidprodev.com/about-me/";
    @BindView(R.id.web_view)
    WebView webView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_text)
    TextView toolbarText;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);
        String url = DEFAULT_URL;
        final Intent intent = getIntent();
        final Uri data = intent.getData();
        if (null != data) {
            url = data.toString();
        }
        setSupportActionBar(toolbar);
        toolbarText.setText(url);
        // AppUtils.makeActivityFullScreen(getWindow());
        // check the internet connection

        if (isConnected()) {
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(final WebView view, final String request) {
                    view.loadUrl(request);
                    toolbarText.setText(request);
                    return super.shouldOverrideUrlLoading(view, request);
                }

                @Override
                public void onPageFinished(final WebView view, final String url) {
                    super.onPageFinished(view, url);
                    progressBar.setVisibility(View.INVISIBLE);
                }

                @Override
                public void onPageStarted(final WebView view, final String url, final Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                    progressBar.setVisibility(View.VISIBLE);
                }
            });
            webView.getSettings().setJavaScriptEnabled(true);
            if (Build.VERSION_CODES.O <= Build.VERSION.SDK_INT) {
                webView.getSettings().setSafeBrowsingEnabled(true);
            }
            webView.getSettings().setAllowContentAccess(true);
            webView.getSettings().setAppCacheEnabled(true);
            webView.getSettings().setSupportMultipleWindows(false);
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.loadUrl(url);
        } else {
            webView.loadData("<html>" +
                    "<body><b> \n\n Internet connection is not available</b></body>" +
                    "</html>", "text/html; charset-UTF-8", null);
            progressBar.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public boolean onKeyDown(final int keyCode, final KeyEvent event) {
        if (KeyEvent.ACTION_DOWN == event.getAction()) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webView.canGoBack()) {
                        webView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    private boolean isConnected() {
        final ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return null != activeNetworkInfo && activeNetworkInfo.isConnected();
    }
}
