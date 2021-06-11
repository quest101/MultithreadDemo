package com.ken.designpattern;

import java.util.Random;

public class LazySingletonCounter {
    private final long initial;
    private long count;

    private LazySingletonCounter(){
        initial = Math.abs(new Random().nextLong() / 2);
        count = initial;
    }

    private static LazySingletonCounter s = null;
    private static final  Object classLock =
                                LazySingletonCounter.class;
    public static LazySingletonCounter instance(){
        synchronized (classLock){
            if(s == null)
                s = new LazySingletonCounter();
            return s;
        }
    }

    public long next(){
        synchronized (classLock){
            return count++;
        }
    }

    public void reset(){
        synchronized (classLock){
            count = initial;
        }
    }

    public static void main(String[] args) {
        LazySingletonCounter counter = LazySingletonCounter.instance();
        //counter.count=369567736811738041l;
        //counter.reset();
        for(int i = 0;i < 1000;i++){
            new Thread(){
                public void run() {
                    long c = counter.next();
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(
                            Thread.currentThread().getName()+" count:"+c);
                }
            }.start();
        }
    }
}
