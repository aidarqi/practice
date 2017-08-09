package com.aidar.callable_future_test;

import java.util.concurrent.*;

/**
 * @desc
 * @date 17-7-11
 */
public class CallableAndFutureTest2 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(threadPool);
        for(int i = 1; i < 5; i++){
            final int taskID = i;
            cs.submit(new Callable<Integer>() {
                @Override public Integer call() throws Exception {
                    return taskID;
                }
            });
        }
        for(int i = 1; i < 5; i++) {
            try {
                System.out.println(cs.take().get());
                System.out.println("cs.poll: " +cs.poll().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
