package com.kang.designpattern;

import java.util.*;

public class IteratorTest {

    public static void main(String[] args) {
        // ��������ģʽ

        // ArrayList.iterator������ ����Itr����,ʵ��Iterator�ӿ�
        // Itr implements Iterator<E>
        String listArr[] = new String[]{"A", "B", "C"};
        ArrayList list = new ArrayList(Arrays.asList(listArr));
        System.out.println("ԭ�����е�Ԫ�أ�" + list.toString());
        //Itr tr = list.iterator();
        //Iterator ite = list.iterator();

        ListIterator iterator  = list.listIterator();
        iterator.add("a");
        System.out.println("��List���е��׸�Ԫ��ǰ���Ԫ�أ�" + list.toString());
        iterator  = list.listIterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());

        System.out.println("------------------------------------------------------------");

        // AbstractSequentialList.iterator����������ListItr����ʵ��Iterator�ӿ�
        // ListItr extends Itr implements ListIterator<E>
        List linkedList = new LinkedList();
        ListIterator listIterator = linkedList.listIterator();
        listIterator.add("b");
        listIterator = linkedList.listIterator();
        while(listIterator.hasNext())
            System.out.println(listIterator.next());
    }
}
