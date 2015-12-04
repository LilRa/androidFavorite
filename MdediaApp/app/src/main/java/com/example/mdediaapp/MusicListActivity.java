package com.example.mdediaapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhmfrd on 2015-10-27.
 */
public class MusicListActivity extends Activity implements AdapterView.OnItemClickListener{
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> itemList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);
        listView =(ListView)findViewById(R.id.listView);
        /*스마트폰 sd card 경로의 자원을 가져오기*/
        String path=Environment.getExternalStorageDirectory().getAbsolutePath()+"/Music";
        File file=new File(path);

        File[] dir=file.listFiles();
        for(int i=0;i<dir.length;i++){
            if(dir[i].isFile()){ //디렉토리는 제외하고 파일만 조건을 검..
                itemList.add(dir[i].getName());
            }
        }

        adapter=new ArrayAdapter<String>(this, android.support.v7.appcompat.R.layout.simple_list_item,itemList);
        listView.setAdapter(adapter);

        /*리스트뷰와 리스너와의 연결*/
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.putExtra("musicName",itemList.get(position));
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
}
