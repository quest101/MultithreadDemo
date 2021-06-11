package com.kang.util;

import java.util.HashMap;
import java.util.Hashtable;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("a","abc");
        hashMap.get("a");

        Hashtable hashtable = new Hashtable();
        hashtable.put("ab","abc");

        //HashMap<String,String> hashMap = new HashMap<String,String>();
        //hashMap.put("aaa","bbb");
    }
}
