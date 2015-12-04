package com.example.study.app1014.color;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.study.app1014.R;

/**
 * Created by student on 2015-10-14.
 */
public class GreenActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.green_layout);
    }
    public void btnClick(View view){    /*메서드를 실행시키려면 View가 들어가야 한다.*/

        /*노란 액티비티를 호출하자!!
        *
        * 액티비티는 시스템이 관리하는 안드로이드의 주요 컴포넌트이므로, 개발자가 생성하거나 소멸시키지 못한다.
        *즉, 시스템이 관리한다!!
        * 따라서 개발자가 액티비티를 생성하고 싶을때는 시스템에게 요청을 해야 하며, 이때 개발자는 시스템이 이해할 수 있는
        * 방법으로 요청을 시도해야 한다!! 이때 사용되는 객체가 Intent라 한다
        *
        * 인텐트의 유형
        * (1) 명시적 인텐트(=explicit Intent)
        * (2) 암시적,묵시적(=implicit Intent)
        * */
        Intent intent = new Intent(this,YellowActivity.class);
        this.startActivity(intent); /*인텐트에 명시한 액티비티를 시작한다!!*/
    }
}
