package com.example.study.app1014.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.study.app1014.R;

/**
 * Created by student on 2015-10-14.
 */
public class LoginResultActivity extends Activity{
    EditText edit_id,edit_pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.loginresult_layout);

        /*새로운 인텐트가 아니라, 자신에게 전달된 엔텐트 얻기!!*/
        Intent intent=getIntent();

        String login_id = intent.getStringExtra("login_id");
        String login_pwd = intent.getStringExtra("login_pwd");

        edit_id=(EditText)findViewById(R.id.edit_id);
        edit_pwd=(EditText)findViewById(R.id.edit_pwd);

        edit_id.setText(login_id);
        edit_pwd.setText(login_pwd);
    }

}
