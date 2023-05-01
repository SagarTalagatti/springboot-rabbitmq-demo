package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.User;
import net.javaguides.springboot.publisher.RabbitMQJsonProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {

    private RabbitMQJsonProducer jsonProducer;

    @Autowired
    public MessageJsonController(RabbitMQJsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User uesr){

        jsonProducer.sendJsonMessage(uesr);

        return ResponseEntity.ok("Json message sent to RabbitMQ ...");
    }
}
