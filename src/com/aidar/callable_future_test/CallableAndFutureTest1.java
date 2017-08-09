package com.aidar.callable_future_test;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @desc
 * @date 17-7-11
 */
public class CallableAndFutureTest1 {
    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        };
        //FutureTask实现了两个接口，Runnable和Future，所以它既可以作为Runnable被线程执行，又可以作为Future得到Callable的返回值
        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        new Thread(future).start();
        try {
            Thread.sleep(5000);
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
