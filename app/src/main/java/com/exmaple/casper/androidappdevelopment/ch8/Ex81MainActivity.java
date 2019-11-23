package com.exmaple.casper.androidappdevelopment.ch8;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex81MainActivity extends Activity
{
    Button creatBtn, deleteBtn;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex81_main);
        creatBtn=(Button)findViewById(R.id.creat1);
        creatBtn.setOnClickListener(new mClick());
        deleteBtn=(Button)findViewById(R.id.delete1);
        deleteBtn.setOnClickListener(new mClick());
    }

    class mClick implements OnClickListener
    {
        @Override
        public void onClick(View arg0)
        {
            if(arg0 == creatBtn)
            {
                DBCreate db =  new DBCreate();
            }
            else if(arg0 == deleteBtn)
            {
                deleteDatabase(DBCreate.Database_name);
            }
        }
    }

    class DBCreate
    {
        static final String Database_name = "PhoneBook.db";
        private DBCreate()
        {
            SQLiteDatabase db;
            String TABLE_NAME = "Users";          //数据表名
            String ID = "_id";                    //ID
            String USER_NAME = "user_name";       //用户名
            String ADDRESS = "address";           //地址
            String TELEPHONE = "telephone";       //联系电话
            String MAIL_ADDRESS = "mail_address"; //电子邮箱
            String DATABASE_CREATE =
                    "CREATE TABLE " + TABLE_NAME + " ("
                            + ID  + " INTEGER primary key autoincrement,"
                            + USER_NAME + " text not null, "
                            + TELEPHONE + " text not null, "
                            + ADDRESS + " text not null, "
                            + MAIL_ADDRESS + " text not null "+ ");";
            int mode = Context.MODE_PRIVATE;
            db = openOrCreateDatabase(Database_name, mode, null);
            db.execSQL(DATABASE_CREATE);
        }
    }
}

