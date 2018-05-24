//package com.xjtushilei.logagent4networkcollege.kafka;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//
///**
// * @author scriptshi
// * 2018/5/23
// */
//@Component
//public class Producer {
//
//    @Value("${kafka.topic.name}")
//    String topicName;
//
//    private final KafkaTemplate kafkaTemplate;
//
//    Producer(KafkaTemplate kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    public void send(String message) {
//        this.kafkaTemplate.send(topicName, message);
//        System.out.println("Send message [" + message + "]");
//    }
//
//}