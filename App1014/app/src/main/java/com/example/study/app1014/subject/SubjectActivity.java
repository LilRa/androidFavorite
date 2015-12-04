package com.example.study.app1014.subject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


import com.example.study.app1014.R;

/**
 * Created by student on 2015-10-14.
 */
public class SubjectActivity extends Activity{
    RadioButton radio_program,radio_db;
    public static final int REQUEST_CODE=1;
TextView txt_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_layout);
        radio_program = (RadioButton)findViewById(R.id.radio_program);
        radio_db=(RadioButton)findViewById(R.id.radio_db);
        txt_result=(TextView)findViewById(R.id.txt_result);
    }
/*startActivityForResult() 메서드에 의해, 응답을 받을 액티비티가 데이터를 보낼경우, 아래의 메서드가 작동하게 됨*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /*내가 보냈던 요청에 대한 응답이라면...*/
        if (requestCode==REQUEST_CODE) {
            if (resultCode==RESULT_OK){
                /*전달받은 Intent로 부터 데이터를 꺼내서 처리하면 됨..*/
                String item=data.getStringExtra("selected_item");
                txt_result.setText("당신이 선택한 과목은 : "+item);
                Toast.makeText(this,"넘겨받은 requestCode는 :"+requestCode,Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void btnClick(View view){
       /* 라디오 버튼에 따라 ,각각 알맞는 액티비티 띄우기!!*/
        if(radio_program.isChecked()){
            Intent intent = new Intent(this,ProgramActivity.class);

            startActivityForResult(intent, REQUEST_CODE);
        }else if(radio_db.isChecked()){

        }
    }
}
