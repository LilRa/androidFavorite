package com.example.study.app1014;

/**
 * Created by student on 2015-10-14.
 */
public class Product {
    public boolean isProduct_ch() {
        return product_ch;
    }

    public void setProduct_ch(boolean product_ch) {
        this.product_ch = product_ch;
    }

    public int getProduct_img() {
        return product_img;
    }

    public void setProduct_img(int product_img) {
        this.product_img = product_img;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    private boolean product_ch;
    private int product_img;
    private String product_name;

}
