package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    boolean thr1 = false;
    boolean thr2 = false;
    boolean thr3 = false;
    int vznos;
    int money = 100000;
    int proc_1 = 1;
    int proc_2 = 1;
    int proc_3 = 1;
    int proc_4 = 1;
    int proc_5 = 1;
    int proc_6 = 1;
    int proc_7 = 1;
    int proc_8 = 1;
    int proc_1_2 = 1;
    int proc_2_2 = 1;
    int proc_3_2 = 1;
    int proc_4_2 = 1;
    int proc_5_2 = 1;
    int proc_6_2 = 1;
    int proc_7_2 = 1;
    int proc_8_2 = 1;
    int kurs = 100;
    int kurs_2 = 100;
    Object lock = new Object();
    public void MainActivity(){

    }

    public boolean thread_change(int num){
            if (num == 1){
                return thr1;
            }
        else if (num == 2){
            return thr2;
        }
        else if (num == 3){
            return thr3;
        }
        else{
            return false;
            }
    }

    public void change_thread_1(){
        thr1 = true;
        thr2 = false;
        thr3 = false;
    }

    public void change_thread_2(){
        thr1 = false;
        thr2 = true;
        thr3 = false;
    }

    public void change_thread_3(){
        thr1 = false;
        thr2 = false;
        thr3 = true;
    }

    public int procent_findout(int pr){

        synchronized (lock) {
            if (pr == 1) {
                return proc_1;
            } else if (pr == 2) {
                return proc_2;
            } else if (pr == 3) {
                return proc_3;
            } else if (pr == 4) {
                return proc_4;
            } else if (pr == 5) {
                return proc_5;
            } else if (pr == 6) {
                return proc_6;
            } else if (pr == 7) {
                return proc_7;
            } else if (pr == 8) {
                return proc_8;
            } else {
                return 0;
            }
        }
    }

    public int procent_findout_1(int pr){

        synchronized (lock) {
            if (pr == 1) {
                return proc_1_2;
            } else if (pr == 2) {
                return proc_2_2;
            } else if (pr == 3) {
                return proc_3_2;
            } else if (pr == 4) {
                return proc_4_2;
            } else if (pr == 5) {
                return proc_5_2;
            } else if (pr == 6) {
                return proc_6_2;
            } else if (pr == 7) {
                return proc_7_2;
            } else if (pr == 8) {
                return proc_8_2;
            } else {
                return 0;
            }
        }
    }

    public int money_amount(int dengivbirzhe){
        money = money - kurs*dengivbirzhe;
        return money;
    }
    public int vnesti(int mon){
        this.vznos = mon/kurs;
        return vznos;
    }
    public int vivesti(int mon){
        if(mon>vznos){
            int vivod = vznos*kurs;
            vznos = 0;
            money += vivod;
            return vivod;

        }
        else {
            int vivod = mon*kurs;
            vznos = vznos - mon;
            money += vivod;
            return vivod;
        }
    }
    public int vznos(){
        return vznos;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.textView);
        final EditText editText2 = findViewById(R.id.editText2);
        final TextView textView2 = findViewById(R.id.textView2);
        final TextView textView4 = findViewById(R.id.textView4);
        final TextView textView5 = findViewById(R.id.textView5);
        Thread thread1 = new Thread() {
            @SuppressLint("WrongCall")
            public void run() {
                while (true) {
                    Random random_procent = new Random();
                    synchronized (lock) {
                        proc_8 = proc_7;
                        proc_7 = proc_6;
                        proc_6 = proc_5;
                        proc_5 = proc_4;
                        proc_4 = proc_3;
                        proc_3 = proc_2;
                        proc_2 = proc_1;
                        proc_1 = random_procent.nextInt(100);
                    }
                    if (thr1) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                textView5.setText("Процент курса: " + Integer.toString(proc_1));
                            }
                        });
                    }
                    kurs *= proc_1;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView2.setText(Integer.toString(kurs));
                        }
                    });
                    try {
                        Thread.sleep(5000);


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        Thread thread2 = new Thread() {
            @SuppressLint("WrongCall")
            public void run() {
                while (true) {
                    Random random_procent = new Random();
                    synchronized (lock) {
                        proc_8_2 = proc_7_2;
                        proc_7_2 = proc_6_2;
                        proc_6_2 = proc_5_2;
                        proc_5_2 = proc_4_2;
                        proc_4_2 = proc_3_2;
                        proc_3_2 = proc_2_2;
                        proc_2_2 = proc_1_2;
                        proc_1_2 = random_procent.nextInt(100);
                    }
                    if (thr2) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                textView5.setText("Процент курса: " + Integer.toString(proc_1));
                            }
                        });
                    }
                    kurs_2 *= proc_1_2;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView2.setText(Integer.toString(kurs));
                        }
                    });
                    try {
                        Thread.sleep(5000);


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        thread1.start();
        thread2.start();

        Button button_vn = (Button) findViewById(R.id.Button_Vnesti);
        Button button_vi = (Button) findViewById(R.id.Button_Vivesti);
        Button buttonB1 = (Button) findViewById(R.id.buttonB1);
        Button buttonB2 = (Button) findViewById(R.id.buttonB2);
        Button buttonB3 = (Button) findViewById(R.id.buttonB3);

        buttonB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change_thread_1();
            }
        });

        buttonB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change_thread_2();
            }
        });

        buttonB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change_thread_3();
            }
        });

        button_vn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String edit = editText2.getText().toString();
                int dengivbirzhe = vnesti(Integer.parseInt(edit));
                textView4.setText("Валюта в бирже: " + dengivbirzhe);
                int dengi = money_amount(dengivbirzhe);
                textView.setText("Твои деньги:  " + dengi);
            }
        });

        button_vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String edit = editText2.getText().toString();
                int dengivbirzhe = vivesti(Integer.parseInt(edit));
                textView.setText("Твои деньги     " + dengivbirzhe);
                dengivbirzhe = vznos();
                textView4.setText("Валюта в бирже: " + dengivbirzhe);
            }
        });

    }
}
