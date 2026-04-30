package com.example.kafkademo.controller;

import com.example.kafkademo.producer.MessageProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageProducer messageProducer;

    public MessageController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping
    public String sendMessage(@RequestBody String message) {
        return messageProducer.sendMessage(message);
    }

    @GetMapping
    public String healthCheck() {
        return "Kafka Message Demo API is running";
    }
}
