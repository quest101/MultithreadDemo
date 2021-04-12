package com.ken.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class LambdaTest1 {

    public static void main(String[] args) {
        //由逗号分隔的参数列表、->符号和语句块组成
        Arrays.asList( "a", "b", "d" ).forEach(e -> System.out.println( e ) );

        //显示指定该参数类型
        Arrays.asList( "a","b", "c").forEach( (String e ) -> System.out.println( e ));

        //需要更复杂的语句块，则可以使用花括号将该语句块括起来，类似于Java中的函数体
        Arrays.asList( "a", "b", "d" ).forEach( e -> {
            System.out.print( e );
            System.out.print( e );
        } );

        //引用类成员和局部变量
        String separator = ",";
        Arrays.asList( "a", "b", "d" ).forEach(
                ( String e ) -> System.out.print( e + separator ) );

        final String separator1 = ",";
        Arrays.asList( "a", "b", "d" ).forEach(
                ( String e ) -> System.out.print( e + separator1 ) );

        //有返回值，返回值的类型也由编译器推理得出
        //test();

        String[] planets = new String[] {"Mercury","Venus","Eartg","Mars",
                "Jupiter","Saturn","Uranus","Neptune"};
        // lamda表达式 转 函数式接口
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        //java.util.function
        BiFunction<String, String, Integer> comp
                = (first, second) -> first.length() - second.length();

        //Predicate predicate;
        ArrayList list = new ArrayList();
        list.add(null);
        //list.removelf(e -> e == null);

        //Timer t = new Timer(1000,System.out::println);

        //Arrays.sort (comp，String: : conpareToIgnoreCase);

    }

    public static void test(){
        //List<String> strings =
        Arrays.asList( "c", "d", "f" ).sort( (e1, e2 ) -> e1.compareTo( e2 ) );
        //System.out.println("列表: " +strings);
        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> {
            int result = e1.compareTo( e2 );
            return result;
        } );
    }
}
