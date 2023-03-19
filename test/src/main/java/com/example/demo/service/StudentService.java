package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.StudentRepository;
import com.example.demo.dto.Student;

@Service
public class StudentService implements IstudentService {

	@Autowired
	private StudentRepository stuRepo;
	
	@Override
	public String addStudent(Student stu) {
		Student st = stuRepo.save(stu);
		if(st!=null) {
			return "student added sucessfully.";
		}
		return "not saved!!!";
	}

}
