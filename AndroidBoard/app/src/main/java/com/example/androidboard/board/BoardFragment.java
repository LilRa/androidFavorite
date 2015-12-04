package com.example.androidboard.board;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.androidboard.R;

import java.util.List;

/**
 * ListView와 어댑터 와의 연결
 */
public class BoardFragment extends android.support.v4.app.Fragment{
    ListView listView;
    BoardItemAdapter boardItemAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_board,container,false);
        listView=(ListView)view.findViewById(R.id.listView);
        boardItemAdapter=new BoardItemAdapter(this.getContext());
        listView.setAdapter(boardItemAdapter);

        return view;
    }
}
