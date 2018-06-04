package com.xjtushilei.logagent4networkcollege.controller;

import com.xjtushilei.logagent4networkcollege.entity.ActionLog;
import com.xjtushilei.logagent4networkcollege.entity.VisitLog;
import com.xjtushilei.logagent4networkcollege.kafka.ProducerService;
import com.xjtushilei.logagent4networkcollege.utils.IpUtil;
import com.xjtushilei.logagent4networkcollege.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
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

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProducerService producerService;

    @Value("${referrer-auth}")
    String[] referrerAuth;


    @GetMapping("/hi")
    public String hi() {
        return "hi ! " + new Random().nextInt(100);
    }

    @PostMapping("/visit")
    public String visit(@RequestBody VisitLog visitLog, HttpServletRequest request) {
        String referrer = request.getHeader("Verification-referrer");
        if (Arrays.asList(referrerAuth).parallelStream().anyMatch(referrer::contains)) {
            visitLog.setIp(IpUtil.getIpAddr(request));
            visitLog.setUserAgent(request.getHeader("User-Agent"));

            visitLog.setDate(new Date());

            log.debug(visitLog.toString());
            String json = JsonUtils.toJson(visitLog);
            producerService.send("visit", json);
//        consumerService.processVisitLogMessageByMongo(json);
//        consumerService.processVisitLogMessageByElasticSearch(json);
            return "visit log put success.";
        } else {
            return "visit log put failure. Authority authentication failure";
        }
    }

    @PostMapping("/action")
    public String action(@RequestBody ActionLog actionLog, HttpServletRequest request) {
        String referrer = request.getHeader("Verification-referrer");
        if (Arrays.asList(referrerAuth).parallelStream().anyMatch(referrer::contains)) {
            actionLog.setDate(new Date());
            log.debug(actionLog.toString());
            String json = JsonUtils.toJson(actionLog);
            producerService.send("action", json);
//        consumerService.processActionLogMessageByElasticSearch(json);
//        consumerService.processActionLogMessageByMongo(json);
            return "action log put success.";
        } else {
            return "action log put failure. Authority authentication failure";
        }

    }

}
