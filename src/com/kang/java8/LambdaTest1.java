package com.ken.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;

public class LambdaTest1 {

    public static void main(String[] args) {
        //�ɶ��ŷָ��Ĳ����б�->���ź��������
        Arrays.asList( "a", "b", "d" ).forEach(e -> System.out.println( e ) );

        //��ʾָ���ò�������
        Arrays.asList( "a","b", "c").forEach( (String e ) -> System.out.println( e ));

        //��Ҫ�����ӵ����飬�����ʹ�û����Ž���������������������Java�еĺ�����
        Arrays.asList( "a", "b", "d" ).forEach( e -> {
            System.out.print( e );
            System.out.print( e );
        } );

        //�������Ա�;ֲ�����
        String separator = ",";
        Arrays.asList( "a", "b", "d" ).forEach(
                ( String e ) -> System.out.print( e + separator ) );

        final String separator1 = ",";
        Arrays.asList( "a", "b", "d" ).forEach(
                ( String e ) -> System.out.print( e + separator1 ) );

        //�з���ֵ������ֵ������Ҳ�ɱ���������ó�
        //test();

        String[] planets = new String[] {"Mercury","Venus","Eartg","Mars",
                "Jupiter","Saturn","Uranus","Neptune"};
        // lamda���ʽ ת ����ʽ�ӿ�
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

        //Arrays.sort (comp��String: : conpareToIgnoreCase);

    }

    public static void test(){
        //List<String> strings =
        Arrays.asList( "c", "d", "f" ).sort( (e1, e2 ) -> e1.compareTo( e2 ) );
        //System.out.println("�б�: " +strings);
        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> {
            int result = e1.compareTo( e2 );
            return result;
        } );
    }
}
