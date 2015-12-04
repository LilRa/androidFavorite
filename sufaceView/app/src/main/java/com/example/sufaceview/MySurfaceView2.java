package com.example.sufaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * 최근의 SurfaceView는 기존의 안드로이드 View체계를 거의 따르므로, 이전처럼
 * 인터페이스 구현이 필요x
 *
 */
public class MySurfaceView2 extends SurfaceView{
    Paint paint;
    public MySurfaceView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public void init(){
        paint=new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0,0,200,300,paint);
    }
}
