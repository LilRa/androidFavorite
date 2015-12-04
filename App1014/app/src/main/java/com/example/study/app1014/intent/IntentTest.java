/*현재앱이 아닌, 다른앱에 들어있는 Activity클래스는 우리가 개발하지 않은 경우가
* 대부분이므로, 정확한 클래스명을 알수 없다.!
* 따라서 이경우, 명시적인 인텐트를 사용할 수 없고, 암시적 인텐트를 사용할 수 있다!*/
package com.example.study.app1014.intent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

import com.example.study.app1014.R;

/**
 * Created by student on 2015-10-14.
 */
public class IntentTest extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_layout);
    }

    public void btnClick(View view) {
        /*전화걸기 앱의 다이얼 패드를 열어본다*/

        if(view.getId()==R.id.bt_dial) {
        /*Intent intent = new Intent(Intent.ACTION_DIAL); *//*클래스명을 모르므로, 얼버무려야 한다..*/
            Intent intent = new Intent(Intent.ACTION_DIAL);
        /*인텐트에 부가적 데이터를 넣을 수 있다.*/
            intent.setData(Uri.parse("tel:010-6268-4033"));
            startActivity(intent);
        }else if(view.getId()==R.id.bt_search){
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            startActivity(intent);
        }else if(view.getId()==R.id.bt_map){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:37.501148, 127.039190"));
            startActivity(intent);
        }else if(view.getId()==R.id.bt_contact){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(ContactsContract.Contacts.CONTENT_URI);
            startActivity(intent);
        }
    }
}
