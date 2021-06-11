package com.kang.multhread.reentrantlocktest.example2;

public class MyThreadBB extends Thread{
    private  MyService myService;
    public MyThreadBB(MyService myService){
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.methodB();
    }
}
