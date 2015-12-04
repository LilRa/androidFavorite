/*
SQLite를 사용하기 위해서는 데이터베이스를 열거나, 버전을 관리해주는 객체인 SQLiteOpenHelper를
이용해야 한다!!!!
 */
package com.study.sqliteapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyOpenHelper extends SQLiteOpenHelper {
    String TAG;
    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        TAG=this.getClass().getName();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder sql=new StringBuilder();
        sql.append("create table member(");
        sql.append("member_id integer primary key autoincrement");
        sql.append(",name varchar(20)");
        sql.append(",gender varchar(4)");
        sql.append(",phone varchar(13)");
        sql.append(")");

        db.execSQL(sql.toString());
        Log.d(TAG,"처음보는 db가 생성되었습니다. onCreate호촐");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*Log.d(TAG, "기존에 존재했던 DB를 버전업하셨네요!");

        StringBuilder sql=new StringBuilder();
        sql.append("create table test(");
        sql.append(",name varchar(20)");
        sql.append(")");
        db.execSQL(sql.toString());*/
    }
}