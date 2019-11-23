package com.exmaple.casper.androidappdevelopment.ch2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SlidingDrawer;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex218MainActivity extends AppCompatActivity {
    //声明SlidingDrawer
    private SlidingDrawer mDrawer;
    private ImageView mImageView;
    private ListView listView;
    private String data[] = {"使命召唤","植物大战僵尸","愤怒的小鸟"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex218_main);

        //获得SlidingDrawer
        mDrawer = (SlidingDrawer) findViewById(R.id.slidingdraw);
        mImageView = (ImageView) findViewById(R.id.handle);

        //获取ListView并填充内容
        listView = (ListView) findViewById(R.id.content);
        listView.setAdapter(new ArrayAdapter<String>(
                Ex218MainActivity.this,
                android.R.layout.simple_list_item_1,
                data));

        //监听打开抽屉事件
        mDrawer.setOnDrawerOpenListener(new mOpenListener());

        //监听关闭抽屉事件
        mDrawer.setOnDrawerCloseListener(new mCloseListener());

    }

    //监听打开抽屉事件
    class mOpenListener implements SlidingDrawer.OnDrawerOpenListener{
        @Override
        public void onDrawerOpened() {
            mImageView.setImageResource(R.drawable.down);
        }
    }
    //监听关闭抽屉事件
    class mCloseListener implements  SlidingDrawer.OnDrawerCloseListener{
        @Override
        public void onDrawerClosed() {
            mImageView.setImageResource(R.drawable.up);
        }
    }


}
