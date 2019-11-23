package com.exmaple.casper.androidappdevelopment.ch6;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex61MainActivity extends Activity
{
    WebView webView;
    Button openWebBtn;
    EditText edit;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex61_main);
        openWebBtn = (Button)findViewById(R.id.button1);
        edit =(EditText)findViewById(R.id.editText1);
        openWebBtn.setOnClickListener(new mClick());
    }
    class mClick implements OnClickListener
    {
        public void onClick(View arg0)
        {
            String url = edit.getText().toString();
            webView = (WebView)findViewById(R.id.webView1);
            webView.loadUrl("http://" + url);
        }
    }
}
