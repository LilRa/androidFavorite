/*
*   일정시간 간격으로 움직이는 이미지 구현
* */
package com.example.jhmfrd.graphicapp2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

import com.example.jhmfrd.graphicapp2.R;

/**
 * Created by student on 2015-10-21.
 */
public class MyView extends View implements Runnable {
    Bitmap bitmap; // 이미지가 아니라, 비트맵이란 객체이다!!!! 이미지보다 넓은 개념
    Paint paint;
    Thread thread;
    Handler handler;
    int x;
    boolean flag = true;


    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.health);

        handler = new Handler(){
            // 동생쓰레드의 요쳥에 의해 작동할 메서드!!!!
            // 이 메서드는 메인쓰레드에 의해 작동하므로, UI가능!!
            public void handleMessage(Message msg) {
                invalidate();
            }
        };
        thread = new Thread(this);

        paint = new Paint();
        paint.setColor(Color.RED);

        thread.start();
    } 

    public void run() {
        while(true){
            handler.sendEmptyMessage(0);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void onDraw(Canvas canvas) {

        if(flag){
            x++;
        }else{
            x--;
        }
        if(x>=500 || x<=0){
            flag =! flag;
        }

        canvas.drawBitmap(bitmap,x,0,paint);
    }
}