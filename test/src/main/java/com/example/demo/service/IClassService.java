package com.example.demo.service;

import java.util.List;
import java.util.Map;



import com.example.demo.dto.Class;
import com.example.demo.dto.ClassAssociatedStudentDto;
import com.example.demo.dto.ClassWithTeacher;


public interface IClassService {

	public String addClass(ClassWithTeacher cls_tchr);
	public String addStuClasses(ClassAssociatedStudentDto cls_ass_stu);
}
