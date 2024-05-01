package com.rabbitmq.consumer.consumers;

import com.rabbitmq.consumer.models.MessageModel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class AppConsumer {

    @RabbitListener(queues = "direct.queue1")
    public void listenDirectQueue1(@Payload MessageModel messageModel) {
        System.out.println("direct.queue1");
        System.out.println(messageModel);
    }

    @RabbitListener(queues = "direct.queue2")
    public void listenDirectQueue2(@Payload MessageModel messageModel) {
        System.out.println("direct.queue2");
        System.out.println(messageModel);
    }

    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueue1(@Payload MessageModel messageModel) {
        System.out.println("fanout.queue1");
        System.out.println(messageModel);
    }

    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueue2(@Payload MessageModel messageModel) {
        System.out.println("fanout.queue2");
        System.out.println(messageModel);
    }

    @RabbitListener(queues = "topic.queue1")
    public void listenTopicQueue1(@Payload MessageModel messageModel) {
        System.out.println("topic.queue1");
        System.out.println(messageModel);
    }

    @RabbitListener(queues = "topic.queue2")
    public void listenTopicQueue2(@Payload MessageModel messageModel) {
        System.out.println("topic.queue2");
        System.out.println(messageModel);
    }

    @RabbitListener(queues = "topic.allqueues")
    public void listenTopicAllqueues(@Payload MessageModel messageModel) {
        System.out.println("topic.allqueues");
        System.out.println(messageModel);
    }

    @RabbitListener(queues = "headers.queue1")
    public void listenHeadersQueue1(@Payload Message message) {
        System.out.println("headers.queue1");
        System.out.println(message);
    }

    @RabbitListener(queues = "headers.queue2")
    public void listenHeadersQueue2(@Payload Message message) {
        System.out.println("headers.queue2");
        System.out.println(message);
    }

}
