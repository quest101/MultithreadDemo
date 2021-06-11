package com.ken.concurrent.increment;

public class MyThread extends  Thread{
    private IncrementService incrementService;
    public MyThread(IncrementService incrementService){
        super();
        this.incrementService = incrementService;
    }

    @Override
    public void run() {
        incrementService.increment();
    }
}
