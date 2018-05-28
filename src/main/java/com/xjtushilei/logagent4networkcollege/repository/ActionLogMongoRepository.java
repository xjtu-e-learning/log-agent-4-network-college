package com.xjtushilei.logagent4networkcollege.repository;

import com.xjtushilei.logagent4networkcollege.entity.ActionLog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author scriptshi
 * 2018/5/23
 */
public interface ActionLogMongoRepository extends MongoRepository<ActionLog, String> {

    List<ActionLog> findByCourseName(String name);
}
