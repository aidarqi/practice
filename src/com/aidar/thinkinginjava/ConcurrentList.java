package com.aidar.thinkinginjava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @desc
 * @date 17-6-19
 */
public class ConcurrentList {
    private static List<String> TEST_LIST = Collections.synchronizedList(new ArrayList<String>());

    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override public void run() {
                while(true){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (TEST_LIST){
                        TEST_LIST.add("11");
                    }
                    System.out.println("Thread1 running");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override public void run() {
                while (true){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (TEST_LIST){
                        for (String at : TEST_LIST){
                            TEST_LIST.add("22");
                        }
                    }
                    System.out.println("Thread2 running");
                }
            }
        }).start();
    }
}
