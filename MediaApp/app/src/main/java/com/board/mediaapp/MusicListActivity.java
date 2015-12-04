package com.board.mediaapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class MusicListActivity extends Activity{
    ListView listView;
    ArrayList<String> list_music=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        listView=(ListView)findViewById(R.id.listview);

        File file=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Music");

        File dir[]=file.listFiles();
        for(int i=0;i<dir.length;i++){
            if(dir[i].isFile()){        //디렉토리는 제외시키고 파일만!
                list_music.add(dir[i].getName());
            }
        }

        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,list_music);
        listView.setAdapter(adapter);

        //리스트뷰와 리스너와의 연결!
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent();
                intent.putExtra("MusicName", list_music.get(position));
                setResult(Activity.RESULT_OK,intent);  // 안드로이드 내에 이미 있는 긍정소스!
                finish();
            }
        });
    }
}

