package com.aidar.socket_test.nio;

import java.io.IOException;

/**
 * @desc NIO服务端
 * @date 17-8-7
 */
public class NioServer {
    private static int DEFAULT_PORT = 9999;
    private static ServerHandler serverHandler;
    public static void start()  throws IOException {
        start(DEFAULT_PORT);
    }
    public static synchronized void start(int port)  throws IOException {
        if (null != serverHandler){
            serverHandler.stop();
        }
        serverHandler = new ServerHandler(port);
        new Thread(serverHandler, "AioServer").start();
        System.out.println("server");
    }
}
