package com.example.study.app1014;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by student on 2015-10-14.
 */
public class ProductView extends LinearLayout{
    private CheckBox product_ch;
    private ImageView product_img;
    private TextView product_name;
    LayoutInflater inflater;

    public ProductView(Context context) {
        super(context);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.product_layout,this);
        product_ch=(CheckBox)findViewById(R.id.product_ch);
        product_img=(ImageView)findViewById(R.id.product_img);
        product_name=(TextView)findViewById(R.id.product_name);
    }
    /*외부에서 데이터를 주입할 수 있는 setter의 정의*/
    public void setData(Product dto){
        product_ch.setChecked(dto.isProduct_ch());
        product_img.setImageResource(dto.getProduct_img());
        product_name.setText(dto.getProduct_name());
    }
}
