package com.interraIT.batchDemo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.interraIT.batchDemo.Model.Employee;
import com.interraIT.batchDemo.Model.EmployeeEntity;
import com.interraIT.batchDemo.Repository.UserRepo;
import com.interraIT.batchDemo.batch.DbWriter;


@Configuration
public class SpringBatchConfig {
		
	@Bean
	public Job job(JobBuilderFactory jobBuilder,
			StepBuilderFactory stepBuilder,
			ItemReader<Employee> itemReader,
			ItemProcessor<Employee, EmployeeEntity> itemProcessor,
			ItemWriter<EmployeeEntity> itemWriter,UserRepo userepo) {
		
		Step step= stepBuilder.get("Emp-file-load")
				.<Employee,EmployeeEntity>chunk(50) //50 is the batch size
				.reader(itemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.build();
		
		return jobBuilder.get("Emp-Load")
		.incrementer(new RunIdIncrementer())
		.start(step)
		.build();
//		
//		return job;
	}
	 
	

	@Bean
	public FlatFileItemReader<Employee> itemReader(){
		FlatFileItemReader<Employee> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new FileSystemResource("/batchDemo/src/main/resources/EMP.csv"));
		flatFileItemReader.setName("CsvReader");
		flatFileItemReader.setLinesToSkip(1); //lines to skip while reading xcel file,here skipping the first line because it is a header
		flatFileItemReader.setLineMapper(LineMapper());
		return flatFileItemReader;
	}

	//this method is to map the pojo class with xcel data
	@Bean
	public LineMapper<Employee> LineMapper() {
		
		DefaultLineMapper<Employee> defaultLineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		String[] fileds = {"id","name","address","designation"};
		
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(fileds);
		
		BeanWrapperFieldSetMapper<Employee> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Employee.class); // this funciton will automatically map the fileds with given pojo class
		
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		return defaultLineMapper;
	}
	
}
