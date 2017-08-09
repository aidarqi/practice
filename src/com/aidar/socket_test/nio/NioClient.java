package com.aidar.socket_test.nio;

import java.io.IOException;

/**
 * @desc
 * @date 17-8-7
 */
public class NioClient {
    private static String DEFAULT_HOST = "127.0.0.1";
    private static int DEFAULT_PORT = 9999;
    private static NioClientHandler clientHandler;
    public static void start() throws IOException  {
        start(DEFAULT_HOST, DEFAULT_PORT);
    }
    public static synchronized void start(String host, int port) throws IOException {
        if(null != clientHandler) {
            clientHandler.stop();
        }
        clientHandler = new NioClientHandler(host, port);
        new Thread(clientHandler,"Client").start();
        System.out.println("Client");
    }
    public static void sendMsg(String msg) throws Exception{
//        if(msg.equals("q")) return false;
        clientHandler.sendMsg(msg);
//        return true;
    }

//    public static void main(String[] args) throws Exception {
//        start();
//        sendMsg("111");
//    }
}
