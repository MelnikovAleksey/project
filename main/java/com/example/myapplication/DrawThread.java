package ru.startandroid.myapplication01;

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
    int p11 = 500;
    int p21;
    int p31;
    int p41;
    int p51;
    int p61;
    int p71;
    int p81;
    int p12 = 500;
    int p22;
    int p32;
    int p42;
    int p52;
    int p62;
    int p72;
    int p82;
    boolean t1 = false;
    boolean t2 = false;
    boolean t3 = false;

    MainActivity proc;


    Paint paint = new Paint();

    public void color() {
        paint.setColor(Color.BLACK);
    }

    private SurfaceHolder surfaceHolder;

    private volatile boolean running = true;

    public DrawThread(Context context, SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        proc = (MainActivity) context;
    }

    public void requestStop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            Canvas canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                color();
                try {
                    t1 = proc.thread_change(1);
                    t2 = proc.thread_change(2);
                    t3 = proc.thread_change(3);
                    canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.MULTIPLY);
                    if (t1) {

                        p1 = proc.procent_findout_1(1);
                        p2 = proc.procent_findout_1(2);
                        p3 = proc.procent_findout_1(3);
                        p4 = proc.procent_findout_1(4);
                        p5 = proc.procent_findout_1(5);
                        p6 = proc.procent_findout_1(6);
                        p7 = proc.procent_findout_1(7);
                        p8 = proc.procent_findout_1(8);

                        canvas.drawLine(400, 500 - p1, 350, 500 - p2, paint);
                        canvas.drawLine(350, 500 - p2, 300, 500 - p3, paint);
                        canvas.drawLine(300, 500 - p3, 250, 500 - p4, paint);
                        canvas.drawLine(250, 500 - p4, 200, 500 - p5, paint);
                        canvas.drawLine(200, 500 - p5, 150, 500 - p6, paint);
                        canvas.drawLine(150, 500 - p6, 100, 500 - p7, paint);
                        canvas.drawLine(100, 500 - p7, 50, 500 - p8, paint);
                    }
                    else if (t2) {

                        p11 = proc.procent_findout_2(1);
                        p21 = proc.procent_findout_2(2);
                        p31 = proc.procent_findout_2(3);
                        p41 = proc.procent_findout_2(4);
                        p51 = proc.procent_findout_2(5);
                        p61 = proc.procent_findout_2(6);
                        p71 = proc.procent_findout_2(7);
                        p81 = proc.procent_findout_2(8);

                        canvas.drawLine(400, 500 - p11, 350, 500 - p21, paint);
                        canvas.drawLine(350, 500 - p21, 300, 500 - p31, paint);
                        canvas.drawLine(300, 500 - p31, 250, 500 - p41, paint);
                        canvas.drawLine(250, 500 - p41, 200, 500 - p51, paint);
                        canvas.drawLine(200, 500 - p51, 150, 500 - p61, paint);
                        canvas.drawLine(150, 500 - p61, 100, 500 - p71, paint);
                        canvas.drawLine(100, 500 - p71, 50, 500 - p81, paint);
                    }
                    else if (t3) {

                        p12 = proc.procent_findout_3(1);
                        p22 = proc.procent_findout_3(2);
                        p32 = proc.procent_findout_3(3);
                        p42 = proc.procent_findout_3(4);
                        p52 = proc.procent_findout_3(5);
                        p62 = proc.procent_findout_3(6);
                        p72 = proc.procent_findout_3(7);
                        p82 = proc.procent_findout_3(8);

                        canvas.drawLine(400, 500 - p12, 350, 500 - p22, paint);
                        canvas.drawLine(350, 500 - p22, 300, 500 - p32, paint);
                        canvas.drawLine(300, 500 - p32, 250, 500 - p42, paint);
                        canvas.drawLine(250, 500 - p42, 200, 500 - p52, paint);
                        canvas.drawLine(200, 500 - p52, 150, 500 - p62, paint);
                        canvas.drawLine(150, 500 - p62, 100, 500 - p72, paint);
                        canvas.drawLine(100, 500 - p72, 50, 500 - p82, paint);
                    }

                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}
