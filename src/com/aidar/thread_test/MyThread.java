package com.aidar.thread_test;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc
 * @date 17-7-10
 */
class MyThread extends Thread{
    private static int num = 0;
    private String name;

    public MyThread(String name){
        this.name = name;
    }
    public MyThread(){
        num++;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1; i++) {
            System.out.println("执行第" + i + "次,主动创建的第" + num + "个线程,线程名为：" + Thread.currentThread().getName() +
                ",自定义线程名：" + name + ", 线程ID：" + Thread.currentThread().getId() + ",SecurityManager" + System.getSecurityManager());
        }
    }
}