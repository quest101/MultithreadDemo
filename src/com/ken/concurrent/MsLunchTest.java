package com.ken.concurrent;

import com.ken.concurrent.increment.IncrementService;
import com.ken.concurrent.increment.MyThread;
import com.ken.multhread.day02.example1.HasSelfPrivateNum;
import com.ken.multhread.day02.example1.ThreadA;
import com.ken.multhread.day02.example1.ThreadB;

public class MsLunchTest {
    public static void main(String[] args) {

        MsLunch msLunch = new MsLunch();
        for(int i=0;i<10000;i++){
            MsLunchService thread = new MsLunchService(msLunch);
            thread.start();
        }

        /*MsLunch msLunch = new MsLunch();
        MsLunchService threadA = new MsLunchService(msLunch);
        threadA.start();
        MsLunchService threadB = new MsLunchService(msLunch);
        threadB.start();*/

        //System.out.println(msLunch.inc1());
        //System.out.println(msLunch.inc1());

    }
}
