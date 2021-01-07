package com.yx;


import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

public class Consumer {
    public static void main(String[] args) throws Exception {
        //1.创建一个接收消息的对象Consumer
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group1");
        //2.设定接收的命名服务器地址
        consumer.setNamesrvAddr("192.168.111.132:9876");
        //3.设置接收消息对应的topic,对应的sub标签为任意*
        consumer.subscribe("topic1", "*");
        // 广播
        // consumer.setMessageModel(MessageModel.BROADCASTING);
        //3.开启监听，用于接收消息
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list,
                                                            ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                //遍历消息
                for (MessageExt msg : list) {
                    // System.out.println("收到消息："+msg);
                    System.out.println("消息：" + new String(msg.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;// 成功处理, mq 收到这个 标记后相同的消息讲不会再次发给消费者
            }
        });
        //4.启动接收消息的服务
        consumer.start();// 开启多线程 监控消息,持续运行
        System.out.println("接收消息服务已开启运行");
    }
}
