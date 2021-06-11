package com.ken.multhread.thread;

public class VolatileTest implements Runnable{
    static volatile int i = 0;
    public void run(){
        for(int k=0;k<10000;k++){
            i++;
            //System.out.println(i++);
        }

    }

    public static void main(String[] args) throws InterruptedException{
        Thread[] threads = new Thread[10];
        for(int i =0;i<10;i++){
            threads[i] = new Thread(new VolatileTest());
            threads[i].start();
            //t.join();
        }
        for(int j=0;j<10;j++)
            threads[j].join();

        System.out.println("i="+i);
    }
}
