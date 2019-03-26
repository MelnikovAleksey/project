package com.example.student4.myapplication;


class Birzha_Thread extends Thread {
    int vznos = 60;
    int procent = 1;
    public Birzha_Thread(String name){
        super(name);
    }
    public int getID(){
        return vznos;
    }
    @Override
    public void run(){
        while(true) {
            try {
                vznos += 60;
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
