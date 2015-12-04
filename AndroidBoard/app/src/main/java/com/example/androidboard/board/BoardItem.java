package com.example.androidboard.board;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.androidboard.R;

/**
 * 하나의 아이템을 개발자가 복합위젯으로 표현하는 위젯=커스텀 뷰
 */

public class BoardItem extends LinearLayout{
    LayoutInflater inflater;
    TextView txt_title;
    TextView txt_writer;
    TextView txt_regdate;

    private String title;
    private String writer;
    private String regdate;


    public BoardItem(Context context) {
        super(context);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.board_item, this, true);

        txt_title = (TextView)findViewById(R.id.txt_title);
        txt_writer = (TextView)findViewById(R.id.txt_writer);
        txt_regdate = (TextView)findViewById(R.id.txt_regdate);
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
