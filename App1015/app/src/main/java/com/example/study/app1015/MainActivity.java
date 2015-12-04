package com.example.study.app1015;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    /*대화용 소켓 선언*/
    Socket client;
    EditText edit_ip, edit_port;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_ip = (EditText) findViewById(R.id.edit_ip);
        edit_port = (EditText) findViewById(R.id.edit_port);
    }

    /*접속 메서드 정의*/
    public void connect() {
        String ip = edit_ip.getText().toString();
        int port = Integer.parseInt(edit_port.getText().toString());
        try {
            client = new Socket(ip, port);  /*접속 시도!!*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnClick(View view) {
        connect();
    }
}
