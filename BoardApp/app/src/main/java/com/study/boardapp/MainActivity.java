package com.study.boardapp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.study.boardapp.board.ListFragment;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    String TAG;
    ViewPager viewPager;
    MyPagerAdapter myPagerAdapter;
    Button bt_board;
    ListFragment listFragment;
    public static MainActivity mainActivity;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity=this;
        TAG=this.getClass().getName();

        setContentView(R.layout.activity_main);
        bt_board=(Button)findViewById(R.id.bt_board);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        Log.d(TAG, "MainActivity is "+this);

        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setIcon(R.drawable.batman);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        viewPager.setAdapter(myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager()));
        bt_board.setOnClickListener(this);

        listFragment=(ListFragment)myPagerAdapter.getItem(viewPager.getCurrentItem());
    }
    public void reload(){
        listFragment.reload();
    }
    public void onClick(View v) {
        listFragment.reload();
    }
}
