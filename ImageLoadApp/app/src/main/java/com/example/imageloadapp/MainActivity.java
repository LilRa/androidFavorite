package com.example.imageloadapp;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    URL url;/*어떤 서버에 접속할지의 정보*/
    HttpURLConnection con; /*http상의 요청처리 객체*/
    Thread thread;
    StringBuffer sb; /*데이터 누적용...*/
    BufferedReader buffr;
    TextView txt_data;
    Handler handler;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_data.setText(sb.toString());

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Bundle bundle=msg.getData();
                String json=bundle.getString("json");
              /*파싱 시작*/
                try {
                    JSONObject jsonObject=new JSONObject(json);
                    String name=jsonObject.getString("name");
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        };

    }
    /*웹서버상의 json데이터 가져오기*/
    public void connect(){
        try {
            url=new URL("http://70.12.109.79:9090/lilRa/data.jsp");
            con=(HttpURLConnection)url.openConnection();
            con.setDoInput(true);
            con.getResponseCode();
            con.connect();
            buffr=new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));

            String data = null;
            sb=new StringBuffer();

            while (true) {
                data = buffr.readLine();/*한줄 읽음!!*/
                if (data == null) break;
                sb.append(data);
            }
            /*핸들러에 부탁*/
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putString("json",sb.toString());
            message.setData(bundle);
            handler.sendMessage(message);

                txt_data=(TextView)findViewById(R.id.txt_data);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void btnClick(View view){
        thread=new Thread(){
            @Override
            public void run() {
                connect();
            }
        };
        thread.start();
    }
}
