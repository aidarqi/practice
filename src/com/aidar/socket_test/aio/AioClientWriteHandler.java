package com.aidar.socket_test.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * @desc
 * @date 17-8-8
 */
public class AioClientWriteHandler implements CompletionHandler<Integer, ByteBuffer> {
    private AsynchronousSocketChannel channel;
    private CountDownLatch latch;
    public AioClientWriteHandler(AsynchronousSocketChannel channel, CountDownLatch latch) {
        this.channel = channel;
        this.latch = latch;
    }
    @Override public void completed(Integer result, ByteBuffer buffer) {
        if(buffer.hasRemaining()) {
            channel.write(buffer, buffer, this);
        } else {
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            channel.read(readBuffer, readBuffer, new AioClientReadHandler(channel, latch));
        }
    }

    @Override public void failed(Throwable exc, ByteBuffer attachment) {
        System.err.println("数据发送失败...");
        try {
            channel.close();
            latch.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
