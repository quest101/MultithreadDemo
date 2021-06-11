package com.kang.multhread.reentrantlocktest.example1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock = new ReentrantLock();
    public void testMethod(){
        lock.lock();
        try {
            for(int i=0; i < 5; i++){
                System.out.println("ThreadName="
                        +Thread.currentThread().getName()+(" "+(i+1)));
            }
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();;
        }

        lock.unlock();
    }
}
