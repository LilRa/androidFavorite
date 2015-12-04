package com.study.photoapp;

import android.app.Activity;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * Created by student on 2015-11-17.
 */
public class AlbumActivity extends Activity implements AdapterView.OnItemClickListener{
    String TAG;
    GridView gridView;
    AlbumAdapter albumAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_layout);
        gridView=(GridView)findViewById(R.id.gridView);
        albumAdapter = new AlbumAdapter(this);
        gridView.setAdapter(albumAdapter); /*연결!!*/
        gridView.setOnItemClickListener(this);  /*리스너와 연결*/
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG, position+"번째 나 눌렀어?");
    }

    public void btnClick(View view){
        finish();
    }
}
