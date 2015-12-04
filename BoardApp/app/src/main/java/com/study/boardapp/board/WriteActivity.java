package com.study.boardapp.board;

import android.app.Activity;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.study.boardapp.MainActivity;
import com.study.boardapp.R;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WriteActivity extends AppCompatActivity {
    String TAG;
    URL url;
    HttpURLConnection con;
    EditText edit_writer;
    EditText edit_title;
    EditText edit_content;
    StringBuffer sb;
    BufferedWriter buffw;
    Handler handler;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG=this.getClass().getName();

        setContentView(R.layout.activity_write);

        edit_writer=(EditText)findViewById(R.id.edit_writer);
        edit_title=(EditText)findViewById(R.id.edit_title);
        edit_content=(EditText)findViewById(R.id.edit_content);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        handler = new Handler(){
            public void handleMessage(Message msg) {
                getList();
            }
        };
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "item is " + item);

        if(item.getItemId() == android.R.id.home){
            this.finish();
            MainActivity mainActivity=MainActivity.mainActivity;
            mainActivity.reload();
        }
        return true;
    }

    public void regist(){
        sb = new StringBuffer();

        String writer=edit_writer.getText().toString();
        String title=edit_title.getText().toString();
        String content=edit_content.getText().toString();

        sb.append("writer="+writer+"&title="+title+"&content="+content);

        Thread thread = new Thread(){
            public void run() {
                try {
                    url = new URL("http://192.168.0.12:8080/board/write.jsp");
                    con=(HttpURLConnection)url.openConnection();
                    con.setRequestMethod("POST");
                    con.setDoOutput(true);
                    con.setDoInput(true);
                    con.setReadTimeout(5000);
                    con.setRequestProperty("charset", "utf-8");
                    con.setRequestProperty("content-type", "application/x-www-form-urlencoded");

                    buffw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream(), "UTF-8"));
                    buffw.write(sb.toString()+"\n");
                    buffw.flush();

                    con.getResponseCode();
                    handler.sendEmptyMessage(0);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(con!=null){
                        con.disconnect();
                    }
                    if(buffw!=null){
                        try {
                            buffw.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        thread.start();
    }

    public void getList(){
        this.finish();
        MainActivity mainActivity=MainActivity.mainActivity;
        mainActivity.reload();
    }
    public void btnClick(View view){
        if(view.getId() == R.id.bt_regist){
            regist();
        }
        if(view.getId() == R.id.bt_list){
            getList();
        }
    }
}
