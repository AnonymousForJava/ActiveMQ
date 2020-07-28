package com.activemq.springactivemq.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.jms.Topic;
import java.util.UUID;

/**
 * @ClassName: ProducerController
 * @Author: ZhangYue26
 * @Description: Topic模式消息发送者
 * @Date: 2020-07-28
 */
@Controller
public class ProducerController {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Topic topic;


    @RequestMapping(value = "/topic",method = RequestMethod.GET)
    public void produceMsg(){
        jmsMessagingTemplate.convertAndSend(topic,"Topic主题消息:"+ UUID.randomUUID().toString().substring(0,6));

    }

}
