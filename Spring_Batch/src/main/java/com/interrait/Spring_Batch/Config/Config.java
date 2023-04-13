package com.interrait.Spring_Batch.Config;

import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.interrait.Spring_Batch.Model.Employee;

@Configuration
public class Config {
	
	@Autowired
	JobBuilder jobBuilder;
	
	@Autowired
	StepBuilder stepBuilder;
	
	@Bean
	 ItemReader<Employee> itemReader(){
		
		FlatFileItemReader<Employee> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new FileSystemResource("/Spring_Batch/src/main/resources/EMP.csv"));
		flatFileItemReader.setName("CsvReader");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(LineMapper());
		return flatFileItemReader;
	}
	
	@Bean
	private LineMapper<Employee> LineMapper() {
		DefaultLineMapper<Employee> defaultLineMapper = new DefaultLineMapper<>();
		String[] fileds = {"id","name","address","designation"};
		
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(fileds);
		
		BeanWrapperFieldSetMapper<Employee> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Employee.class);
		
		
		
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		return null;
	}
	
	
	
}
