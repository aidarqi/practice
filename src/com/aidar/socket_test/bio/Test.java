package com.aidar.socket_test.bio;

import java.io.IOException;

/**
 * @desc
 * @date 17-8-7
 */
public class Test {
    static int i = 0;
    public static void main(String[] args) throws InterruptedException{
        new Thread(new Runnable() {
            @Override public void run() {
                try {
                    BioServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(100);

        new Thread(new Runnable() {
            @Override public void run() {
                while (true) {
                    String expression = "hello" + i++;
                    BioClient.send(expression);
                }
            }
        }).start();
    }
}
