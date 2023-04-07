package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Class;
import com.example.demo.dto.ClassAssociatedStudentDto;
import com.example.demo.dto.ClassWithTeacher;
import com.example.demo.dto.Student;
import com.example.demo.dto.Teacher;
import com.example.demo.service.IClassService;
import com.example.demo.service.IstudentService;

@RestController
@RequestMapping("/testController")
public class Controller {
	
	@Autowired
	private IstudentService stuServiceRepo;
	
	@Autowired
	private IClassService clsServiceRepo;
	
	@GetMapping("/addStudent")
	public String addStudent(@RequestBody Student stu) {
		return stuServiceRepo.addStudent(stu);
	}
	
	@GetMapping("/addClass")
	public String addClass(@RequestBody ClassWithTeacher cls_tchr) {
		return clsServiceRepo.addClass(cls_tchr);
	}
	
	@GetMapping("/addStuClasses")
	public String addStuClasses(@RequestBody ClassAssociatedStudentDto cls_ass_stu){
		return clsServiceRepo.addStuClasses(cls_ass_stu);
	}
}
