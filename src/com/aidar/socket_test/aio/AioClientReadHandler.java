package com.aidar.socket_test.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * @desc
 * @date 17-8-8
 */
public class AioClientReadHandler implements CompletionHandler<Integer, ByteBuffer> {
    private AsynchronousSocketChannel channel;
    private CountDownLatch latch;
    public AioClientReadHandler(AsynchronousSocketChannel channel, CountDownLatch latch) {
        this.channel = channel;
        this.latch = latch;
    }
    @Override public void completed(Integer result, ByteBuffer buffer) {
        buffer.flip();
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        String body;
        try {
            body = new String(bytes, "utf-8");
            System.out.println("客户端收到结果: " + body);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override public void failed(Throwable exc, ByteBuffer attachment) {
        System.err.println("数据读取失败...");
        try {
            channel.close();
            latch.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
