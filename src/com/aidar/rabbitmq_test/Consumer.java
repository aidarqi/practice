package com.aidar.rabbitmq_test;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @desc
 * @date 17-7-31
 */
public class Consumer {
    private final static String QUEUE_NAME = "hello1";

    public static void main(String[] argv) throws Exception {
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //      设置RabbitMQ地址
        factory.setHost("localhost");
        //      创建一个新的连接
        Connection connection = factory.newConnection();
        //      创建一个频道
        Channel channel = connection.createChannel();
        //      声明要关注的队列 -- 在RabbitMQ中，队列声明是幂等性的（一个幂等操作的特点是其任意多次执行所产生的影响均与一次执行的影响相同），也就是说，如果不存在，就创建，如果存在，不会对已经存在的队列产生任何影响。

        channel.queueDeclare(QUEUE_NAME,false, false, false, null);
        System.out.println("C [*] Waiting for messages. To exit press CTRL+C");
//        使用【prefetchcount = 1】这个设置。告诉RabbitMQ，不要一次将多个消息发送给一个消费者。这样做的好处是只有当消费者处理完成当前消息并反馈后，才会收到另外一条消息或任务。
//        int prefetchCount = 1;
//        channel.basicQos(prefetchCount);
        //      DefaultConsumer类实现了Consumer接口，通过传入一个频道，告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery
        com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws
                IOException {
                String message = new String(body, "UTF-8");
                System.out.println("C [x] Received '" + message + "'");
            }
        };

        //      自动回复队列应答 -- RabbitMQ中的消息确认机制，后面章节会详细讲解
        //为channel声明一个consumer，服务器会推送消息
        //参数1:队列名称
        //参数2：是否发送ack包，不发送ack消息会持续在服务端保存，直到收到ack。  可以通过channel.basicAck手动回复ack
        //参数3：消费者
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
