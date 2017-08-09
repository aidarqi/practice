package com.aidar.socket_test.aio;

/**
 * @desc
 * @date 17-8-8
 */
public class AioServer {
    private static int DEFAULT_PORT = 9999;
    private static AioServerHandler serverHandler;
    public volatile static long clientCount = 0;
    public static void start(){
        start(DEFAULT_PORT);
    }

    public static synchronized void start(int port) {
        if(null != serverHandler)
            return;
        serverHandler = new AioServerHandler(port);
        new Thread(serverHandler,"AioServer").start();
    }
}
