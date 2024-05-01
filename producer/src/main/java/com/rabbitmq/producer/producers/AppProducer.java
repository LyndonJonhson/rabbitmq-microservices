package com.rabbitmq.producer.producers;

import com.rabbitmq.producer.models.MessageModel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class AppProducer {

    final RabbitTemplate rabbitTemplate;

    public AppProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendDirectToQueue1(MessageModel messageModel) {
        rabbitTemplate.convertAndSend("directExchange", "routingKey1", messageModel);
    }

    public void sendDirectToQueue2(MessageModel messageModel) {
        rabbitTemplate.convertAndSend("directExchange", "routingKey2", messageModel);
    }

    public void sendFanout(MessageModel messageModel) {
        rabbitTemplate.convertAndSend("fanoutExchange", "", messageModel);
    }

    public void sendTopicToQueue1(MessageModel messageModel) {
        rabbitTemplate.convertAndSend("topicExchange", "routingKey.1", messageModel);
    }

    public void sendTopicToQueue2(MessageModel messageModel) {
        rabbitTemplate.convertAndSend("topicExchange", "routingKey.2", messageModel);
    }

    public void sendHeadersToQueue1(MessageModel messageModel) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("queue", "queue1");
        MessageConverter messageConverter = new SimpleMessageConverter();
        Message message = messageConverter.toMessage(messageModel, messageProperties);
        rabbitTemplate.convertAndSend("headersExchange", "", message);
    }

    public void sendHeadersToQueue2(MessageModel messageModel) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("queue", "queue2");
        MessageConverter messageConverter = new SimpleMessageConverter();
        Message message = messageConverter.toMessage(messageModel, messageProperties);
        rabbitTemplate.convertAndSend("headersExchange", "", message);
    }

}
