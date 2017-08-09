package com.aidar.socket_test.aio;

/**
 * @desc
 * @date 17-8-8
 */
public class Client {
    private static String DEFAULT_HOST = "127.0.0.1";
    private static int DEFAULT_PORT = 9999;
    private static AioClientHandler clientHandler;
    public static void start() {
        start(DEFAULT_HOST, DEFAULT_PORT);
    }
    public static synchronized void start(String host, int port) {
        if(null != clientHandler)
            return;
        clientHandler = new AioClientHandler(host, port);
        new Thread(clientHandler,"Client").start();
    }
    public static void sendMsg(String msg) throws Exception{
        clientHandler.sendMsg(msg);
    }

//    public static void main(String[] args) {
//        start();
//    }
}
