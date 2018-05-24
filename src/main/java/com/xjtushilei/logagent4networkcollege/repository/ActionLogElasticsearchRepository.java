package com.xjtushilei.logagent4networkcollege.repository;

import com.xjtushilei.logagent4networkcollege.entity.ActionLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author scriptshi
 * 2018/5/23
 */
public interface ActionLogElasticsearchRepository extends ElasticsearchRepository<ActionLog, String> {

}
