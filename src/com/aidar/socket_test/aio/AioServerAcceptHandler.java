package com.aidar.socket_test.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @desc
 * @date 17-8-8
 */
public class AioServerAcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AioServerHandler> {
    @Override public void completed(AsynchronousSocketChannel channel, AioServerHandler serverHandler) {
        AioServer.clientCount++;
        System.out.println("连接的客户端数: " + AioServer.clientCount);
        serverHandler.channel.accept(serverHandler, this);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer, buffer, new AioServerReadHandler(channel));
    }

    @Override public void failed(Throwable exc, AioServerHandler serverHandler) {
        exc.printStackTrace();
        serverHandler.latch.countDown();
    }
}
