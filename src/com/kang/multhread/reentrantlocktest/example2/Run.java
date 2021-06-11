package com.kang.multhread.reentrantlocktest.example2;


public class Run {
    public static void main(String[] args) {
        MyService myService = new MyService();
        MyThreadA myThreadA = new MyThreadA(myService);
        myThreadA.setName("A");
        myThreadA.start();
        MyThreadAA myThreadAA = new MyThreadAA(myService);
        myThreadAA.setName("AA");
        myThreadAA.start();
        MyThreadB myThreadB = new MyThreadB(myService);
        myThreadB.setName("B");
        myThreadB.start();
        MyThreadBB myThreadBB = new MyThreadBB(myService);
        myThreadBB.setName("BB");
        myThreadBB.start();
    }
}
