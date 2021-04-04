package com.ken.nio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5,10,100,
                TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));

        Future<String> future = executor.submit(new MyCallable());

        try{
            System.out.println(future.get());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            executor.shutdown();
        }


    }
}
