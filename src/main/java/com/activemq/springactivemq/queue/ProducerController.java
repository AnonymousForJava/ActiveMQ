package com.activemq.springactivemq.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @ClassName ProducerController
 * @Description TODO
 * @Author ZhangY
 * @Date 2019/12/23 13:55
 * @Version 1.0.0
 */
@RestController
@Slf4j
public class ProducerController {

    @Resource
    private JmsMessagingTemplate template;

    @RequestMapping("sendMessage")
    public String sendMessage(){
        template.convertAndSend("message","发送消息");
        log.debug("成功发送消息");
        return " 成功发送消息 ";
    }

    @RequestMapping("sendMap")
    public String sendMap(){
        HashMap<String, String> map = new HashMap();
        map.put("name", "zhang");
        map.put("age", "19");
        template.convertAndSend("mymap",map);
        return "成功发送map";
    }

}
