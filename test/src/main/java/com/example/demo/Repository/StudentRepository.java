package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
}
