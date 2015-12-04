package favorite.com.navidrawer;

import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter adapter;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FrameLayout contantFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawLayout);
        contantFrame = (FrameLayout) findViewById(R.id.contentFrame);

        adapter = ArrayAdapter.createFromResource(this, R.array.color, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        /*서랍을 열고 닫는 기능을 가진 토글 버튼!!*/
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.closed);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*서랍과 서랍 상태리스너와의 연결*/
        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        /*리스트 뷰의 아이템이 선택될때 서랍을 닫고 해당컨텐츠 나오게*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: contantFrame.setBackgroundColor(Color.RED); break;
                    case 1: contantFrame.setBackgroundColor(Color.BLUE); break;
                    case 2: contantFrame.setBackgroundColor(Color.YELLOW); break;
                    case 3: contantFrame.setBackgroundColor(Color.GRAY); break;
                    case 4: contantFrame.setBackgroundColor(Color.CYAN); break;
                    case 5: contantFrame.setBackgroundColor(Color.GREEN); break;
                }
                drawerLayout.closeDrawer(listView);
            }
        });

    }

    /*액션바에 올려져 있는 아이템들을 선택했을대 처리*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Toast.makeText(this, "아이템 누름", Toast.LENGTH_SHORT).show();
        //drawerLayout.closeDrawer(listView);
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
