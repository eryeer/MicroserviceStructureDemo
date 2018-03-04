package com.wxbc.message;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {


    //使用@RabbitListener监听指定队列、指定exchange、指定routingKey的消息
    //同时@RabbitListener有建立队列、exchange、routingKey的功能
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "emailQueue2", durable = "true"),
                    exchange = @Exchange(value = "messageExchange", type = "topic", durable = "true"),
                    key = "emailKey")
    )
    public void receiveMessage(String message) {
        System.out.println(message);
    }

}
