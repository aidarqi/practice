package com.aidar.rabbitmq_test.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @desc 生产者程序，他负责发送日志消息，与之前不同的是它不是将消息发送到匿名交换器中，而是发送到一个名为【logs】的交换器中。
 *       我们提供一个空字符串的routingkey，它的功能被交换器的分发类型代替了。下面是EmitLog.java的代码：
 * @date 17-7-31
 */
public class EmitLog {
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //声明exchange类型为广播式交换类型
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        //      分发消息
        for(int i = 0 ; i < 100000; i++){
            String message = "Hello World! " + i;
            //在建立连接后，我们声明了一个交互。如果当前没有队列被绑定到交换器，消息将被丢弃，因为没有消费者监听，这条消息将被丢弃。
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
        channel.close();
        connection.close();
    }
}
