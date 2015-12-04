package com.board.mediaapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    /*
    MediaPlayer : 미디어 파일 재생을 담당(음원,영상)
    MediaRecord : 미디어 파일 녹화를 담당(음원,영상)
     */
    public static final int REQUEST_CODE=1;     //상수에 필요한 조건은! static final public! 총 3가지!
    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer2;
    String TAG;
    TextView txt,song_title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TAG = this.getClass().getName();
        txt = (TextView) findViewById(R.id.choice);
    }

    public void play() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.iu);
        }
        mediaPlayer.start();
    }

    public void pause() {
        mediaPlayer.pause();
    }

    public void stop() {
        mediaPlayer.stop();
        mediaPlayer = null;
    }

    public void play2() {
        if (mediaPlayer2 == null) {
            mediaPlayer2 = new MediaPlayer();

            //mediaPlayer2.setDataSource();
            String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Music/" + song_title.getText().toString();
            try {
                mediaPlayer2.setDataSource(path);
                mediaPlayer2.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        mediaPlayer2.start();
    }

    public void pause2() {
        mediaPlayer2.pause();
    }

    public void stop2() {
        /*자원을 릴리즈..*/
        if(mediaPlayer2!=null){
            mediaPlayer2.release();
            mediaPlayer2=null;
        }
    }


    // 다른 액티비티가 나에게 응답으로 보내온 정보를 받는 메서드!
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CODE && resultCode== Activity.RESULT_OK){
            Log.d(TAG, "앙 기무띠! 다른 액티비티에서 응답왔어!");
            String musicName=data.getStringExtra("MusicName");
            txt.setText(musicName);
            Log.d(TAG, "선택한 음원파일명은" + musicName);
            song_title.setText(musicName);
        }
    }

    public void list() {
        Intent intent = new Intent(this, MusicListActivity.class);  //액티비티는 개발자가 정의할수있는게 아니다! new 할수없다!
        startActivityForResult(intent,REQUEST_CODE);       //결과를 기대하고 가져오겠다!! 다시 받는다는거지! requestcode
        //onActivityResult
    }


    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.bt_play:
                play();
                break;
            case R.id.bt_pause:
                pause();
                break;
            case R.id.bt_stop:
                stop();
                break;

            case R.id.bt_play2:
                play2();
                break;
            case R.id.bt_pause2:
                pause2();
                break;
            case R.id.bt_stop2:
                stop2();
                break;

            case R.id.bt_list:
                list();
                break;
        }
    }
}
