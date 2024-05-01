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
@RequestMapping("/fanout")
public class FanoutController {

    private final AppProducer appProducer;

    public FanoutController(AppProducer appProducer) {
        this.appProducer = appProducer;
    }

    @GetMapping
    public ResponseEntity<MessageModel> getQueue1(@RequestBody MessageModel messageModel) {
        appProducer.sendFanout(messageModel);
        return ResponseEntity.status(HttpStatus.OK).body(messageModel);
    }

}
