package com.xjtushilei.logagent4networkcollege.repository;

import com.xjtushilei.logagent4networkcollege.entity.VisitLog;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author scriptshi
 * 2018/5/23
 */
public interface VisitLogMongoRepository extends MongoRepository<VisitLog, String> {

}
