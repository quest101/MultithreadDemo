package com.kang.concurrent.lock.aqs;

import java.util.concurrent.CountDownLatch;

public class CountDownTest {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        System.out.println(Thread.currentThread().getName()+"\t");
        System.out.println("before latch.await()...");

        for(int i=1; i<=3; i++){
            new Thread("thread"+i){

                @Override
                public void run() {
                    System.out.println("enter Thread"+  getName() + "\t");
                    System.out.println("execute countdown \t");
                    countDownLatch.countDown();
                    System.out.println("exit Thread"+ getName() +"\t");
                }
            }.start();
        }
        countDownLatch.await();

        System.out.println("in " + Thread.currentThread().getName() +"\t");
        System.out.println("after latch.await()...");
    }
}
