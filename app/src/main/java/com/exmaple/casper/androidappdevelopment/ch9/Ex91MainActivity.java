package com.exmaple.casper.androidappdevelopment.ch9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;
import com.exmaple.casper.androidappdevelopment.R;

public class Ex91MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex91_main);

        MapView mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);// 此处必须重写onCreate()方法
        AMap aMap = mapView.getMap();
        // aMap.setTrafficEnabled(true);// 显示实时交通状况
        //地图模式可选类型：MAP_TYPE_NORMAL,MAP_TYPE_SATELLITE,MAP_TYPE_NIGHT
        aMap.setMapType(AMap.MAP_TYPE_NORMAL); //地图标准模式
    }
}

