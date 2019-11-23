package com.exmaple.casper.androidappdevelopment.ch8;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.exmaple.casper.androidappdevelopment.R;

public class Ex82MainActivity extends Activity
{
    static EditText mEditText01;
    static EditText mEditText02;
    static EditText mEditText03;
    static EditText mEditText04;
    Cursor cursor;
    Button createBtn, openBtn, upBtn, downBtn;
    Button addBtn, updateBtn, deleteBtn, closeBtn;
    SQLiteDatabase db;
    Ex82DbConnection helper;
    public int id_this;
    Bundle savedInstanceState;
    //定义数据库名称及结构
    static String TABLE_NAME = "Users";          //数据表名
    static String ID = "_id";                    //ID
    static String USER_NAME = "user_name";       //用户名
    static String ADDRESS = "address";           //地址
    static String TELEPHONE = "telephone";       //联系电话
    static String MAIL_ADDRESS = "mail_address"; //电子邮箱
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex82_main);
        mEditText01 = (EditText)findViewById(R.id.EditText01);
        mEditText02 = (EditText)findViewById(R.id.EditText02);
        mEditText03 = (EditText)findViewById(R.id.EditText03);
        mEditText04 = (EditText)findViewById(R.id.EditText04);
        createBtn = (Button)findViewById(R.id.createDatabase1);
        createBtn.setOnClickListener(new ClickEvent());
        openBtn = (Button)findViewById(R.id.openDatabase1);
        openBtn.setOnClickListener(new ClickEvent());
        upBtn=(Button)findViewById(R.id.up1);
        upBtn.setOnClickListener(new ClickEvent());
        downBtn=(Button)findViewById(R.id.down1);
        downBtn.setOnClickListener(new ClickEvent());
        addBtn = (Button)findViewById(R.id.add1);
        addBtn.setOnClickListener(new ClickEvent());
        updateBtn = (Button)findViewById(R.id.update1);
        updateBtn.setOnClickListener(new ClickEvent());
        deleteBtn = (Button)findViewById(R.id.delete1);
        deleteBtn.setOnClickListener(new ClickEvent());
        closeBtn = (Button)findViewById(R.id.clear1);
        closeBtn.setOnClickListener(new ClickEvent());
        helper = new Ex82DbConnection(Ex82MainActivity.this);
    }
    class ClickEvent implements OnClickListener
    {
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.createDatabase1:
                    SQLiteDatabase db = helper.getWritableDatabase();
                    break;
                case R.id.openDatabase1:
                    db = openOrCreateDatabase("PhoneBook.db",
                            Context.MODE_PRIVATE, null) ;
                    cursor = db.query("Users",
                            null , null, null, null, null, null);
                    cursor.moveToNext();
                    upBtn.setClickable(true);
                    downBtn.setClickable(true);
                    deleteBtn.setClickable(true);
                    updateBtn.setClickable(true);
                    break;
                case  R.id.up1:
                    if(!cursor.isFirst())
                        cursor.moveToPrevious();
                    datashow();
                    break;
                case R.id.down1:
                    if(!cursor.isLast())
                        cursor.moveToNext();
                    datashow();
                    break; //
                case R.id.add1:
                    add();
                    onCreate(savedInstanceState);
                    break;
                case R.id.update1:
                    update();
                    onCreate(savedInstanceState);
                    break;
                case  R.id.delete1:
                    delete();
                    onCreate(savedInstanceState);
                    break;
                case R.id.clear1:
                    cursor.close();
                    mEditText01.setText("数据库已关闭");
                    mEditText02.setText("数据库已关闭");
                    mEditText03.setText("数据库已关闭");
                    mEditText04.setText("数据库已关闭");
                    upBtn.setClickable(false);
                    downBtn.setClickable(false);
                    deleteBtn.setClickable(false);
                    updateBtn.setClickable(false);
                    break;
            }
        }
    }
    /* 显示记录 */
    void datashow()
    {
        id_this = Integer.parseInt(cursor.getString(0));
        String user_name_this = cursor.getString(1);
        String telephone_this = cursor.getString(2);
        String address_this = cursor.getString(3);
        String mail_address_this = cursor.getString(4);
        mEditText01.setText(user_name_this);
        mEditText02.setText(telephone_this);
        mEditText03.setText(address_this);
        mEditText04.setText(mail_address_this);
    }
    /* 添加记录 */
    void add()
    {
        ContentValues values1 = new ContentValues();
        values1.put(USER_NAME, Ex82MainActivity.mEditText01.getText().toString());
        values1.put(TELEPHONE, Ex82MainActivity.mEditText02.getText().toString());
        values1.put(ADDRESS, Ex82MainActivity.mEditText03.getText().toString());
        values1.put(MAIL_ADDRESS,
                Ex82MainActivity.mEditText04.getText().toString());
        SQLiteDatabase db2 = helper.getWritableDatabase();
        db2.insert(TABLE_NAME, null, values1);
        db2.close();
    }
    /* 修改记录 */
    void update()
    {
        ContentValues values = new ContentValues();
        values.put(USER_NAME, Ex82MainActivity.mEditText01.getText().toString());
        values.put(TELEPHONE, Ex82MainActivity.mEditText02.getText().toString());
        values.put(ADDRESS, Ex82MainActivity.mEditText03.getText().toString());
        values.put(MAIL_ADDRESS,
                Ex82MainActivity.mEditText04.getText().toString());
        String where1 = ID + " = " + id_this;
        SQLiteDatabase db1 = helper.getWritableDatabase();
        db1.update(TABLE_NAME, values, where1 ,null);
        db1.close();
    }
    /*  删除记录 */
    void delete()
    {
        String where = ID + " = " + id_this;
        SQLiteDatabase db1 = helper.getWritableDatabase();
        db1.delete(TABLE_NAME, where ,null);
        db1.close();
    }
}

