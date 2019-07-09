package com.johndoeo.es;

import com.johndoeo.es.model.Job;
import com.johndoeo.es.service.IJobService;
import com.mock.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootEsDemoApplicationTests {


    private static final Logger log = LoggerFactory.getLogger(SpringbootEsDemoApplicationTests.class);

    @Autowired
    private IJobService jobService;

    @Test
    public void contextLoads() {
        Iterable<Job> all = jobService.getAll();
        int count = 0;
        for(Job job:all){
            System.err.println(job);
            count++;
        }
        System.err.println(count);
    }

    @Test
    public void saveJobs(){
        for(int i = 0;i < 10;i ++){
            Job save = jobService.save(Mock.mock(Job.class));
            System.err.println(save);
        }
//        System.err.println(Mock.mock(int.class));
    }

    @Test
    public void findById(){
        List<Job> byName = jobService.getByName("科软信息");
        byName.forEach(job->System.err.println(job));
    }

    /**
     * 这个还有问题，会报错
     */
    @Test
    public void findByJob(){
        Job job = new Job();
        job.setCompany("久弘信息");
//        job.setId(15662);
        Page<Job> byJob = jobService.getByJob(1, 10, job);
        byJob.forEach(job1 -> System.err.println(job1));
    }

    @Test
    public void delete(){
        Job job = new Job();
        job.setId(14666);
        jobService.delete(job);
        job.setId(14667);
        jobService.delete(job);
//        job.setId(3385);
//        jobService.delete(job);
//        job.setId(2799);
//        jobService.delete(job);
//        job.setId(638);
//        jobService.delete(job);
//        job.setId(3508);
//        jobService.delete(job);
//        job.setId(4953);
//        jobService.delete(job);
    }

    @Test
    public void testOutputLog(){
        log.trace("trace 日志输出成功了");
        log.debug("debug 日志输出成功了");
        log.info("info 日志输出成功了");
        log.warn("warn 日志输出成功了");
        log.error("error 日志输出成功了");
    }

}
