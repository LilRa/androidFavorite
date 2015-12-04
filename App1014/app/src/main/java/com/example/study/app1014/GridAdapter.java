package com.example.study.app1014;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by student on 2015-10-14.
 */
public class GridAdapter extends BaseAdapter {

    ProductDAO dao;
    List<Product> list;
    Context context;

    /*dao에 있는 list를 GridAdapter 에서 사용한다.*/
    public GridAdapter(Context context) {
        this.context = context;
        dao = new ProductDAO();
        list = dao.selectAll();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;
        /*convertView가 null이면 */
        if (convertView == null) {
            ProductView pv = new ProductView(context);
            view=pv;
        }else{
            view=convertView;
        }
        /*반환받은 레이아웃 위젯은 메모리에는 올라왔으나,dto의 데이터와의 매핑은 못했다.*/
        Product dto = list.get(position);
        ((ProductView)view).setData(dto);
        return view;
    }

}
