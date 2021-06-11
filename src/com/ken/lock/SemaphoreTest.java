package com.ken.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest implements Runnable{

    private final Semaphore semaphore = new Semaphore(2);

    public void run(){

        try{
            semaphore.acquire();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getId()+":done!");
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        final SemaphoreTest semaphoreTest = new SemaphoreTest();
        for(int i=0;i<20;i++){
            exec.submit(semaphoreTest);
        }
    }

}
