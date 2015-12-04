package com.example.sufaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * SurfaceHolder 는 Surface를 관리하려면, CallBack 인터페이스를 통해 그 상태를 알수있다..
 */
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback{
    SurfaceHolder holder;   /*실제 그림이 그려질 서피스를 제어해주는 객체*/
    Paint paint;
    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init(){
        paint=new Paint();
        paint.setColor(Color.RED);
        holder.addCallback(this);
        Canvas canvas=holder.lockCanvas();
        canvas.drawLine(0,0,500,600,paint);
        holder.unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        this.holder=holder;

        init();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
