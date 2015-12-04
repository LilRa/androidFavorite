package com.example.mapapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by student on 2015-10-29.
 */
public class MyMapActivity extends AppCompatActivity implements OnMapReadyCallback{

    SupportMapFragment map;
    String data;
    JSONArray array;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);

        /*웹서버 연동시작!!*/
        MapAsync mapAsync = new MapAsync(this);
        mapAsync.execute("http://androidsds.cafe24.com/lilRa/admin/list.jsp");

        map =(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);

    }
    public void showMap(String data){
        this.data=data;
        map.getMapAsync(this);    /*이 시점에 지도와 리스너와 연결*/
    }
    public void onMapReady(GoogleMap googlemap) {
            /*멤버필드인 data변수를 대상으로 제이슨 파싱 시작*/
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray array=jsonObject.getJSONArray("storeList");

        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);
            LatLng sam = new LatLng(obj.getDouble("lati"),obj.getDouble("longi"));
            googlemap.addMarker(new MarkerOptions().position(sam).title(obj.getString("store")));
            googlemap.moveCamera(CameraUpdateFactory.newLatLng(sam));
        }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}