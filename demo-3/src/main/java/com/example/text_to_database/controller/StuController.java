package com.example.text_to_database.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.text_to_database.StudentRepo.StudentRepo;
import com.example.text_to_database.entity.Student;



public class StuController {

	@Autowired
	private StudentRepo sturepo;
	
public void addStudent(Student stu) {
	
	Student st = sturepo.save(stu);
	System.out.println("Student saved to database sucessfully!!  :"+st);
	
}
}
