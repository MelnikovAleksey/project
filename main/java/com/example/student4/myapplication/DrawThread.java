package com.example.student4.myapplication0;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.SurfaceHolder;


public class DrawThread extends Thread {

    int p1 = 500;
    int p2;
    int p3;
    int p4;
    int p5;
    int p6;
    int p7;
    int p8;

    MainActivity proc;


    Paint paint = new Paint();
    public void color() {
        paint.setColor(Color.BLACK);
    }

    private SurfaceHolder surfaceHolder;

    private volatile boolean running = true;

    public DrawThread(Context context, SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        proc = (MainActivity)context;
    }

    public void requestStop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            Canvas canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                try {
                    canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.MULTIPLY);
                    p1 = proc.procent_findout(1);
                    p2 = proc.procent_findout(2);
                    p3 = proc.procent_findout(3);
                    p4 = proc.procent_findout(4);
                    p5 = proc.procent_findout(5);
                    p6 = proc.procent_findout(6);
                    p7 = proc.procent_findout(7);
                    p8 = proc.procent_findout(8);
                    color();
                    canvas.drawLine(400,500-p1,350,500-p2,paint);
                    canvas.drawLine(350,500-p2,300,500-p3,paint);
                    canvas.drawLine(300,500-p3,250,500-p4,paint);
                    canvas.drawLine(250,500-p4,200,500-p5,paint);
                    canvas.drawLine(200,500-p5,150,500-p6,paint);
                    canvas.drawLine(150,500-p6,100,500-p7,paint);
                    canvas.drawLine(100,500-p7,50,500-p8,paint);

                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}