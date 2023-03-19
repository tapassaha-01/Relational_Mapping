package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.Class;
import com.example.demo.dto.ClassWithTeacher;

public interface ClassRepository extends JpaRepository<Class, Long> {
	
	@Query(value="select * from teacher_table,class_table where class_table.appointed_tchr = ?1")
	public ClassWithTeacher findByAppointed_tchr(Long id);
	
}
