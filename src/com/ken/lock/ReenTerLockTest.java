package com.ken.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReenTerLockTest implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    public void run(){
        for(int j=0;j<10000000;j++){
            try{
                lock.lock();
                i++;
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ReenTerLockTest lockTest = new ReenTerLockTest();
        Thread t1 = new Thread(lockTest);
        Thread t2 = new Thread(lockTest);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("i="+i);
    }
}
