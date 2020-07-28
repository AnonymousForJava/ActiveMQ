package com.activemq.springactivemq.queue;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName Consumer
 * @Description TODO
 * @Author ZhangY
 * @Date 2019/12/23 14:03
 * @Version 1.0.0
 */
@Component
public class Consumer {
    @JmsListener(destination = "message")
    public void readMessage(String text) {
        System.out.println("信息内容为："+text);

    }

    @JmsListener(destination = "mymap")
    public void readMap(Map map) {
        for (Object e : map.keySet()) {
            Object obj = map.get(e);
            System.out.println(e+"::"+obj);
        }
    }

}
