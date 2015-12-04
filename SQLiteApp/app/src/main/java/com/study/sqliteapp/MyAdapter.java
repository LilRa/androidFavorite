/*
ListView, GridView, Spinner는 대표적인 어댑터 뷰이고,
이 뷰들은 단지 껍데기에 불과하므로 실제 데이터를 연동해주는
객체는 중간의 BaseAdapter가 담당한다!!!!
 */
package com.study.sqliteapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter{
    ArrayList<Member> list=new ArrayList<Member>();
    LayoutInflater layoutInflater;
    Context context;
    MemberDAO dao;

    public MyAdapter(Context context) {
        this.context=context;
        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        /*
        레코드를 가져와서 ArrayList에 채우기!!!
         */
        dao=new MemberDAO(RegistActivity.db);
        list=(ArrayList)dao.selectAll();


        /*for(int i=0;i<list.size();i++) {
            list.get(i);
        }*/
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=null;
        if(convertView==null){
            view= layoutInflater.inflate(R.layout.item,parent,false);

        }else{
            view=convertView;
        }

        TextView edit_name=(TextView)view.findViewById(R.id.edit_name);
        TextView edit_gender=(TextView)view.findViewById(R.id.edit_gender);
        TextView edit_phone=(TextView)view.findViewById(R.id.edit_phone);
        Member dto=list.get(position);

        edit_name.setText(dto.getName());
        edit_gender.setText(dto.getGender());
        edit_phone.setText(dto.getPhone());


        return view;
    }
}
