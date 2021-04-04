package com.ken.concurrent;

public class MsLunch {
    private int c1 = 0;
    private long c2 = 0;
    //private Integer c3 = new Integer(0);
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void inc1() {
        //synchronized(lock1) {
            //c1++;
        //}
        System.out.println("inc1="+(c1++));
    }

    public void inc2() {
        //synchronized(lock2) {
            c2++;
        //}
        System.out.println("inc2="+c2);
    }
}
