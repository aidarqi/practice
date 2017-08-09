package com.aidar.thread_test;

/**
 * @desc 直接继承Thread类的话，可能比实现Runnable接口看起来更加简洁，但是由于Java只允许单继承，所以如果自定义类需要继承其他类，则只能选择实现Runnable接口
 *       虽然thread1的start方法调用在thread2的run方法前面调用，但是先输出的是thread2的run方法调用的相关信息，
 *       说明新线程创建的过程不会阻塞主线程的后续执行
 * @date 17-7-10
 */
public class Test {
    public static void main(String[] args)  {
        System.out.println("主线程ID："+Thread.currentThread().getId());
        MyThread thread = new MyThread();
        //通过start()方法去启动线程
        thread.start();
        //run方法中只是定义需要执行的任务，如果调用run方法，即相当于在主线程中执行run方法，跟普通的方法调用没有任何区别，
        // 此时并不会创建一个新的线程来执行定义的任务
        thread.run();
        MyThread thread1 = new MyThread("thread1");
        thread1.start();
        MyThread thread2 = new MyThread("thread2");
        thread2.run();

        MyRunnable runnable = new MyRunnable();
        Thread thread3 = new Thread(runnable);
        thread3.start();
    }
}
