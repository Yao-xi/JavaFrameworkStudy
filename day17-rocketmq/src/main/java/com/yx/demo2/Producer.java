package com.yx.demo2;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("DuplicatedCode")
public class Producer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr("192.168.111.135:9876");
        producer.start();
        Message msg = new Message("topic1", ("This is message... :: "+new Date()).getBytes(StandardCharsets.UTF_8));
        
        producer.send(msg, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("返回结果：" + sendResult);
                System.out.println("callback time :: " + new Date());
            }
            
            @Override
            public void onException(Throwable e) {
                System.out.println(e.getMessage());
            }
        });
        System.out.println("time :: " + new Date());
        
        TimeUnit.SECONDS.sleep(3);
        
        producer.shutdown();
    }
}
