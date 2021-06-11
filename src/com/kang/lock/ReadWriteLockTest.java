package com.kang.lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock =
                        new ReentrantReadWriteLock();
    private int value;

    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();

    static final CountDownLatch countDownlatch = new CountDownLatch(20);

    public Object handleRead(Lock lock) throws InterruptedException{
        try{
            lock.lock();
            //Thread.sleep(1000);
            countDownlatch.countDown();
            return value;
        }finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock,int index) throws InterruptedException {
        try {
            lock.lock();   // 模拟写操作
            //Thread.sleep(1000);
            value = index;
            countDownlatch.countDown();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        final ReadWriteLockTest readWriteLockTest = new ReadWriteLockTest();
        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
                try {
//                    readWriteLockTest.handleRead(readLock);
                    readWriteLockTest.handleRead(lock);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        Runnable writeRunnable = new Runnable() {
            @Override
            public void run() {
                try {
//                    readWriteLockTest.handleWrite(writeLock,new Random().nextInt());
                    readWriteLockTest.handleWrite(lock,new Random().nextInt());
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        long start = System.currentTimeMillis();
        for(int i=0;i<18;i++){
            Thread t = new Thread(readRunnable);
            //t.start();
            //t.join();
        }
        for(int i=18;i<20;i++){
            Thread t2 = new Thread(writeRunnable);
            //t2.start();
            //t2.join();
        }
        countDownlatch.await();
        long end = System.currentTimeMillis();
        System.out.println((end-start)/1000);

        System.out.println(new SimpleDateFormat("yyyy年MM月dd日hh：mm：ss E")
                .format(new Date(System.currentTimeMillis())).toString());

    }

}
