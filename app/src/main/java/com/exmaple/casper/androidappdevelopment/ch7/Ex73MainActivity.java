package com.exmaple.casper.androidappdevelopment.ch7;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.exmaple.casper.androidappdevelopment.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Ex73MainActivity extends   AppCompatActivity {
    TextView txt;
    ListView  musicView;   //定义列表组件，用于显示音乐信息
    ArrayAdapter<String>  adapter;   //定义适配器
    Button  readBtn, playBtn, stopBtn;
    String[] list={"","",""};
    Ex73MusicInfo musicinfo = new Ex73MusicInfo();  //创建输入输出数据对象
    String musicUil="http://file.nidama.net/class/mobile_develop/cspapp/";
    MediaPlayer  mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex73_main);
        txt = (TextView)findViewById(R.id.textView2);
        musicView = (ListView)findViewById(R.id.listView);
        readBtn = (Button)findViewById(R.id.button);
        playBtn = (Button)findViewById(R.id.button2);
        stopBtn = (Button)findViewById(R.id.button3);
        getServerData();
        readBtn.setOnClickListener(new mread());
        playBtn.setOnClickListener(new mplay());
        stopBtn.setOnClickListener(new mstop());
    }

    class mread implements View.OnClickListener {
        public void onClick(View v) {
            list[0] = "音乐名称：" + musicinfo.getName();
            list[1] = "歌手：" + musicinfo.getSinger();
            list[2] = "音乐文件名：" + musicinfo.getMp3();
            adapter = new ArrayAdapter<String>(
                    Ex73MainActivity.this,
                    android.R.layout.simple_list_item_1,
                    list);
            musicView.setAdapter(adapter);
        }
    }
    class mplay implements View.OnClickListener{
        public void onClick(View v) {
            try {
                String path = musicUil + musicinfo.getMp3();
                txt.setText(path);
                mMediaPlayer = new MediaPlayer();
                mMediaPlayer.reset();
                mMediaPlayer.setDataSource(path);
                mMediaPlayer.prepare();
                mMediaPlayer.start();
            }catch (IOException e){    }
        }
    }
    class mstop implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (mMediaPlayer.isPlaying()){
                mMediaPlayer.stop();
                mMediaPlayer.reset();
                mMediaPlayer.release();
            }
        }
    }

    public  void  getServerData(){
        String jsonUrl = musicUil + "musicinfo1.json";
        RequestQueue mQueue = Volley.newRequestQueue(Ex73MainActivity.this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                jsonUrl,//第一个参数，请求的网址
                null, //第二个参数
                new Response.Listener<JSONObject>() { //第三个参数，响应正确时的处理
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String sname=new String(response.getString("name"));
                            String ssinger=new String(response.getString("singer"));
                            String smp3=new String(response.getString("mp3"));
                            musicinfo.setName(sname);
                            musicinfo.setSinger(ssinger);
                            musicinfo.setMp3(smp3);
                        }catch (JSONException e){  txt.setText("list错误");
                            Log.e("json错误", e.getMessage(), e);
                        }
                    }
                },
                new Response.ErrorListener() {     //第四个参数，错误时反馈信息
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {  Log.e("TAG错误", error.getMessage(), error); }
                } )

        {  //将volley默认的ISO-8859-1格式转换为utf-8格式
            @Override
            protected Response<JSONObject> parseNetworkResponse(
                    NetworkResponse response) {
                try {  //jsonObject要和前面的类型一致,此处都是JSONObject
                    JSONObject jsonObject = new JSONObject(
                            new String(response.data, "UTF-8"));
                    return Response.success(jsonObject,
                            HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    return Response.error(new ParseError(e));
                } catch (Exception je) {
                    return Response.error(new ParseError(je)) ;
                }
            }
        };
        mQueue.add(jsonObjectRequest);
    }
}
