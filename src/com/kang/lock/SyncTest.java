package com.kang.lock;

public class SyncTest implements Runnable {
    static SyncTest obj = new SyncTest();
    static int i = 0;
    public synchronized void increase(){
        i++;
    }
    public void run(){
        for(int j=0;j<100000;j++){
           /* synchronized (obj){
                i++;
            }*/
            increase();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(obj);
        Thread t2 = new Thread(obj);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
