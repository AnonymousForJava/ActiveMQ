package com.activemq.springactivemq.topic;


import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jms.Topic;

/**
 * @ClassName: ActiveMQTopicConfig
 * @Author: ZhangYue26
 * @Description: Topic模式配置
 * @Date: 2020-07-28
 */
@Component
public class ActiveMQTopicConfig {

    public final static String MY_TOPIC = "MY_TOPIC";
 
    @Bean
    public Topic topic(){
        return new ActiveMQTopic(MY_TOPIC);
    }

}
