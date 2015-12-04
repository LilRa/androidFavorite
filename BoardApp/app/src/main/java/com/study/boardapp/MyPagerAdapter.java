package com.study.boardapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.study.boardapp.board.ListFragment;
import com.study.boardapp.config.ConfigFragment;
import com.study.boardapp.mypage.MyInfoFragment;

public class MyPagerAdapter extends FragmentStatePagerAdapter{

    Fragment[] fragments = new Fragment[3];

    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);

        fragments[0] = new ListFragment();
        fragments[1] = new MyInfoFragment();
        fragments[2] = new ConfigFragment();
    }

    public int getCount() {
        return fragments.length;
    }

    public Fragment getItem(int position) {
        return fragments[position];
    }
}
