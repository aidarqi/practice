package com.aidar.socket_test.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @desc
 * @date 17-8-7
 */
public class ServerHandler implements Runnable{
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private volatile boolean started;

    public ServerHandler(int port) {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);
            //接受客户端连接请求
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            started = true;
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop() {
        started = false;
    }
    @Override public void run() {
        while (started) {
            try {
                selector.select(1000);
                selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();
                SelectionKey key = null;
                while (it.hasNext()) {
                    key = it.next();
                    it.remove();
                    try {
                        handleInput(key);
                    } catch (IOException e) {
                        if(null != key) {
                            key.cancel();
                            if (null != key.channel()){
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()) {
            if (key.isAcceptable()) {
                ServerSocketChannel scc = (ServerSocketChannel) key.channel();
                SocketChannel socketChannel = scc.accept();
                socketChannel.configureBlocking(false);
                socketChannel.register(selector, SelectionKey.OP_READ);
            }
            if(key.isReadable()) {
                SocketChannel sc = (SocketChannel)key.channel();
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(buffer);
                if(readBytes > 0) {
                    buffer.flip();
                    byte[] bytes = new byte[buffer.remaining()];
                    buffer.get(bytes);
                    String expression = new String(bytes, "utf-8");
                    System.out.println("服务器接收到的消息: " + expression);
                    String result = expression + " world";
                    doWrite(sc, result);
                } else if(readBytes <0) {
                    key.cancel();
                    sc.close();
                }
            }
        }
    }

    private void doWrite(SocketChannel socketChannel, String response) throws IOException {
        byte[] bytes = response.getBytes();
        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
        writeBuffer.put(bytes);
        writeBuffer.flip();
        socketChannel.write(writeBuffer);
    }
}
