package com.example.androidboard;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.example.androidboard.board.BoardFragment;
import com.example.androidboard.config.ConfigFragment;
import com.example.androidboard.mypage.MypageFragment;

/**
 * Created by jhmfrd on 2015-10-26.
 */
/*viewPager는 껍데기에 지나지 않기 때문에 FragmentStatePagerAdapter를 상속받는다.
* 어떤 페이지를 총 몇개 보여줄지를 결정하는 어댑터이다.*/
public class MyPagerAdapter extends FragmentStatePagerAdapter {
    /*사용할 프레그먼트 생성*/
    Fragment [] fragments = new Fragment[3];

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments[0]=new BoardFragment();
        fragments[1]=new MypageFragment();
        fragments[2]=new ConfigFragment();

    }

    public Fragment getItem(int position) {
        return fragments[position];
    }

    public int getCount() {
        return fragments.length;
    }
}
