package com.activemq.origin.queue;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @ClassName Producer
 * @Description TODO 手动创建消息发送者      队列模型消息发送者
 * @Author ZhangY
 * @Date 2019/12/23 14:19
 * @Version 1.0.0
 */
@Slf4j
public class QueueProducer {
    //定义activemq链接地址
    private static final String ACTIVE_MQ_ADDRESS="tcp://127.0.0.1:61616";
    //定义发送的队列
    private static final String QUEUE_NAME = "MyMessage";

    public static void main(String[] args) throws JMSException {
        //创建链接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_MQ_ADDRESS);
        //创建链接
        Connection connection = activeMQConnectionFactory.createConnection();
        //打开链接
        connection.start();
        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);//使用自动确认模式,必须要创建无事务session
        /*
        Session.AUTO_ACKNOWLEDGE：自动应答。
        Session.CLIENT_ACKNOWLEDGE：手动应答
        Session.DUPS_OK_ACKNOWLEDGE：延迟提交
        Session.SESSION_TRANSACTED：事务
        */

        //创建队列目标
        Destination destination = session.createQueue(QUEUE_NAME);
        //创建一个生产者
        MessageProducer producer = session.createProducer(destination);
        //创建模拟的一百个消息
        for (int i = 0; i < 100; i++) {
            TextMessage textMessage = session.createTextMessage("我发送的消息"+i);
            producer.send(textMessage);
            System.out.println("成功发送"+i+"个消息");
            log.debug("成功发送"+i+"个消息");
        }
        //关闭链接
        connection.close();
    }





}
