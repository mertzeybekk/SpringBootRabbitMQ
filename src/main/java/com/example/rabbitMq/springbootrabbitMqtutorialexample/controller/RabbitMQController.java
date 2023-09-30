package com.example.rabbitMq.springbootrabbitMqtutorialexample.controller;

import com.example.rabbitMq.springbootrabbitMqtutorialexample.dto.User;
import com.example.rabbitMq.springbootrabbitMqtutorialexample.publisher.RabbitMQJsonProducer;
import com.example.rabbitMq.springbootrabbitMqtutorialexample.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sendMessage")
public class RabbitMQController {
    private RabbitMQProducer rabbitMQProducer;
    private RabbitMQJsonProducer  rabbitMQJsonProducer;

    public RabbitMQController(RabbitMQProducer rabbitMQProducer,RabbitMQJsonProducer rabbitMQJsonProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
        this.rabbitMQJsonProducer = rabbitMQJsonProducer;
    }
    @GetMapping("/send")
   public ResponseEntity<String>sendMessage(@RequestParam("message")String message){
        this.rabbitMQProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ...");
    }
    @PostMapping("/send")
    public ResponseEntity<String>sendMessage(@RequestBody User user){
        this.rabbitMQJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Message sent to RabbitMQ...");
    }
}
