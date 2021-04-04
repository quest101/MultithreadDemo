package com.ken.concurrent;

import java.util.HashMap;
import java.util.Hashtable;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("a","aaa");

        Hashtable hashtable = new Hashtable();
        hashtable.put("a","aaa");

        //HashMap<String,String> hashMap = new HashMap<String,String>();
        //hashMap.put("aaa","bbb");
    }
}
