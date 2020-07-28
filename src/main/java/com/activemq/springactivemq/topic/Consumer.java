package com.activemq.springactivemq.topic;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;

/**
 * @ClassName: Consumer
 * @Author: ZhangYue26
 * @Description: Topic模式消息接收者
 * @Date: 2020-07-28
 */
@Component
public class Consumer {

    @JmsListener(destination = ActiveMQTopicConfig.MY_TOPIC)
    public void receive(TextMessage textMessage) throws Exception{
        System.out.println("*******Topic消费者接收到消息："+textMessage.getText());
    }


}
