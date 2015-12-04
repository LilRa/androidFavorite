package com.example.imageloadapp;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/*인수1:doInBackground에서 사용할 제너릭 타입
* 인수 2: onProgressUpdate에서 사용할 제너릭타입
* 인수3: onPostExecute 에서 사용할 제너릭 타입*/
public class TextAsync extends AsyncTask<String,Void,String>{
    AsyncActivity asyncActivity;
    URL url;
    HttpURLConnection con;

    public TextAsync(AsyncActivity asyncActivity) {
        this.asyncActivity = asyncActivity;
    }

    /*쓰레드가 동작하기전, 초기화등의 작업에 사용하면 유용
    * 이 메서드는 메인 쓰레드에 의해!!(UI 제어 가능!!)*/
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    /*하위 쓰레드에 의해 동작하는 메서드!!
    * 메인 쓰레드와는 독립적으로 수행할 영역은 이 메서드를 이용한다.
    * UI제어 불가!!*/
    protected String doInBackground(String[] params) {
        StringBuffer sb = new StringBuffer();
        try {
            url=new URL(params[0]);
            con=(HttpURLConnection)url.openConnection();

            String data = null;
            BufferedReader buffr = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
            while ((data=buffr.readLine())!=null){
                sb.append(data);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    @Override
    /*개발자가 정의한 쓰레드가 doInbackground() 메서드를 수행하는 동안,
    * 중간중간에 UI를 제어하는 등의 작업이 가능!!
    * 이 메서드는 UI를 제어할 수 있기 때문에  메인 쓰레드에 의해 수행!!*/
    protected void onProgressUpdate(Void[] values) {
        super.onProgressUpdate(values);
    }

    @Override
    /*doInbackground 메서드의 수행이 모두 완료되면, 최종적으로
    * 객체를 반환해 주는데 그 객체를 전달받아 UI등에 반영이 가능한 메서드이다!!
    * 이 메서드의 수행은 메인스레드가 한다!!*/
    protected void onPostExecute(String obj) {
        try {
            JSONObject jsonObject = new JSONObject((String)obj);
            asyncActivity.txt_data.setText(jsonObject.getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
