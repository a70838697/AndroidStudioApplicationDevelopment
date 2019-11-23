package com.exmaple.casper.androidappdevelopment.ch8;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.exmaple.casper.androidappdevelopment.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Ex87MainActivity extends AppCompatActivity {
    TextView txt;
    Button volleyBtn;
    ListView listdata;
    Datainfo datainfo=new Datainfo();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex87_main);
        volleyBtn=(Button)findViewById(R.id.button);
        txt = (TextView) findViewById(R.id.textView);
        listdata = (ListView)findViewById(R.id.listView);
        getServerData();
        volleyBtn.setOnClickListener(new mClick());
    }

    public class Datainfo
    {
        private String sid;    //序号
        private String name;   //姓名
        private String email;  //邮箱
        public void setSid(String sid){this.sid = sid;}
        public void setName(String name){this.name = name;}
        public void setEmail(String email){this.email = email;}
        public String getName(){return name;}
        public String getSid(){return sid;}
        public String getEmail(){return email;}
    }

    class mClick implements View.OnClickListener
    {
        String[] list={"","",""};
        @Override
        public void onClick(View v) {
            list[0] = "序号：" + datainfo.getSid();
            list[1] = "姓名：" + datainfo.getName();
            list[2] = "邮箱：" + datainfo.getEmail();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    Ex87MainActivity.this,
                    android.R.layout.simple_list_item_1,
                    list);
            listdata.setAdapter(adapter);
        }   //onClick()_end
    }  //class mClick_end

    public  void  getServerData(){
        String jsonURL = "http://file.nidama.net/class/mobile_develop/cspapp/conn_testdb1.php";//不能用localhost
        try {
            RequestQueue mQueue = Volley.newRequestQueue(Ex87MainActivity.this);
            StringRequest stringRequest = new StringRequest(
                    jsonURL,//第一个参数，请求的网址
                    new Response.Listener<String>() { //第二个参数，响应正确时的处理
                        @Override
                        public void onResponse(String response) {
                            if(response != null){
                                try {
                                    JSONArray jsonArray = new JSONArray(response);
                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        JSONObject jsonData = jsonArray.getJSONObject(i);
                                        String sid =""+ jsonData.getInt("sid");
                                        String sname = (String)jsonData.get("name");
                                        String semail = (String)jsonData.get("email");
                                        datainfo.setSid(sid);
                                        datainfo.setName(sname);
                                        datainfo.setEmail(semail);
                                    }
                                } catch (JSONException e) {
                                    txt.setText("list错误");
                                    Log.e("json错误", e.getMessage(), e);
                                }
                            }
                        }
                    },
                    new Response.ErrorListener() {     //第三个参数，错误时反馈信息
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("TAG错误", error.getMessage(), error);
                        }
                    });  //StringRequest()__end
            mQueue.add(stringRequest);
        }catch (Exception e){  }
    } //getServerData()__end
} //class MainActivity__end
