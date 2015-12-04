package com.example.androidboard.board;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by jhmfrd on 2015-10-26.
 */

public class BoardItemAdapter extends BaseAdapter implements Runnable{
    String TAG;
    Context context;
    ArrayList<Board> list = new ArrayList<Board>();
    Thread thread;
    BufferedReader buffr; /*xml 읽어오려구~*/
    InputStream is;
    StringBuilder sb;
    SAXParser saxParser;
    SAXParserFactory saxParserFactory;
    Handler handler;
    BoardItemAdapter boardItemAdapter;
    BoardDefaultHandler boardDefaultHandler;

    public BoardItemAdapter(Context context) {
        this.context=context;
        boardItemAdapter=this;
        TAG = this.getClass().getName();

        handler = new Handler(){
            public void handleMessage(Message msg){
                boardItemAdapter.notifyDataSetInvalidated();
            }
        };
        loadData();
    }

    public void loadData(){
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        try {
            URL url = new URL("http://70.12.109.79:9090/board/list.jsp");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.getResponseCode();  /*이때 접속이 일어남에 주의*/
          /*  *//*스트림을 통해 서버상의 xml 가져오기*//*
            buffr=new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
            String data =null;
            sb=new StringBuilder();
            while(true){
                data=buffr.readLine();
                if(data==null){
                    break;
                }
                sb.append(data);
            }
            Log.d(TAG, sb.toString());

            *//*읽혀진 데이터를 대상으로 파싱 작업시작
            * 1.json
            * 2.xml(DOM,SAX)
            */
            is=con.getInputStream();

            saxParserFactory=SAXParserFactory.newInstance();
            try {
                saxParser=saxParserFactory.newSAXParser();
                saxParser.parse(is,boardDefaultHandler=new BoardDefaultHandler(this));

                /*파싱이 모두 완료된 시점에 BoardDefaultHandler
                * 가 보유한 ArrayList를 현재 클래스가 보유한 ArrayList에 대입!*/
                list=boardDefaultHandler.list;
                handler.sendEmptyMessage(0);
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
        }catch(MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getCount() {
        return list.size();
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // 리스트 갯수만큼 커스텀뷰 생성하기!!!!
        View view = null;

        if(convertView == null) {
            view = new BoardItem(context);
        }else{
            view = convertView;
        }
        Board dto = list.get(position);
        BoardItem boardItem = (BoardItem)view;

        boardItem.setTitle(dto.getTitle());
        boardItem.setWriter(dto.getWriter());
        boardItem.setRegdate(dto.getRegdate());

        return view;
    }
}