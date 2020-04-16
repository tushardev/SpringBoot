package com.spring.kafka.controller;

import com.spring.kafka.service.KafkaMessageSender;
import com.spring.kafka.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/javainuse-kafka/")
public class KafkaWebController {

    @Autowired
    private KafkaMessageSender kafkaMessageSender;

    @Autowired
    private Producer producer;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("message") String message) {
        kafkaMessageSender.send(message);
        return "Message sent to the Kafka Topic java_in_use_topic Successfully";
    }

    @GetMapping(value = "/userProducer")
    public String userProducer(@RequestParam("message") String message) {
        producer.sendMessage(message);
        return "Message sent from User Producer";
    }
}
