package com.study.boardapp.board;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.study.boardapp.R;

public class BoardItem extends LinearLayout{
    private TextView txt_title;
    private TextView txt_writer;
    private TextView txt_regdate;

    private String title;
    private String writer;
    private String regdate;

    LayoutInflater inflater;

    public BoardItem(Context context) {
        super(context);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.list_item, this, true);

        txt_title=(TextView)view.findViewById(R.id.txt_title);
        txt_writer=(TextView)view.findViewById(R.id.txt_writer);
        txt_regdate=(TextView)view.findViewById(R.id.txt_regdate);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        txt_title.setText(title);
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
        txt_writer.setText(writer);
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
        txt_regdate.setText(regdate);
    }
}
