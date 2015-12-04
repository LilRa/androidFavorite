package com.study.boardapp.board;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter{
    Context context;
    ArrayList<Board> list = new ArrayList<Board>();
    DataManager dataManager;

    public ItemAdapter(Context context) {
        this.context=context;

        init();
    }

    public void init(){
        dataManager = new DataManager(this);
        dataManager.connectServer();
    }

    public int getCount() {
        return list.size();
    }
    public Object getItem(int position) {
        return null;
    }
    public long getItemId(int position) {
        return 0;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=null;

        if(convertView == null){
            view = new BoardItem(context);
        }else{
            view=(BoardItem)convertView;
        }

        Board dto=list.get(position);
        BoardItem boardItem=(BoardItem)view;

        boardItem.setTitle(dto.getTitle());
        boardItem.setWriter(dto.getWriter());
        boardItem.setRegdate(dto.getRegdate());

        return view;
    }

}
