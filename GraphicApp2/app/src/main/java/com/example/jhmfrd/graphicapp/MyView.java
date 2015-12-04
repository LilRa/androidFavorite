package com.example.jhmfrd.graphicapp;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jhmfrd on 2015-10-20.
 */
public class MyView extends View implements Runnable {
    Paint paint;
    Thread thread;
    int x,y;
    Handler handler;


    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Thread thread = new Thread(this);
        thread.start();
        paint.setColor(Color.RED);
        handler=new Handler() {
            @Override
            public void handleMessage(Message msg) {
                invalidate();
            }
        };
    }

    public void run() {
        while(true){
           handler.sendEmptyMessage(0);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        x+=5;
        y+=5;
        canvas.drawRect(x,y, 100, 100, paint);
    }
}