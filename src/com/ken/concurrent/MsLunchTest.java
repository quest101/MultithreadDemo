package com.ken.concurrent;

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
