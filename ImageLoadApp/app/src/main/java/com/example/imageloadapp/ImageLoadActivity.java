package com.example.imageloadapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by jhmfrd on 2015-10-28.
 */
public class ImageLoadActivity extends Activity{
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_layout);

        layout=(LinearLayout)findViewById(R.id.layout);

    }
    public void btnCllick(View view){
        ImageAsync imageAsync = new ImageAsync(this);
        imageAsync.execute("http://androidsds.cafe24.com/lilRa/images/health.png");
    }
}
