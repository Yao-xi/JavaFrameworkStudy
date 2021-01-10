package com.yx.demo1;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class Producer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr("192.168.111.135:9876");
        producer.start();
        Message msg = new Message("topic1", ("This is message...").getBytes(StandardCharsets.UTF_8));
        // 设置延迟
        msg.setDelayTimeLevel(3);
        SendResult result = producer.send(msg);
        System.out.println("time :: " + new Date());
        System.out.println("返回结果：" + result);
        
        producer.shutdown();
    }
}
