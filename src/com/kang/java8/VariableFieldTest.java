package com.kang.java8;

public class VariableFieldTest {
    final static String salutation = "Hello!";

    public static void main(String args[]){
        GreetingService greetService1 = message ->
                System.out.println(salutation + message);
        greetService1.sayMessage("Runoob");

        /*final int num = 1;
        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        s.convert(2);  // 输出结果为 3*/
        int num = 1;
        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        s.convert(2);
        //num = 5;
    }

    interface GreetingService {
        void sayMessage(String message);
    }
}
