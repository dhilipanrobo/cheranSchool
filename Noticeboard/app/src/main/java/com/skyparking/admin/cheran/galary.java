package com.skyparking.admin.cheran;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class galary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_galary );
        WebView browser = ((WebView ) findViewById(R.id.webView));

        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setGeolocationEnabled(true);
        browser.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        browser.getSettings().setBuiltInZoomControls(true);
        browser.getSettings().setDomStorageEnabled(true);

        browser.setWebChromeClient(new WebChromeClient () {
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
            }
        });

        browser.loadUrl("https://welleservices.com/cheran/gallery/");

    }
}
