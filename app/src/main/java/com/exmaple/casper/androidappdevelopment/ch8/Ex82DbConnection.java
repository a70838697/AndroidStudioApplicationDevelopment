package com.exmaple.casper.androidappdevelopment.ch8;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Ex82DbConnection extends SQLiteOpenHelper {
    static final String Database_name = "PhoneBook.db";
    static final int Database_Version = 1;
    SQLiteDatabase db;
    public int id_this;
    Cursor cursor;
    //定义数据库名称及结构
    static String TABLE_NAME = "Users";          //数据表名
    static String ID = "_id";                    //ID
    static String USER_NAME = "user_name";       //用户名
    static String ADDRESS = "address";           //地址
    static String TELEPHONE = "telephone";       //联系电话
    static String MAIL_ADDRESS = "mail_address"; //电子邮箱

    Ex82DbConnection(Context ctx) {
        super(ctx, Database_name, null, Database_Version);
    }

    public void onCreate(SQLiteDatabase database) {
        String sql = "CREATE TABLE " + TABLE_NAME + " ("
                + ID + " INTEGER primary key autoincrement, "
                + USER_NAME + " text not null, "
                + TELEPHONE + " text not null, "
                + ADDRESS + " text not null, "
                + MAIL_ADDRESS + " text not null " + ");";
        database.execSQL(sql);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
