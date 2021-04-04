package com.ken.concurrent;

import com.ken.multhread.day02.example2.HasSelfPrivateNum;

public class MsLunchService extends  Thread{

    private MsLunch msLunch;

    public MsLunchService(MsLunch msLunch){
        super();
        this.msLunch = msLunch;
    }
    public void run(){
        super.run();;
        msLunch.inc1();
        //msLunch.inc2();
    }
}
