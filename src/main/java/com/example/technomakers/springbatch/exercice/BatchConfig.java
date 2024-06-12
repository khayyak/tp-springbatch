package com.example.technomakers.springbatch.exercice;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:job.xml")
public class BatchConfig {

    private final JobLauncher jobLauncher;
    private final Job productJob;

    public BatchConfig(JobLauncher jobLauncher, Job productJob) {
        this.jobLauncher = jobLauncher;
        this.productJob = productJob;
    }

    public void runJob() throws Exception {
        jobLauncher.run(productJob, new JobParametersBuilder().toJobParameters());
    }

}