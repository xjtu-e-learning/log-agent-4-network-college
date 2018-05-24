package com.xjtushilei.logagent4networkcollege.repository;

import com.xjtushilei.logagent4networkcollege.entity.VisitLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author scriptshi
 * 2018/5/23
 */
public interface VisitLogElasticsearchRepository extends ElasticsearchRepository<VisitLog, String> {

}
