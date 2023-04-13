package com.example.SpringBatch.config;

import java.util.HashMap;
import java.util.Map;



import org.springframework.batch.item.ItemProcessor;

import com.example.SpringBatch.Model.Employee;
import com.example.SpringBatch.Model.EmployeeEntity;

public class Processor implements ItemProcessor<Employee, EmployeeEntity>{
	
private static final Map<String, Long> SALARY_VALUE=new HashMap<String,Long>();
	
 	Processor() {
 		SALARY_VALUE.put("A", 60000L);
 		SALARY_VALUE.put("B", 45000L);
 		SALARY_VALUE.put("C", 25000L);
 	}

	@Override
	public EmployeeEntity process(Employee emp) throws Exception {
		 String designation = emp.getDesignation();
		 Long salary = SALARY_VALUE.get(designation);
		return new EmployeeEntity(emp.getName(),emp.getAddress(),salary);
	}

}
