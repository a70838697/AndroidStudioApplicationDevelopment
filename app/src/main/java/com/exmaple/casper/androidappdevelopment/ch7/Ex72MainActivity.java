package com.exmaple.casper.androidappdevelopment.ch7;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.exmaple.casper.androidappdevelopment.R;

import java.io.UnsupportedEncodingException;

public class Ex72MainActivity extends AppCompatActivity {
    Button volleyBtn;
    EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex72_main);
        volleyBtn=(Button)findViewById(R.id.button);
        txt = (EditText)findViewById(R.id.editText);
        volleyBtn.setOnClickListener(new mClick());
    }

    class mClick implements View.OnClickListener
    {
        String str;
        @Override
        public void onClick(View v) {
            if(v == volleyBtn){
                RequestQueue mQueue = Volley.newRequestQueue(Ex72MainActivity.this);
                StringRequest stringRequest = new StringRequest(
                        "http://file.nidama.net/class/mobile_develop/cspapp/jsonData.json",
                        new Response.Listener<String>() {  //volley的监听器,

                            @Override
                            public void onResponse(String response)
                            {  txt.setText(response); }// onResponse()方法获取接收到的数据值
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {  Log.e("TAG", error.getMessage(), error); }
                        }) {
                    @Override
                    protected Response<String> parseNetworkResponse(NetworkResponse response) {
                        try {
                            String jsonString = new String(response.data, "UTF-8");
                            return Response.success(jsonString,
                                    HttpHeaderParser.parseCacheHeaders(response));
                        } catch (UnsupportedEncodingException e) {
                            return Response.error(new ParseError(e));
                        } catch (Exception je) {
                            return Response.error(new ParseError(je));
                        }
                    }
                } ;
                mQueue.add(stringRequest);
            } // if_end
        }   //onClick()_end
    }  //class  mClick_end
}
