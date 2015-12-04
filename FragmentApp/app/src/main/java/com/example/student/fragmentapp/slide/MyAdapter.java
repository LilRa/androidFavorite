/*ViewPager가 껍데기에 불과하기 때문에, 실제로 어떤 프레그먼트를 몇개나 보여줘야 할지의 정보는 어댑터가 가지고 있다.
* 이런 방식은 ViewPager뿐만 아니라, 어댑터뷰들에서 많이 봐왔다.!!*/
package com.example.student.fragmentapp.slide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyAdapter extends FragmentStatePagerAdapter{
Fragment[] fragments = new Fragment[3];
    public MyAdapter(FragmentManager fm) {
        super(fm);
        fragments[0]=new RedFragment();
        fragments[1]=new GreenFragment();
        fragments[2]=new BlueFragment();
    }

   /*몇페이지로 구성되어있는지 반환
   * 총 몇개의 프래그먼트가 있는지 반환*/
    public int getCount() {
        return fragments.length;
    }

    public Fragment getItem(int position) {
        return fragments[position];
    }
}
