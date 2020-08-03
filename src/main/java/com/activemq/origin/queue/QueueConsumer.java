package com.activemq.origin.queue;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @ClassName Consumer
 * @Description TODO 创建消息接受者        队列模型消息接受者
 * @Author ZhangY
 * @Date 2019/12/23 14:29
 * @Version 1.0.0
 */
public class QueueConsumer {

    //定义activemq链接地址
    private static final String ACTIVE_MQ_ADDRESS="tcp://127.0.0.1:61616";
    //定义发送的队列
    private static final String QUEUE_NAME = "MyMessage";

    public static void main(String[] args) throws JMSException {
        //创建链接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_MQ_ADDRESS);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建指定的队列目标
        Destination destination = session.createQueue(QUEUE_NAME);
        MessageConsumer consumer = session.createConsumer(destination);
        //创建接收者的消息监听器
        consumer.setMessageListener(new MessageListener() {
                                        public void onMessage(Message message) {
                                            try {
                                                TextMessage textMessage = (TextMessage) message;
                                                System.out.println("获取到消息:"+textMessage.getText());
                                            } catch (JMSException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }

        );

    }

}
