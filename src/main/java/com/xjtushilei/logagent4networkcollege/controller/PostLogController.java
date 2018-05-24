package com.xjtushilei.logagent4networkcollege.controller;

import com.xjtushilei.logagent4networkcollege.entity.ActionLog;
import com.xjtushilei.logagent4networkcollege.entity.VisitLog;
import com.xjtushilei.logagent4networkcollege.kafka.ConsumerService;
import com.xjtushilei.logagent4networkcollege.utils.IpUtil;
import com.xjtushilei.logagent4networkcollege.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Random;

/**
 * @author scriptshi
 * 2018/5/24
 */
@RestController
@RequestMapping("/log")
@CrossOrigin
public class PostLogController {

    private Logger log = LoggerFactory.getLogger(PostLogController.class);

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/hi")
    public String hi(){
        return "hi ! " + new Random().nextInt(100);
    }

    @PostMapping("/visit")
    public String visit(@RequestBody VisitLog visitLog, HttpServletRequest request) {

        visitLog.setIp(IpUtil.getIpAddr(request));
        visitLog.setUserAgent(request.getHeader("User-Agent"));

        visitLog.setDate(new Date());

        log.debug(visitLog.toString());
        String json = JsonUtils.toJson(visitLog);
        consumerService.processVisitLogMessageByMongo(json);
        consumerService.processVisitLogMessageByElasticSearch(json);
        return "visit log put success.";
    }

    @PostMapping("/action")
    public String action(@RequestBody ActionLog actionLog) {


        actionLog.setDate(new Date());

        log.debug(actionLog.toString());
        String json = JsonUtils.toJson(actionLog);
        consumerService.processVisitLogMessageByMongo(json);
        consumerService.processVisitLogMessageByElasticSearch(json);
        return "visit log put success.";
    }
}
