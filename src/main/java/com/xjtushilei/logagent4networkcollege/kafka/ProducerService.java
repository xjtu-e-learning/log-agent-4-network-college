package com.xjtushilei.logagent4networkcollege.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author scriptshi
 * 2018/5/23
 */
@Component
public class ProducerService {
    private Logger log = LoggerFactory.getLogger(this.getClass());


    private final KafkaTemplate kafkaTemplate;

    ProducerService(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @SuppressWarnings("unchecked")
    public void send(String topicName, String message) {
        this.kafkaTemplate.send(topicName, message);
        log.debug("生产者成功：topic：["+topicName+"] message："+message);
    }

}