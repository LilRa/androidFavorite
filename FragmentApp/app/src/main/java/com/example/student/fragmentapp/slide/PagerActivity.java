package com.example.student.fragmentapp.slide;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.student.fragmentapp.R;

public class PagerActivity extends AppCompatActivity{
    ViewPager viewPager;
    MyAdapter adapter;

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.page_layout);

            viewPager =(ViewPager) findViewById(R.id.viewPager);
            adapter = new MyAdapter(getSupportFragmentManager());

            /*뷰페이저와 어댑터 연결*/
            viewPager.setAdapter(adapter);
        }

    public void btnClick(View view){
        if(view.getId()==R.id.bt_red){
            viewPager.setCurrentItem(0,true);
        }
        if(view.getId()==R.id.bt_green){
            viewPager.setCurrentItem(1,true);
        }
        if(view.getId()==R.id.bt_blue){
            viewPager.setCurrentItem(2,true);
        }
    }

}
