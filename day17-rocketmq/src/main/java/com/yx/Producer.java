package com.yx;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Producer {
    public static void main(String[] args) throws Exception {
        //1.创建一个发送消息的对象Producer
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        //2.设定发送的命名服务器地址
        producer.setNamesrvAddr("192.168.111.135:9876");
        //3.1启动发送的服务
        producer.start();
        int i = 0;
        while (true) {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            if ("-exit".equals(s)) {
                break;
            }
            //4.创建要发送的消息对象,指定topic，指定内容body
            Message msg = new Message("topic1", (i++ + ":: " + s).getBytes(StandardCharsets.UTF_8));
            //4.2发送消息
            SendResult result = producer.send(msg);
            System.out.println("返回结果：" + result);
        }
        producer.shutdown();
    }
}
