package com.study.sqliteapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MemberListActivity extends Activity {
    MyAdapter myAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        listView=(ListView)findViewById(R.id.listView);

        myAdapter=new MyAdapter(this);

        listView.setAdapter(myAdapter);
    }

    public void btnClick(View view){
        this.finish();
    }
}
