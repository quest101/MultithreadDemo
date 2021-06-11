package com.kang.concurrent.increment;

public class IncrementService {
    //private AtomicInteger atomic = new AtomicInteger();
    private Integer i = new Integer(0);

    public void increment(){
        //System.out.println(atomic.incrementAndGet());
        System.out.println(i++);
    }

}
