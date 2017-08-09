package com.aidar.socket_test.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @desc BIO服务端源码
 * @date 17-8-7
 */
public class BioServer {
    private static int DEFAULT_PORT = 9999;
    private static ServerSocket serverSocket;
    public static void start() throws IOException {
        start(DEFAULT_PORT);
    }

    public synchronized static void start(int port) throws IOException {
        if(null != serverSocket) return;
        try {
            serverSocket = new ServerSocket(port);
            while(true) {
                Socket socket = serverSocket.accept();
                new Thread(new ServerHandler(socket)).start();
            }
        } finally {
            if (null != serverSocket) {
                serverSocket.close();
                serverSocket = null;
            }
        }
    }
}
