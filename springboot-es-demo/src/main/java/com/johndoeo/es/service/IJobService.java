package com.johndoeo.es.service;

import com.johndoeo.es.model.Job;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Auther: JohnDoeo
 * @Date: 2019/7/3 14:21
 * @Description:
 */
public interface IJobService {
    long count();

    Job save(Job job);

    void delete(Job job);

    Iterable<Job> getAll();

    List<Job> getByName(String company);

    Page<Job> pageQuery(Integer pageNo, Integer pageSize, String company);

    Page<Job>  getByJob(Integer pageNo, Integer pageSize, Job job);
}
