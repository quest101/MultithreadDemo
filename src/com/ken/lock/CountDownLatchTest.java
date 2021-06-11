package com.ken.lock;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest implements  Runnable{

    static final CountDownLatch countDownlatch = new CountDownLatch(10);
    static final CountDownLatchTest countDownlatchTest = new CountDownLatchTest();

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10)*1000);
            System.out.println("check complete");
            countDownlatch.countDown();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws  InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++)
            executorService.submit(countDownlatchTest);
         //等待检查
        countDownlatch.await();
        System.out.println("Fire!");
        executorService.shutdown();
    }
}
