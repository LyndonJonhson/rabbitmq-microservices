package com.rabbitmq.producer.controllers;

import com.rabbitmq.producer.models.MessageModel;
import com.rabbitmq.producer.producers.AppProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/direct")
public class DirectController {

    private final AppProducer appProducer;

    public DirectController(AppProducer appProducer) {
        this.appProducer = appProducer;
    }

    @GetMapping("/queue1")
    public ResponseEntity<MessageModel> getQueue1(@RequestBody MessageModel messageModel) {
        appProducer.sendDirectToQueue1(messageModel);
        return ResponseEntity.status(HttpStatus.OK).body(messageModel);
    }

    @GetMapping("/queue2")
    public ResponseEntity<MessageModel> getQueue2(@RequestBody MessageModel messageModel) {
        appProducer.sendDirectToQueue2(messageModel);
        return ResponseEntity.status(HttpStatus.OK).body(messageModel);
    }

}
