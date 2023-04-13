package com.interrait.Spring_Batch.batch;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.interrait.Spring_Batch.Model.EmployeeEntity;
import com.interrait.Spring_Batch.Repository.UserRepo;

@Component
public class DbWriter implements ItemWriter<EmployeeEntity>{
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public void write(Chunk<? extends EmployeeEntity> chunk) throws Exception {
		
		System.out.println("Data has saved for Employees:"+chunk);
		userRepo.saveAll(chunk);
	}

	
}
