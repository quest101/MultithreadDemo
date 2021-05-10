package com.ken.designpattern;

import java.util.Random;

public class StaticCounter {
    private static final long initial = Math.abs(new Random().nextLong() / 2);
    private static long count = initial;
    private StaticCounter(){}
    private static synchronized long next(){
        return count++;
    }
    private static synchronized void reset(){
        count = initial;
    }

    public static void main(String[] args) {
        for(int i = 0;i < 1000;i++){
            new Thread(){
                public void run() {
                    long c = StaticCounter.next();
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
