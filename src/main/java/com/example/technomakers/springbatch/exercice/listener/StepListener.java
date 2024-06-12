package com.example.technomakers.springbatch.exercice.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;


public class StepListener extends StepExecutionListenerSupport {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(StepListener.class);

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("Before Step: {}", stepExecution.getStepName());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        log.info("After Step: {}", stepExecution.getStepName());
        return stepExecution.getExitStatus();
    }
}
