package com.ken.concurrent.increment;

public class CASTest {
    public static void main(String[] args) {
        IncrementService incrementService = new IncrementService();
        for(int i=0;i<10000;i++){
            MyThread thread = new MyThread(incrementService);
            thread.start();
        }
    }
}
