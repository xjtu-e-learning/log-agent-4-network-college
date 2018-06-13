package com.xjtushilei.logagent4networkcollege.kafka;


import com.xjtushilei.logagent4networkcollege.entity.ActionLog;
import com.xjtushilei.logagent4networkcollege.entity.VisitLog;
import com.xjtushilei.logagent4networkcollege.repository.ActionLogElasticsearchRepository;
import com.xjtushilei.logagent4networkcollege.repository.ActionLogMongoRepository;
import com.xjtushilei.logagent4networkcollege.repository.VisitLogElasticsearchRepository;
import com.xjtushilei.logagent4networkcollege.repository.VisitLogMongoRepository;
import com.xjtushilei.logagent4networkcollege.utils.IpUtil;
import com.xjtushilei.logagent4networkcollege.utils.JsonUtils;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author scriptshi
 * 2018/5/23
 */
@Component
public class ConsumerService {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public VisitLogMongoRepository visitLogMongoRepository;
    @Autowired
    public VisitLogElasticsearchRepository visitLogElasticsearchRepository;

    @Autowired
    public ActionLogElasticsearchRepository actionLogElasticsearchRepository;
    @Autowired
    public ActionLogMongoRepository actionLogMongoRepository;


    @KafkaListener(topics = "visit", groupId = "mongodb")
    public void processVisitLogMessageByMongo(String message) {
        VisitLog visitLog = JsonUtils.toObject(message, VisitLog.class);
        praseVisitLog(visitLog);
        visitLogMongoRepository.save(visitLog);
        log.debug("visit-mongo-消费--->"+visitLog);
    }

    @KafkaListener(topics = "visit", groupId = "elasticsearch")
    public void processVisitLogMessageByElasticSearch(String message) {
        VisitLog visitLog = JsonUtils.toObject(message, VisitLog.class);
        praseVisitLog(visitLog);
        visitLogElasticsearchRepository.save(visitLog);
        log.debug("visit-elasticsearch-消费--->"+visitLog);

    }

    @KafkaListener(topics = "action", groupId = "mongodb")
    public void processActionLogMessageByMongo(String message) {
        ActionLog actionLog = JsonUtils.toObject(message, ActionLog.class);
        actionLogMongoRepository.save(actionLog);
        log.debug("action-mongodb-消费--->"+actionLog);
    }

    @KafkaListener(topics = "action", groupId = "elasticsearch")
    public void processActionLogMessageByElasticSearch(String message) {
        ActionLog actionLog = JsonUtils.toObject(message, ActionLog.class);
        actionLogElasticsearchRepository.save(actionLog);
        log.debug("action-elasticsearch-消费--->"+actionLog);
    }

    private void praseVisitLog(VisitLog visitLog) {
        //设置ip相关参数
        IpUtil.setIPinfo(visitLog);

        UserAgent userAgent = UserAgent.parseUserAgentString(visitLog.getUserAgent());
        //设置用户浏览器相关设备参数
        visitLog.setBrowserType(userAgent.getBrowser().getBrowserType().getName());
        visitLog.setBrowserRenderingEngine(userAgent.getBrowser().getRenderingEngine().getName());
        visitLog.setBrowserManufacturer(userAgent.getBrowser().getManufacturer().getName());
        visitLog.setBrowserVersion(userAgent.getBrowserVersion().getMajorVersion());
        // 设置用户操作系统
        visitLog.setOperatingSystemDeviceType(userAgent.getOperatingSystem().getDeviceType().getName());
        visitLog.setOperatingSystemManufacturer(userAgent.getOperatingSystem().getManufacturer().getName());
        visitLog.setOperatingSystemName(userAgent.getOperatingSystem().getName());


    }
}