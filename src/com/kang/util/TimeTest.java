package com.kang.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {
    public static void main(String[] args) {
        //获得自1970-1-01 00:00:00.000 到当前时刻的时间距离,类型为long
        long time = System.currentTimeMillis();
        System.out.println(time);//
        System.out.println(time / 1000);

        Date nowTime = new Date(time);
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String retStrFormatNowDate = sdFormatter.format(nowTime);
        System.out.println(retStrFormatNowDate);
    }
}
