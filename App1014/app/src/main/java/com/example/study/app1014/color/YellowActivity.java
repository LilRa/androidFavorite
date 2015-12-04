package com.example.study.app1014.color;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.study.app1014.R;

/**
 * Created by student on 2015-10-14.
 */
public class YellowActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yellow_layout);
    }
    public void btnClick(View view){
        this.finish();/*현재 액티비티 종료*/
    }
}
