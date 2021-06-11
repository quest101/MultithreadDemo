package com.ken.java8;

import java.util.Arrays;

public class LambdaTest2 {
    public static void main(String[] args) {
        /*() -> {
            for(int i=1;i<10;i++)
                System.out.println("123");
        }*/
        //函数式方法
        String[] strs = new String[]{"cd","afd","bdd"};
        Arrays.sort(strs, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(strs));

        Arrays.asList( "a", "b", "d" ).forEach( e -> System.out.println( e ) );

        //Predicate
        //方法引用
//        Time time = new Time(1000, event -> System.out.println(event));
//        Time time1 = new Time(1000,System.out::println);
    }
}
