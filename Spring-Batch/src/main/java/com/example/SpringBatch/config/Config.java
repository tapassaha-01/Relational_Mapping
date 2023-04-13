package com.example.SpringBatch.config;



import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.example.SpringBatch.Model.Employee;
import com.example.SpringBatch.Model.EmployeeEntity;
import com.example.SpringBatch.Repository.EmployeeRepo;

@Configuration
public class Config {

	@Autowired
	public JobBuilderFactory  jobBuilder;
	@Autowired
	public StepBuilderFactory stepBuilder;
	@Autowired
	public EmployeeRepo empRepo;
	
	@Bean
	public ItemReader<Employee> itemReader(){
		
		FlatFileItemReader<Employee> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new FileSystemResource("EMP.csv"));
		System.out.println("inside Reader");
		flatFileItemReader.setName("CsvReader");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(lineMapper());
		return flatFileItemReader;
	}

	
	private LineMapper<Employee> lineMapper() {
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
		return defaultLineMapper;
	}
	
	
	@Bean
	public Processor processor() {
		return new Processor();
	}
	
	
	@Bean
	public RepositoryItemWriter<EmployeeEntity> itemWriter(){
		RepositoryItemWriter<EmployeeEntity> writer = new RepositoryItemWriter<>();
		writer.setRepository(empRepo);
		writer.setMethodName("saveAll");
		return writer;
	}
	
	
	@Bean
	public Step step() {
		return stepBuilder.get("CSV-reader")
				.<Employee, EmployeeEntity> chunk(50)
				.reader(itemReader())
				.processor(processor())
				.writer(itemWriter())
				.build();
				
	}
	
	@Bean
	public Job job() {
		return jobBuilder.get("CSV-job")
				.incrementer(new RunIdIncrementer())
				.start(step())
				.build();
	}
	
}

