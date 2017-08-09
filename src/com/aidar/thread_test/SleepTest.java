package com.aidar.thread_test;

import java.io.IOException;

/**
 * @desc sleep方法不会释放锁，也就是说如果当前线程持有对某个对象的锁，则即使调用sleep方法，其他线程也无法访问这个对象
 * @date 17-7-10
 */
public class SleepTest {
    private int i = 10;
    private Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        long beginTime=System.currentTimeMillis();
        SleepTest test = new SleepTest();
        MyThread thread1 = test.new MyThread();
        System.out.println(thread1.isAlive());
        MyThread thread2 = test.new MyThread();
        thread1.start();
        System.out.println(thread1.isAlive());
        thread2.start();
//        Thread.sleep(30000);
        System.out.println(Thread.currentThread().getName());
        System.out.println(thread1.isAlive());
        long endTime=System.currentTimeMillis();
        System.out.println("＊＊＊＊＊＊＊＊＊main线程用时："+(endTime-beginTime)+" 毫秒！");
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            long beginTime=System.currentTimeMillis();
            System.out.println("#####################i:"+i + ",进入run方法的当前线程为"+Thread.currentThread().getName());
            synchronized (object) {
                i++;
                System.out.println("i:"+i + ",线程"+Thread.currentThread().getName());
                try {
                    System.out.println("线程"+Thread.currentThread().getName()+"进入睡眠状态");
//                    Thread.currentThread().sleep(10000);
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    // TODO: handle exception
                }
                System.out.println("%%%%%%%%%%%%%%%%%线程"+Thread.currentThread().getName()+"睡眠结束");
                System.out.println("i:"+i);
            }
            long endTime=System.currentTimeMillis();
            System.out.println("用时："+(endTime-beginTime)+" 毫秒！");
        }
    }

}
