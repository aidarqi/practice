package com.aidar.collection_test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @desc Map
 * @date 17-5-22
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("map1","map1");
        map.put("map2","map2");
        map.put("map1","map11");
        map.put("map1","map111");

        /**
         * 在for-each循环中使用entries来遍历
         */
        System.out.println("第一种遍历方式");
        for (Map.Entry<String,String> entry:map.entrySet()){
            System.out.println("key= " + entry.getKey() + ", Value= " + entry.getValue());
        }

        /**
         * 在for-each循环中遍历keys或values
         */
        System.out.println("第一种遍历方式");
        for(String key : map.keySet()){
            System.out.println("key= " + key);
        }
        for (String value : map.values()){
            System.out.println("Value= " + value);
        }

        /**
         * 使用Iterator遍历,使用泛型
         */
        System.out.println("第三种遍历方式");
        Iterator<Map.Entry<String,String>> entries = map.entrySet().iterator();
        while(entries.hasNext()){
            Map.Entry<String,String> entry = entries.next();
            System.out.println("key= " + entry.getKey() + ",Value= " + entry.getValue());
        }

        /**
         * 使用Iterator遍历,不使用泛型
         */
        System.out.println("第四种遍历方式");
        Iterator entries1 = map.entrySet().iterator();
        while(entries1.hasNext()){
            Map.Entry entry = (Map.Entry)entries1.next();
            String key = (String)entry.getKey();
            String value = (String)entry.getValue();
            System.out.println("key= " + key + ",Value= " + value);
        }
    }
}
