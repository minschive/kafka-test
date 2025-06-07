package com.mycom.kafkatest.controller;

import com.mycom.kafkatest.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kafka")
public class KafkaTestController {

    private final KafkaProducer kafkaProducer;

    @GetMapping("/send")
    public String sendMessage(@RequestParam String msg) {
        kafkaProducer.sendMessage("test-topic", msg);
        return "Message Sent : " + msg;
    }
}
