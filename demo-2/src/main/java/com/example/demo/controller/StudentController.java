package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Entity.Student;
import com.example.demo.repo.StudentRepo;

public class StudentController {

	@Autowired
	private StudentRepo sturepo;
	
public void addStudent(Student stu) {
	
	Student st = sturepo.save(stu);
	System.out.println("Student saved to database sucessfully!!  :"+st);
	
}
	
}
