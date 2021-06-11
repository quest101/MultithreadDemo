package com.ken.threadpool;

import java.util.concurrent.*;

public class ExecutorTest {
    public static void main(String[] args) {
//        Executor
//        ExecutorService
//        ScheduledExecutorService
//        ThreadPoolExecutor
//        IllegalArgumentException

        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.execute();
//        executorService.submit();

        ExecutorService threadPoolExecutor = Executors.newSingleThreadExecutor();

        ExecutorService threadPoolExecutor1 = Executors.newCachedThreadPool();
        ThreadPoolExecutor ThreadPoolExecutor2 =
                new ThreadPoolExecutor(5,10,
                        5,TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

    }
}
