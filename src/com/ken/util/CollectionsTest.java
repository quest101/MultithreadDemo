package com.ken.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionsTest {
    public static void main(String[] args) throws InterruptedException{

        HashMap hashMap = new HashMap();

        Map synchronizedMap = Collections.synchronizedMap(hashMap);

        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        list.add("abc");

        ArrayBlockingQueue  blockingQueue = new ArrayBlockingQueue(5);
        blockingQueue.put("aaa");
        blockingQueue.add("aaa");
        blockingQueue.take();


    }
}
