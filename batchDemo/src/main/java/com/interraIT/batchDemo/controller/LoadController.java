package com.interraIT.batchDemo.controller;



import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interraIT.batchDemo.config.SpringBatchConfig;

@RestController
@RequestMapping("/load")
public class LoadController {

	
	
	@Autowired
	Job job;
	@Autowired
	JobLauncher jobLauncher;
	
	
	
	@GetMapping
	public BatchStatus load() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
//		Map<String,Long> maps = new HashMap<String, Long>();
//		maps.put("timeStamp", new JobParameter(System.currentTimeMillis()));
		JobParameters parameter = new JobParameters();
		JobExecution jobExecution= jobLauncher.run(job, parameter);
		System.out.println("Job is Running...");
		while(jobExecution.isRunning()) {
			System.out.println(".....");
		}
		return jobExecution.getStatus();
	}
	
}
