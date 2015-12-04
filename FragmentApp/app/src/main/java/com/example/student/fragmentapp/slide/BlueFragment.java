package com.example.student.fragmentapp.slide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.student.fragmentapp.R;

/**
 * Created by student on 2015-10-23.
 */
public class BlueFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.blue_layout,container,false);
       
    }
}
