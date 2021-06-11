package com.kang.multhread.reentrantlocktest.example1;

public class Run {
    public static void main(String[] args) {
        MyService myService = new MyService();
        /*for(int i=0;i<5;i++){
            MyThread myThread = new MyThread(myService);
            myThread.start();
        }*/
        MyThread myThread1 = new MyThread(myService);
        MyThread myThread2 = new MyThread(myService);
        MyThread myThread3 = new MyThread(myService);
        MyThread myThread4 = new MyThread(myService);
        MyThread myThread5 = new MyThread(myService);
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        myThread5.start();
    }
}
