package com.study.sqliteapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegistActivity extends Activity{
    MyOpenHelper myOpenHelper;
    MemberDAO dao;
    EditText txt_name,txt_gender,txt_phone;
    String name,gender,phone;
    static SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regist_layout);

        txt_name=(EditText)findViewById(R.id.txt_name);
        txt_gender=(EditText)findViewById(R.id.txt_gender);
        txt_phone=(EditText)findViewById(R.id.txt_phone);


        myOpenHelper=new MyOpenHelper(this,"db1022.sqlite",null,1);
        db=myOpenHelper.getWritableDatabase();
        dao=new MemberDAO(db);

    }

    public void regist(){
        /*
        레코드 한건 등록!!
         */
        name=txt_name.getText().toString();
        gender=txt_gender.getText().toString();
        phone=txt_phone.getText().toString();

        Member dto=new Member();
        dto.setName(name);
        dto.setGender(gender);
        dto.setPhone(phone);


        int result=dao.insert(dto);

        String msg;
        if(result!=0){
            msg="등록성공";
        }else{
            msg="등록실패";
        }

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("등록 확인 대화 상자");
        builder.setMessage(msg);
        builder.setCancelable(true);
        builder.setPositiveButton("확인", null);

        AlertDialog dialog=builder.create();
        dialog.show();
    }

    public void getList(){
        /*
        조회용 액티비티 띄우기!!
         */
        Intent intent=new Intent(this,MemberListActivity.class);
        this.startActivity(intent);

    }

    public void btnClick(View view){
        if(view.getId()==R.id.bt_regist){
            regist();
        }else if(view.getId()==R.id.bt_list){
            getList();
        }
    }
}
