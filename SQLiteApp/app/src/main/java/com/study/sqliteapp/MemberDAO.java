package com.study.sqliteapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    SQLiteDatabase db;

    public MemberDAO(SQLiteDatabase db) {
        this.db = db;
    }

    /*
        1건 넣기
         */
    public int insert(Member dto){
        int result=0;
        String sql="insert into member(name,gender,phone)";
        sql+=" values(?,?,?)";
        try{
            db.execSQL(sql,new String[]{dto.getName(),dto.getGender(),dto.getPhone()});
            result=1;
        }catch (SQLiteException e){
            e.printStackTrace();
            result=0;
        }
        return result;
    }

    /*
    모든 레코드 가져오기!
     */
    public List selectAll(){
        ArrayList<Member> list=new ArrayList<Member>();
        String sql="select * from member order by member_id asc";
        Cursor cursor=db.rawQuery(sql, null);

        while(cursor.moveToNext()){
            Member dto=new Member();
            dto.setMember_id(cursor.getInt(0));
            dto.setName(cursor.getString(1));
            dto.setGender(cursor.getString(2));
            dto.setPhone(cursor.getString(3));
            list.add(dto);
        }
        cursor.close();
        return list;
    }
}
