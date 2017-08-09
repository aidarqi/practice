package com.aidar.thread_test;

/**
 * @desc
 * @date 17-7-10
 */
class MyRunnable implements Runnable {
    public MyRunnable() {
    }

    @Override public void run() {
        System.out.println("线程名为：" + Thread.currentThread().getName() + ",线程ID：" + Thread.currentThread().getId()+
            ",SecurityManager" + System.getSecurityManager());
    }
}