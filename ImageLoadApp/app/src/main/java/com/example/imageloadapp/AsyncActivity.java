/*안드로이드에서 웹연동은 가져온 데이터는 거의 UI에 반영하게 된다.
* 이때, 쓰레드가 UI를 제어할 수 없다는 원칙 때문에 Handler를 사용하게 되는데,
* 너무 소스가 복잡하게 된다.
* 이러한 문제를 해결해 주기 위한 객체가 바로 Asyntask 이다!!
*
* 안드로이드에서 쓰레드를 구현하는 방법은 총3가지가 지원된다.
* Thread,new runnable,asyncTask
* */
package com.example.imageloadapp;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by jhmfrd on 2015-10-28.
 */
public class AsyncActivity extends Activity{
    TextView txt_data;
    TextAsync textAsync;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.async_layout);
        txt_data=(TextView)findViewById(R.id.txt_data);

    }

    public void btnClick(View view){
        textAsync = new TextAsync(this);

        /*doInbackground() 메서드는 직접 호출해서는 안된다!!*/
        textAsync.execute("http://androidsds.cafe24.com/lilRa/data.jsp");
    }



}
