package com.ken.designpattern;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatTest {
    public static void main(String[] args) {
        // 简单工厂模式
        DateFormat df = DateFormat.getDateInstance();
        String dateStr = df.format(new Date());
        System.out.println(dateStr);// 2021-5-10

        // a value from 0 to 3 indicating the time format
        // 0 2021年5月10日 星期一
        // 1 2021年5月10日
        // 2 2021-5-10
        // 3 21-5-10
        DateFormat df1 = DateFormat.getDateInstance(3);
        String dateStr1 = df1.format(new Date());
        System.out.println(dateStr1);

        DateFormat df2 = DateFormat.getDateInstance(1, Locale.CHINA);
        String dateStr2 = df2.format(new Date());
        System.out.println(dateStr2);
    }
}
