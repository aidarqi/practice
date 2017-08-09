package com.aidar.collection_test;

import java.util.HashSet;
import java.util.Set;

/**
 * @desc
 * @date 17-5-5
 */
public class SetTest {

//    private static ThreadLocal<Integer> segNum = new ThreadLocal<Integer>(){
//        public Integer initialValue(){
//            return 0;
//        }
//    };
//
//    public int getNextNum(){
//        segNum.set(segNum.get() + 1);
//        return segNum.get();
//    }

    public static void main(String[] args) throws InterruptedException {
        Set set = new HashSet();

        TestClient t1 = new TestClient(set);
        TestClient t2 = new TestClient(set);
//        TestClient t3 = new TestClient(sn);
        t1.start();
        t2.start();
//        t3.start();
        Thread.sleep(100);
        System.out.println("set长度： " + set.size());
        System.out.println("set集合： " + set);
    }

    private static class TestClient extends Thread {
        private Set sn;
        public TestClient(Set set){
            this.sn = set;
        }

        public void run(){
            for (int i=0; i < 100; i++){
                sn.add(i);
                System.out.println("thread[" + Thread.currentThread().getName() + "]sn[" + i + "]");
            }
        }
    }
}
