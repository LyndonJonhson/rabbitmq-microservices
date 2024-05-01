package com.rabbitmq.producer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageModel implements Serializable {

    private String subject;
    private String text;

}