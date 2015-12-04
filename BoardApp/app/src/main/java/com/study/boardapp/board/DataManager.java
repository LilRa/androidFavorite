/*
 웹서버로부터 데이터를 가져오는 전담 객체
*/
package com.study.boardapp.board;


import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class DataManager implements  Runnable{
    String TAG;
    URL url;
    HttpURLConnection con;
    Thread thread;
    BufferedReader buffr;
    XMLDefaultHandler xmlDefaultHandler;
    SAXParserFactory saxParserFactory;
    SAXParser saxParser;
    InputStream is;
    ItemAdapter itemAdapter;
    Handler handler;

    public DataManager(ItemAdapter itemAdapter){
        TAG=this.getClass().getName();
        this.itemAdapter=itemAdapter;
    }

    public void connectServer(){

        handler = new Handler(){
            public void handleMessage(Message msg){
                itemAdapter.notifyDataSetInvalidated();
            }
        };

        thread = new Thread(this);
        thread.start();

        saxParserFactory = SAXParserFactory.newInstance();
        try {
            saxParser = saxParserFactory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public void loadData(){
        try {
            is=con.getInputStream();
            parseData();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseData(){
        try {
            xmlDefaultHandler = new XMLDefaultHandler();
            saxParser.parse(is, xmlDefaultHandler);

            Log.d(TAG, "파싱완료 후 list 갯수는 " + xmlDefaultHandler.list.size());

            itemAdapter.list=xmlDefaultHandler.list;
            handler.sendEmptyMessage(0);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run() {
        Log.d(TAG, "loadData() called !!");

        try {
            url = new URL("http://192.168.0.12:8080/board/list.jsp");
            con=(HttpURLConnection)url.openConnection();

            int code=con.getResponseCode();

            if(code == 200) {
                Log.d(TAG, "code is " + code);
                loadData();
            }else{
                Log.d(TAG, "서버오류로 인해서 데이터를 가져오지 못함");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(con !=null){
                con.disconnect();
            }
        }
    }
}
