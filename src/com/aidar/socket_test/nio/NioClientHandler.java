package com.aidar.socket_test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @desc
 * @date 17-8-7
 */
public class NioClientHandler implements Runnable {
    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile boolean started;

    public NioClientHandler(String host, int port) {
        System.out.println("NioClientHandler");
        this.host = host;
        this.port = port;
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
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
        try{
            doConnect();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
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
                    } catch (Exception e) {
                        if (null != key) {
                            key.cancel();
                            if (null != key.channel()) {
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        //selector关闭后会自动释放里面管理的资源
        if(selector != null)
            try{
                selector.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
    }

    private void handleInput(SelectionKey key) throws IOException{
        System.out.println("handleInput()");
        if(key.isValid()) {
            SocketChannel socketChannel = (SocketChannel)key.channel();
            if(key.isConnectable()) {
                if(socketChannel.finishConnect());
                else System.exit(1);
            }
            if(key.isReadable()) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                int readBytes = socketChannel.read(byteBuffer);
                if(readBytes > 0) {
                    byteBuffer.flip();
                    byte[] bytes = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bytes);
                    String result = new String(bytes, "utf-8");
                    System.out.println("客户端接受的消息: " + result);
                } else if(readBytes < 0) {
                    key.cancel();
                    socketChannel.close();
                }
            }
        }
    }

    private  void doConnect() throws IOException {
        System.out.println("doConnect()");
        if(socketChannel.connect(new InetSocketAddress(host,port)));
        else socketChannel.register(selector, SelectionKey.OP_CONNECT);
    }

    public void sendMsg(String msg) throws Exception{
        socketChannel.register(selector, SelectionKey.OP_READ);
        doWrite(socketChannel, msg);
    }

    private void doWrite(SocketChannel socketChannel, String request) throws IOException {
        System.out.println("doWrite()");
        byte[] bytes = request.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
        byteBuffer.put(bytes);
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
    }
}
