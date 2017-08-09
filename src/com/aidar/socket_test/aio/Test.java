package com.aidar.socket_test.aio;


/**
 * @desc
 * @date 17-8-8
 */
public class Test {

    static int i = 0;
    //测试主方法
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        //运行服务器
        AioServer.start();
        //避免客户端先于服务器启动前执行代码
        Thread.sleep(100);
        //运行客户端
        Client.start();
        Thread.sleep(100);
        System.out.println("请输入请求消息：");
        //        Scanner scanner = new Scanner(System.in);
        //        Client.sendMsg(scanner.nextLine());
//        for (int j=0, j < 10, j++) {
//            new Thread(new Runnable() {
//                @Override public void run() {
////                    while (true) {
//                        String expression = "hello" + i++;
//                        try {
//                            Client.start();
//                            Thread.currentThread().sleep(100);
//                            Client.sendMsg(expression);
//                            Thread.currentThread().sleep(100);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
////                }
//            }).start();
//
//        }
//            new Thread(new Runnable() {
//                @Override public void run() {
//                    for (int k = 0; k < 10; k++) {
//                        new Thread(new Runnable() {
//                            @Override public void run() {
//                                String expression = "hello" + i++;
//                                try {
////                                    Client.start();
//                                    System.out.println(Thread.currentThread().getName());
////                                    Thread.currentThread().sleep(100);
//                                    Client.sendMsg(expression);
//                                    Thread.currentThread().sleep(100);
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                }
//
//                            }
//                        }).start();
//                        try {
//                            Thread.sleep(100);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }).start();

        for (int k=0; k < 10; k++) {
            new Thread(new Runnable() {
                String expression = "hello" + i++;
                @Override public void run() {
                    System.out.println(Thread.currentThread().getName());
//                    Client.start();
                    try {
                        Client.sendMsg(expression);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            Thread.sleep(100);
        }
        }
}
