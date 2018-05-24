package com.xjtushilei.logagent4networkcollege.kafka;


import com.xjtushilei.logagent4networkcollege.entity.ActionLog;
import com.xjtushilei.logagent4networkcollege.entity.VisitLog;
import com.xjtushilei.logagent4networkcollege.repository.ActionLogElasticsearchRepository;
import com.xjtushilei.logagent4networkcollege.repository.ActionLogMongoRepository;
import com.xjtushilei.logagent4networkcollege.repository.VisitLogElasticsearchRepository;
import com.xjtushilei.logagent4networkcollege.repository.VisitLogMongoRepository;
import com.xjtushilei.logagent4networkcollege.utils.JsonUtils;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author scriptshi
 * 2018/5/23
 */
@Component
public class ConsumerService {

    @Autowired
    VisitLogMongoRepository visitLogRepository;
    @Autowired
    VisitLogElasticsearchRepository visitLogElasticsearchRepository;

    @Autowired
    ActionLogElasticsearchRepository actionLogElasticsearchRepository;
    @Autowired
    ActionLogMongoRepository actionLogMongoRepository;


    //    @KafkaListener(topics = "${kafka.topic.name}",groupId="mongodb")
    public void processVisitLogMessageByMongo(String message) {
        VisitLog visitLog = JsonUtils.toObject(message, VisitLog.class);
        praseVisitLog(visitLog);
        visitLogRepository.save(visitLog);

    }

    public void processVisitLogMessageByElasticSearch(String message) {
        VisitLog visitLog = JsonUtils.toObject(message, VisitLog.class);
        praseVisitLog(visitLog);
        visitLogElasticsearchRepository.save(visitLog);

    }
    public void processActionLogMessageByMongo(String message) {
        ActionLog actionLog = JsonUtils.toObject(message, ActionLog.class);
        actionLogMongoRepository.save(actionLog);
    }

    public void processActionLogMessageByElasticSearch(String message) {
        ActionLog actionLog = JsonUtils.toObject(message, ActionLog.class);
        actionLogElasticsearchRepository.save(actionLog);
    }

    private void praseVisitLog(VisitLog visitLog){
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