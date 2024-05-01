package com.rabbitmq.consumer.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean
    public Queue directQueue1() {
        return new Queue("direct.queue1", false);
    }

    @Bean
    public Queue directQueue2() {
        return new Queue("direct.queue2", false);
    }

    @Bean
    public Queue fanoutQueue1() {
        return new Queue("fanout.queue1", false);
    }

    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanout.queue2", false);
    }

    @Bean
    public Queue topicQueue1() {
        return new Queue("topic.queue1", false);
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue("topic.queue2", false);
    }

    @Bean
    public Queue topicAllqueues() {
        return new Queue("topic.allqueues", false);
    }

    @Bean
    public Queue headersQueue1() {
        return new Queue("headers.queue1", false);
    }

    @Bean
    public Queue headersQueue2() {
        return new Queue("headers.queue2", false);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    public HeadersExchange headersExchange() {
        return new HeadersExchange("headersExchange");
    }

    @Bean
    public Binding directQueue1Binding(Queue directQueue1, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue1).to(directExchange).with("routingKey1");
    }

    @Bean
    public Binding directQueue2Binding(Queue directQueue2, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue2).to(directExchange).with("routingKey2");
    }

    @Bean
    public Binding fanoutQueue1Binding(Queue fanoutQueue1, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    @Bean
    public Binding fanoutQueue2Binding(Queue fanoutQueue2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }

    @Bean
    public Binding topicQueue1Binding(Queue topicQueue1, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue1).to(topicExchange).with("routingKey.1");
    }

    @Bean
    public Binding topicQueue2Binding(Queue topicQueue2, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue2).to(topicExchange).with("routingKey.2");
    }

    @Bean
    public Binding topicAllqueuesBinding(Queue topicAllqueues, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicAllqueues).to(topicExchange).with("routingKey.*");
    }

    @Bean
    public Binding headersQueue1Binding(Queue headersQueue1, HeadersExchange headersExchange) {
        return BindingBuilder.bind(headersQueue1).to(headersExchange).where("queue").matches("queue1");
    }

    @Bean
    public Binding headersQueue2Binding(Queue headersQueue2, HeadersExchange headersExchange) {
        return BindingBuilder.bind(headersQueue2).to(headersExchange).where("queue").matches("queue2");
    }

}
