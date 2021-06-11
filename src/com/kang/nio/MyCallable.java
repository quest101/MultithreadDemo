package com.ken.nio;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        try {
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "exception";
        }

    }
}
