package com.johndoeo.es.dao;

import com.johndoeo.es.model.Job;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Auther: JohnDoeo
 * @Date: 2019/7/3 14:19
 * @Description:
 */
@Repository
public interface JobDao extends ElasticsearchRepository<Job,Integer> {

}
