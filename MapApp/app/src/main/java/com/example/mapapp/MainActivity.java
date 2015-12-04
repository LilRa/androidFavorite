package com.example.mapapp;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements LocationListener{
    LocationManager locationManager;
    EditText edit_lati,edit_longi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_lati = (EditText)findViewById(R.id.edit_lati); /*위도*/
        edit_longi=(EditText)findViewById(R.id.edit_longi); /*경도*/
    }

    public void getPosition(){
        /*개발자가 생성하지 않고, 이미 안드로이드를 제작한 제작사의 개발자들에 의해 실행되고 있는 프로세스(서비스)
        * 중 GPS 모듈을 제어해주는 서비스를 가리켜 LocationManager 라 하는데,
        * 이 서비스객체를 얻어오기 위해서는 getSystemService()*/
        long minTime=5000; /*몇초마다 갱신할지 갱신정보를 가져올지...*/
        float minDistance=0;
        locationManager =(LocationManager)getSystemService(LOCATION_SERVICE);
        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,minTime,minDistance,this);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    /*변경정보를 갱신시마다, 호출되는 메서드!!*/
    public void onLocationChanged(Location location) {
        double lati=location.getLatitude(); /*위도*/
        double longi=location.getLongitude(); /*경도*/

        edit_lati.setText(Double.toString(lati));
        edit_longi.setText(Double.toString(longi));
        edit_lati.invalidate();
        edit_longi.invalidate();

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    public void btnClick(View view){
        getPosition();

    }
}
