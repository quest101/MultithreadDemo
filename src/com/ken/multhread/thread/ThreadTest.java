package com.ken.multhread.thread;

public class ThreadTest {
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();

        Thread t = new Thread(){
            public void run(){
                System.out.println("thread run...");
            }
        };
        t.start();
//        t.run();
    }
}
