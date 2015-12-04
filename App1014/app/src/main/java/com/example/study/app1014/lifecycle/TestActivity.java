/*액티비티의 생명주기 메서드의 호출시점을 알아보자!!*/
package com.example.study.app1014.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by student on 2015-10-14.
 */
public class TestActivity extends Activity{
    String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG=this.getClass().getName();
        Log.d(TAG, "onCreate호출");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart 호출");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume 호출");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause 호출");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop 호출");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy 호출");
    }


}
