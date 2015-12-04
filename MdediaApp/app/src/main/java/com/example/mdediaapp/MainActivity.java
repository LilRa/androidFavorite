package com.example.mdediaapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;

import static com.example.mdediaapp.R.id.bt_list;

public class MainActivity extends AppCompatActivity {

    /*   MediaPlayer : 미디어 파일 재생을 담당(음원, 영상)
    *    MediaRecord : 미디어 파일 녹화를 담당(음원, 영상)
    */
    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer2;
    String TAG;
    public static final int REQUEST_CODE=1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = this.getClass().getName();
        setContentView(R.layout.activity_main);
    }

    public void play(){
        if (mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(this, R.raw.meyou);
        }
        mediaPlayer.start();
    }
    public void pause(){
        mediaPlayer.pause();
    }
    public void stop(){
        mediaPlayer.stop();
        mediaPlayer=null;
    }

// sd 카드의 음원 데이터로 음원재생처리하기!!!
    public void play2(){
        mediaPlayer2 = new MediaPlayer();
        //mediaPlayer2.setDataSource();

        /* 자바언어에서는 디렉토리를 표현하는 객체가 따로 없다!!!
        *   디렉토리건, 파일이건 모두 File 클래스가 담당!!
        * */
        File file = Environment.getExternalStorageDirectory();
        Log.d(TAG, "나의 SD카드의 경로는" + file.getAbsolutePath());
        File musicInfo = new File(file.getAbsolutePath()+"Music");

        Log.d(TAG, "Music 경로는" + musicInfo.getAbsolutePath());
        File[] list=musicInfo.listFiles();
        for(int i=0;i<list.length;i++){
            String fileName=list[i].getName();
            Log.d(TAG,fileName);
        }
    }

    public void pause2(){

    }
    public void stop2(){

    }

    @Override
    /*다른 액티비티가 나에게 응답으로 보내온 정보를 받는 메서드!
    * 다른액티비티가 닫힐때, 자동으로 수행됨!!*/
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CODE && resultCode== Activity.RESULT_OK){
            String musicName=data.getStringExtra("musicName");
            Log.d(TAG,"다른액티빈에서 응답 왔어!");
        }
    }

    public void list(){
        /*실행하고 싶은 음악리스트를 새로운 액티비티에 띄워 보여주자!!(ListView로..)*/
        Intent intent = new Intent(this,MusicListActivity.class); //안드로이드의 주요컴포넌트를 호출하거나 중요 데이터를 호출하는데 사용한다.
        this.startActivityForResult(intent, REQUEST_CODE);
    }

    public void btnClick(View view){
        switch(view.getId()){
            case R.id.bt_play : play(); break;
            case R.id.bt_pause : pause(); break;
            case R.id.bt_stop : stop(); break;

            case R.id.bt_play2 : play2(); break;
            case R.id.bt_pause2 : pause2(); break;
            case R.id.bt_stop2: stop2(); break;
            case R.id.bt_list: list(); break;

        }
    }
}
