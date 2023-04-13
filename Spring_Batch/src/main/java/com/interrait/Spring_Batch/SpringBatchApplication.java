package com.interrait.Spring_Batch;

import java.util.Collection;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.batch.core.Job;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.interrait.Spring_Batch.Config.Config;
import com.interrait.Spring_Batch.Model.Employee;
import com.interrait.Spring_Batch.Model.EmployeeEntity;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchApplication implements CommandLineRunner {
	
	@Autowired
	JobLauncher joblauncher;
	
	@Autowired
	Config configuration;
	
	@Autowired
	JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	ItemWriter<EmployeeEntity> itemWriter;
	
	@Autowired
	ItemProcessor<Employee, EmployeeEntity> itemProcessor;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchApplication.class, args);

	}
	
	
	
	@Bean
	public Step step() {
		
		return stepBuilderFactory.get("Csv-File=load")
				.<Employee,EmployeeEntity> chunk(50)
				.reader(configuration.itemReader())
				.processor(itemProcessor)
				.writer(itemWriter)
				.build();
	}

	@Bean
	public Job job() {
		return jobBuilderFactory
				.get("CSV-reader")
				.incrementer(new RunIdIncrementer())
				.start(step())
				.build();
	}


	@Override
	public void run(String... args) throws Exception {
		JobParameters parameter = new JobParameters();
		JobExecution jobExecution=joblauncher.run(job(), parameter);
		System.out.println("Job is Running...");
		while(jobExecution.isRunning()) {
			System.out.println(".....");
		}
		System.out.println(jobExecution.getStatus());
	}
}
