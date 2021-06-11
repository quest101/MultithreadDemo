package com.kang.multhread.reentrantlocktest.example2;

public class MyThreadAA extends Thread{
    private  MyService myService;
    public MyThreadAA(MyService myService){
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.methodA();
    }
}
