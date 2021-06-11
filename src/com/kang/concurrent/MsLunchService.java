package com.kang.concurrent;

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
