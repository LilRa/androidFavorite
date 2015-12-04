package com.example.study.app1014.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.study.app1014.R;

/**
 * Created by student on 2015-10-14.
 */
public class LoginFormActivity extends Activity {

    EditText edit_id,edit_pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.loginform_layout);
        edit_id=(EditText)findViewById(R.id.edit_id);
        edit_pwd=(EditText)findViewById(R.id.edit_pwd);
    }
    /*다른 액티비티를 호출하되, 인텐트를 데이터에 보내자*/
    public void loginCheck(){
        Intent intent = new Intent(this,LoginResultActivity.class);

        intent.putExtra("login_id",edit_id.getText().toString());
        intent.putExtra("login_pwd",edit_pwd.getText().toString());

        startActivity(intent);
    }
    public void btnClick(View view){
        loginCheck();
    }
}
