package com.aidar.rabbitmq_test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @desc
 * @date 17-7-31
 */
public class Product {
    private final static String QUEUE_NAME = "hello1";

    public static void main(String[] argv) throws Exception {
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //      设置RabbitMQ地址
        factory.setHost("localhost");
//        factory.setPort(5672);
//        factory.setPassword("guest");
//        factory.setUsername("guest");
        //      创建一个新的连接
        Connection connection = factory.newConnection();
        //      创建一个频道
        Channel channel = connection.createChannel();
        //      声明一个队列 -- 在RabbitMQ中，队列声明是幂等性的（一个幂等操作的特点是其任意多次执行所产生的影响均与一次执行的影响相同），也就是说，如果不存在，就创建，如果存在，不会对已经存在的队列产生任何影响。
        //为消息通道绑定一个队列
        //队列的相关参数需要与第一次定义该队列时相同，否则会出错
        //参数1：队列名称
        //参数2：为true时server重启队列不会消失
        //参数3：队列是否是独占的，如果为true只能被一个connection使用，其他连接建立时会抛出异常
        //参数4：队列不再使用时是否自动删除（没有连接，并且没有未处理的消息)
        //参数5：建立队列时的其他参数
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!";
        //      发送消息到队列中
        for (int i=0; i<10000000; i++) {

            //向server发布一条消息
            //参数1：exchange名字，若为空则使用默认的exchange
            //参数2：routing key
            //参数3：其他的属性
            //参数4：消息体
            //RabbitMQ默认有一个exchange，叫default exchange，它用一个空字符串表示，它是direct exchange类型，
            //任何发往这个exchange的消息都会被路由到routing key的名字对应的队列上，如果没有对应的队列，则消息会被丢弃
            channel.basicPublish("", QUEUE_NAME, null, (message+i).getBytes("UTF-8"));
        }
        //      关闭频道和连接
        channel.close();
        connection.close();
    }
}
