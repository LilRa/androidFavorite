package com.example.sufaceview;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MySurfaceView ms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ms=(MySurfaceView2)findViewById(R)
    }
    /*빨간 사각형을 우측하단으로 내려가게 해본다!*/
    public void move(){

    }

    public void btnClick(View view){
        move();
    }
}
