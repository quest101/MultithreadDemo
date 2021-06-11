package com.ken.multhread.thread;

public class JoinTest1 {
    public volatile static int i = 0;
    public static class AddThread extends Thread{
        public void run(){
            for(i=0;i<10000000;i++);
            System.out.println("AddThread run end");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread t = new AddThread();
        t.start();
        t.join();
        System.out.println("main run end i="+i);
    }
}
