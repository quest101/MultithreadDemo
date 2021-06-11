package com.kang.multhread.reentrantlocktest.example2;

import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    public void methodA(){
        try {
            lock.lock();
            System.out.println("methodA begin ThreadName="
                    +Thread.currentThread().getName()
                    +" time="+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodA begin ThreadName="
                    +Thread.currentThread().getName()
                    +" time="+System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void methodB(){
        try {
            lock.lock();
            System.out.println("methodB begin ThreadName="
                    +Thread.currentThread().getName()
                    +" time="+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodB begin ThreadName="
                    +Thread.currentThread().getName()
                    +" time="+System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
