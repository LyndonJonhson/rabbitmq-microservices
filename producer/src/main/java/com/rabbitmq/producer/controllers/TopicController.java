package com.rabbitmq.producer.controllers;

import com.rabbitmq.producer.models.MessageModel;
import com.rabbitmq.producer.producers.AppProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic")
public class TopicController {

    private final AppProducer appProducer;

    public TopicController(AppProducer appProducer) {
        this.appProducer = appProducer;
    }

    @GetMapping("/queue1")
    public ResponseEntity<MessageModel> getQueue1(@RequestBody MessageModel messageModel) {
        appProducer.sendTopicToQueue1(messageModel);
        return ResponseEntity.status(HttpStatus.OK).body(messageModel);
    }

    @GetMapping("/queue2")
    public ResponseEntity<MessageModel> getQueue2(@RequestBody MessageModel messageModel) {
        appProducer.sendTopicToQueue2(messageModel);
        return ResponseEntity.status(HttpStatus.OK).body(messageModel);
    }

}
