package com.interrait.Spring_Batch.batch;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.interrait.Spring_Batch.Model.Employee;
import com.interrait.Spring_Batch.Model.EmployeeEntity;


@Component
public class Processor implements ItemProcessor<Employee, EmployeeEntity> {

 	private static final Map<String, Long> SALARY_VALUE=new HashMap<String,Long>();
	
 	private Processor() {
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
