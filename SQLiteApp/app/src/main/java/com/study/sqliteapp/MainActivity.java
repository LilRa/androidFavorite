package com.study.sqliteapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    MyOpenHelper myOpenHelper;
    String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG=this.getClass().getName();
        setContentView(R.layout.activity_main);

        //myOpenHelper=new MyOpenHelper(this,"android_db.sqlite",null,1);
        //my_db.sqlite가 없으므로 MyOpenHelper의 onCreate가 실행된다.
        //myOpenHelper=new MyOpenHelper(this,"db1.sqlite",null,1);


        //2로 바꿔서 onUpgrade를 실행해보자!
        myOpenHelper=new MyOpenHelper(this,"db2.sqlite",null,1);
        Log.d(TAG,"myOpenHelper: "+myOpenHelper);

        /*
        getReadable(), getWritableDabase()메서드가 호출되어질때 onCreate, onUpgrade메서드가
        호출됨에 주의하자!!
         */
        myOpenHelper.getWritableDatabase();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
