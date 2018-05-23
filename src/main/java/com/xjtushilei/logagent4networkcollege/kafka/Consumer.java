package com.xjtushilei.logagent4networkcollege.kafka;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
/**
 * @author scriptshi
 * 2018/5/23
 */
@Component
class Consumer {

    @KafkaListener(topics = "testTopic")
    public void processMessage(SampleMessage message) {
        System.out.println("Received sample message [" + message + "]");
    }

}