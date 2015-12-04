package com.example.study.app1014;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    GridAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*그리드뷰와 어댑터와의 연결*/
        gridView = (GridView)findViewById(R.id.gridView);
        adapter = new GridAdapter(this);
        gridView.setAdapter(adapter);
    }
}
