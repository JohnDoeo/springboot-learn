package com.johndoeo.es.service.impl;


import com.johndoeo.es.dao.JobDao;
import com.johndoeo.es.model.Job;
import com.johndoeo.es.service.IJobService;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: JohnDoeo
 * @Date: 2019/7/3 14:21
 * @Description:
 */
@Service
public class JobServiceImpl implements IJobService {

    @Autowired
    private JobDao jobDao;

    public long count(){
        return jobDao.count();
    }

    public Job save(Job job){
        return jobDao.save(job);
    }

    public void delete(Job job){
        jobDao.delete(job);
    }

    public Iterable<Job> getAll(){
        return jobDao.findAll();
    }

    public List<Job> getByName(String company){
        List<Job> jobList = new ArrayList<>();
        MatchQueryBuilder queryCondition = new MatchQueryBuilder("company", company);
        Iterable<Job> jobs = jobDao.search(queryCondition);
        jobs.forEach(job-> jobList.add(job));
        return jobList;
    }

    public Page<Job> pageQuery(Integer pageNo, Integer pageSize, String company){
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchPhraseQuery("company", company))
                .withPageable(PageRequest.of(pageNo, pageSize))
                .build();
        return jobDao.search(searchQuery);
    }

    public Page<Job> getByJob(Integer pageNo, Integer pageSize, Job job){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        Field[] fields = job.getClass().getDeclaredFields();

        Method[] methods = Job.class.getMethods();
        for(Field field:fields){
            for(Method method:methods){
                if(method.getName().startsWith("get") && method.getName().toLowerCase().contains(field.getName().toLowerCase())){
                    try {
                        nativeSearchQueryBuilder.withQuery(QueryBuilders.matchPhraseQuery(field.getName(),method.invoke(job)));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        nativeSearchQueryBuilder.withPageable(PageRequest.of(pageNo, pageSize));
        SearchQuery searchQuery = nativeSearchQueryBuilder.build();
        return jobDao.search(searchQuery);
    }
}
