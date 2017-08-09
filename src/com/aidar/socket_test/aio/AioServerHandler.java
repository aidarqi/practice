package com.aidar.socket_test.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * @desc
 * @date 17-8-8
 */
public class AioServerHandler implements Runnable{
    public CountDownLatch latch;
    public AsynchronousServerSocketChannel channel;
    public AioServerHandler(int port) {
        try {
            channel = AsynchronousServerSocketChannel.open();
            channel.bind(new InetSocketAddress(port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override public void run() {
        latch = new CountDownLatch(1);
        channel.accept(this, new AioServerAcceptHandler());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
