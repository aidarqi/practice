package com.aidar.thinkinginjava;

import java.util.*;

/**
 * @desc 容器的打印
 * @date 17-6-19
 */
public class PrintingCobtainers {
    static Collection fill(Collection<String> collection){
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        collection.add("cet");
        return collection;
    }

    static Map fill(Map<String,String> map){
        map.put("rat", "Fuzzy");
        map.put("cat", "Rags");
        map.put("dog", "Bosco");
        map.put("dog", "Spot");
        return map;
    }

    public static void main(String[] args) {
        System.out.println(fill(new ArrayList<String>()));
        System.out.println(fill(new LinkedList<String>()));
        System.out.println(fill(new HashSet<String>()));
        System.out.println(fill(new TreeSet<String>()));
        System.out.println(fill(new LinkedHashSet<String>()));
        System.out.println(fill(new HashMap<String, String>()));
        System.out.println(fill(new TreeMap<String, String>()));
        System.out.println(fill(new LinkedHashMap<String, String>()));

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        System.out.println(list);
        System.out.println(list.indexOf(1));

        Map<Integer,Object> map = new HashMap<>();
        map.put(1, "hello");
        map.put(2, "world");
        System.out.println(map);

    }
}
