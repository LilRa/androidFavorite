package com.example.study.app1014;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015-10-14.
 */
public class ProductDAO {

    /*모든 데이터 가져오기*/
    public List selectAll(){
        ArrayList<Product> list=new ArrayList<Product>();
        int[] arr_img={
           R.drawable.batman,
           R.drawable.flash,
           R.drawable.hankman,
           R.drawable.ironman,
           R.drawable.loki,
           R.drawable.punisher,
           R.drawable.robin,
           R.drawable.spiderman,
           R.drawable.shield,
           R.drawable.superman
        };
        for(int i=0;i<10;i++){
            Product dto = new Product();
            dto.setProduct_img(arr_img[i]);
            dto.setProduct_name("히어로"+i);
            list.add(dto);
        }
        return list;

    }
}
