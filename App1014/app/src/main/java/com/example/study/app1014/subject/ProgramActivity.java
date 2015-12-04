package com.example.study.app1014.subject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.study.app1014.R;

import java.util.ArrayList;

/**
 * Created by student on 2015-10-14.
 */
public class ProgramActivity extends Activity {
    ArrayList<String> list = new ArrayList<String>();
    Spinner spinner;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_layout);

        list.add("java");
        list.add("Jsp&Servlet");
        list.add("Node.js");
        list.add("Android");

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,list);
        spinner =(Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
    }
    public void btnClick(View view){
        /*Spinner의 선택한 값 얻어오기!!*/
        String item=(String)spinner.getSelectedItem();
        Intent intent = new Intent(this,SubjectActivity.class);
        intent.putExtra("selected_item",item);

        setResult(RESULT_OK,intent);
        finish();/*현재 액티비티 종료*/
    }
}
