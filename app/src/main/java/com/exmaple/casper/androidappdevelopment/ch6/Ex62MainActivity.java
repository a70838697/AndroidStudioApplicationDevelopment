package com.exmaple.casper.androidappdevelopment.ch6;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import android.app.Activity;
import android.webkit.JavascriptInterface;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex62MainActivity extends Activity
{
    WebView webView;
    Handler handler = new Handler();
    MWebChromeClient mWebChromeClient;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex62_main);
        webView = (WebView) findViewById(R.id.webView1);
        WebSettings webSettings = webView.getSettings();
        webSettings.setAllowFileAccess(true);// 设置允许访问文件数据
        webSettings.setJavaScriptEnabled(true);// 设置支持JavaScript脚本
        webSettings.setBuiltInZoomControls(true);// 设置支持缩放
        webSettings.setDefaultFontSize (24);
        MObject mObject = new MObject();
        webView.addJavascriptInterface(mObject, "test");
        mWebChromeClient = new MWebChromeClient();
        webView.setWebChromeClient(mWebChromeClient);
        webView.loadUrl("file:///android_asset/test62.html");
    }
    class MObject extends Object{
        @JavascriptInterface
        public void  android_show()
        {
            handler.post(new Runnable()
            {
                public void run()
                {
                    System.out.println("提示：调用了多线程的run()方法!!");
                    webView.loadUrl("javascript: show_alert()");
                }
            });
        }
    }
    class MWebChromeClient extends WebChromeClient
    {
        @Override
        public boolean onJsAlert(WebView view,
                                 String url, String message, JsResult result)
        {
            Toast.makeText(getApplicationContext(), message,
                    Toast.LENGTH_LONG).show();
            return true;
        }
    }
}
