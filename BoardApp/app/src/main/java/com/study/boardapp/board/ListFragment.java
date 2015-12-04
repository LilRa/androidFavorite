package com.study.boardapp.board;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.study.boardapp.MainActivity;
import com.study.boardapp.R;

public class ListFragment extends Fragment implements View.OnClickListener{

    ListView listView;
    ItemAdapter itemAdapter;
    Button bt_regist;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.listfragment_layout, container, false);

        listView = (ListView)view.findViewById(R.id.listView);
        bt_regist=(Button)view.findViewById(R.id.bt_regist);
        bt_regist.setOnClickListener(this);

        itemAdapter = new ItemAdapter(getContext());
        listView.setAdapter(itemAdapter);

        return view;
    }

    public void reload(){
        itemAdapter.dataManager.connectServer();
    }


    public void onClick(View v) {
        /*글쓰기 액티비티 호출*/
        Intent intent=new Intent(getContext() , WriteActivity.class);
        MainActivity mainActivity=(MainActivity)this.getContext();
        mainActivity.startActivityForResult(intent,1);
    }
}
