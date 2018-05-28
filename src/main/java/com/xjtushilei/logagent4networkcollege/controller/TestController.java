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
import java.util.List;
import java.util.Random;

/**
 * @author scriptshi
 * 2018/5/24
 */
@RestController
@RequestMapping("/test")
@CrossOrigin
public class TestController {

    private Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/test")
    public List test1(String name){
        return consumerService.actionLogMongoRepository.findByCourseName(name);
    }
}
