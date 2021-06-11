package com.kang.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {
    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);

        ses.schedule(new Runnable() {
        //ses.scheduleWithFixedDelay(new Runnable() {
        //ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
//                try {
                    //Thread.sleep(5000);
                    System.out.println(System.currentTimeMillis()/1000);
              /*  } catch (InterruptedException e){
                    e.printStackTrace();
                }*/
            }
        },2, TimeUnit.SECONDS);
    }
}
