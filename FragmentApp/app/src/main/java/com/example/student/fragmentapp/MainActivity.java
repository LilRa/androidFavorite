package com.example.student.fragmentapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
    }

    public void btnClick(View view){

        if(view.getId() == R.id.bt_red){
            transaction.replace(R.id.layout, new RedFragment());
            transaction.commit();
        }
        if(view.getId() == R.id.bt_green){
            transaction.replace(R.id.layout, new GreenFragment());
            transaction.commit();
        }
        if(view.getId() == R.id.bt_blue){
            transaction.replace(R.id.layout, new BlueFragment());
            transaction.commit();
        }
    }
}
