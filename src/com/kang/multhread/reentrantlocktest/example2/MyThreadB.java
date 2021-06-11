package com.kang.multhread.reentrantlocktest.example2;

public class MyThreadB extends Thread{
    private  MyService myService;
    public MyThreadB(MyService myService){
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.methodB();
    }
}
