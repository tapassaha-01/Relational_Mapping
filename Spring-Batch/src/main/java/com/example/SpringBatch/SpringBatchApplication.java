package com.example.SpringBatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchApplication implements CommandLineRunner{

	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		JobParameters parameter = new JobParameters();
		JobExecution jobExecution= jobLauncher.run(job, parameter);
		System.out.println("Job is Running...");
		while(jobExecution.isRunning()) {
			System.out.println(".....");
		}
		System.out.println("Job has completed...!!");
	}

}
