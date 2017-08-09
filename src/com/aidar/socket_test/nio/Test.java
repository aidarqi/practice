package com.aidar.socket_test.nio;

import com.aidar.socket_test.bio.BioClient;
import com.aidar.socket_test.bio.BioServer;

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
                    NioServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(100);

//
        new Thread(new Runnable() {
            @Override public void run() {
                try {
                    NioClient.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(100);

        new Thread(new Runnable() {
            @Override public void run() {
                while (true) {
                    String expression = "hello" + i++;
                    try {
                        NioClient.sendMsg(expression);
                        Thread.currentThread().sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
