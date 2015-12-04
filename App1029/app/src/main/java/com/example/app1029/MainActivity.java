package com.example.app1029;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    String TAG;
    String path;
    String selectedName; /*현재 재생할 파일명*/
    ListView listView;
    ArrayAdapter<String> adapter;
    TextView txt_title;
    MediaPlayer mediaPlayer;
    MediaRecorder mediaRecorder;
    EditText edit_filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG=this.getClass().getName();
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listView);
        txt_title=(TextView)findViewById(R.id.txt_title);
        edit_filename=(EditText)findViewById(R.id.edit_filename);
        loadFile();
        
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);/*리스너와 연결*/
        loadFile();
    }
    /*재생 대상이 되는 파일목록 가져오기
    * 로컬 내장 SD카드에서 ..*/
    public void  loadFile(){
        path=Environment.getExternalStorageDirectory().getAbsolutePath()+"/MyRecord";
        Log.d(TAG, "MyRecord 경로는" + path);

        File file=new File(path);
        File[] dir=file.listFiles();
        ArrayList<String> data= new ArrayList<String>();
        for(int i=0;i<dir.length;i++){
            Log.d(TAG,dir[i].getName());
            data.add(dir[i].getName()); /*목록채우기!!*/
        }
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
    }
    /*선택한 음원파일 재생하기*/
    public void play(){
        if(mediaPlayer==null) {
            mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.setDataSource(path + "/" + selectedName);
                mediaPlayer.prepare();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(mediaPlayer.isPlaying()){ /*플레이중이라면, 잠시 멈추고*/
            mediaPlayer.pause();
        }else{  /*다시 플레이...*/
            mediaPlayer.start();
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView item=(TextView)view;
        selectedName=item.getText().toString();
        txt_title.setText(selectedName);
    }
    public void record(){
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
        mediaRecorder.setOutputFile(path + "/" + edit_filename.getText().toString());
        try {
            mediaRecorder.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaRecorder.start(); /*녹음 시작!!*/
    }
    public void recordStop(){
        if(mediaRecorder !=null) {
            mediaRecorder.stop();
            mediaRecorder.release();
        }
        loadFile();
        listView.invalidate();
    }
    public void btnClick(View view){
        if(view.getId()==R.id.bt_record){
            record();
        }
        if(view.getId()==R.id.bt_stop){
            recordStop();
        }
        if(view.getId()==R.id.bt_play){
            play();

        }
    }
}
