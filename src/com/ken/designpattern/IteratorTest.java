package com.ken.designpattern;

import java.util.*;

public class IteratorTest {

    public static void main(String[] args) {
        // 工厂方法模式

        // ArrayList.iterator方法， 返回Itr对象,实现Iterator接口
        // Itr implements Iterator<E>
        String listArr[] = new String[]{"A", "B", "C"};
        ArrayList list = new ArrayList(Arrays.asList(listArr));
        System.out.println("原序列中的元素：" + list.toString());
        //Itr tr = list.iterator();
        //Iterator ite = list.iterator();

        ListIterator iterator  = list.listIterator();
        iterator.add("a");
        System.out.println("在List序列的首个元素前添加元素：" + list.toString());
        iterator  = list.listIterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());

        System.out.println("------------------------------------------------------------");

        // AbstractSequentialList.iterator方法，返回ListItr对象，实现Iterator接口
        // ListItr extends Itr implements ListIterator<E>
        List linkedList = new LinkedList();
        ListIterator listIterator = linkedList.listIterator();
        listIterator.add("b");
        listIterator = linkedList.listIterator();
        while(listIterator.hasNext())
            System.out.println(listIterator.next());
    }
}
