package com.example.technomakers.springbatch.exercice.listener;


import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;


public class JobListener extends JobExecutionListenerSupport {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(JobListener.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("Before Job: {}", jobExecution.getJobInstance().getJobName());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("After Job: {}", jobExecution.getJobInstance().getJobName());
    }
}
