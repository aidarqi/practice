package com.aidar.collection_test;

import java.util.*;

/**
 * @desc
 * @date 17-6-19
 */
public class CollectionTest {
    public static void main(String[] args) {

        CollectionTest collectionTest = new CollectionTest();
        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        System.out.println(collection);
        collectionTest.display(collection);
        Integer[] moreInts = {6,7,8,9,10};
        //只能接受一个Collection对象作为参数
        System.out.println(Arrays.asList(moreInts));
        collection.addAll(Arrays.asList(moreInts));
        collectionTest.display(collection);
        //可变参数列表
        Collections.addAll(collection,11,12,13,14,15);
        collectionTest.display(collection);

        Collections.addAll(collection, moreInts);
        collectionTest.display(collection);
        //虽然将数组转为list输出,但其底层表示仍是数组,因此不能使用add()或delete()方法
//        Arrays.asList(moreInts).add(11);


    }

    public void display(Collection<Integer> collection){
        for (Integer c:collection){
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
