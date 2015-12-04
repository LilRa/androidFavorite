package com.example.mapapp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jhmfrd on 2015-10-30.
 */
public class MapAsync extends AsyncTask<String,Void,String>{
    MyMapActivity myMapActivity;
    URL url;
    HttpURLConnection con;
    BufferedReader buffr;
    StringBuffer sb;

    public MapAsync(MyMapActivity myMapActivity){
        myMapActivity= this.myMapActivity;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            url=new URL(params[0]);
            con=(HttpURLConnection)url.openConnection();
            con.setDoInput(true);
            con.setReadTimeout(5000);
            con.getResponseCode();

            buffr = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
            String data = null;
            sb=new StringBuffer();

            while((data=buffr.readLine())!=null){
                sb.append(data);
                    }
            Log.d(this.getClass().getName(), sb.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    @Override
       protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        /*맵과 리스너 연결*/
        myMapActivity.showMap(s);
    }

}
