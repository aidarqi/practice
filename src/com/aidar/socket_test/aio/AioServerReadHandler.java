package com.aidar.socket_test.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @desc
 * @date 17-8-8
 */
public class AioServerReadHandler implements CompletionHandler<Integer, ByteBuffer> {
    private AsynchronousSocketChannel channel;
    public AioServerReadHandler(AsynchronousSocketChannel channel) {
        this.channel = channel;
    }

    @Override public void completed(Integer result, ByteBuffer attachment) {
        attachment.flip();
        byte[] message = new byte[attachment.remaining()];
        attachment.get(message);
        try {
            String expression = new String(message, "utf-8");
            System.out.println("服务器接收到消息: " + expression);
            String result1 = expression + " world";
            doWrite(result1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            this.channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doWrite(String result) {
        byte[] bytes = result.getBytes();
        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
        writeBuffer.put(bytes);
        writeBuffer.flip();
        channel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override public void completed(Integer result, ByteBuffer buffer) {
                if(buffer.hasRemaining()){
                    channel.write(buffer, buffer, this);
                } else {
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    channel.read(readBuffer, readBuffer, new AioServerReadHandler(channel));
                }
            }

            @Override public void failed(Throwable exc, ByteBuffer attachment) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}
