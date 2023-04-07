package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ClassRepository;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Repository.TeacherRepository;
import com.example.demo.dto.Class;
import com.example.demo.dto.ClassAssociatedStudentDto;
import com.example.demo.dto.ClassWithTeacher;
import com.example.demo.dto.Student;
import com.example.demo.dto.Teacher;
//import com.example.demo.dto.Student;
@Service
public class ClassService implements IClassService {

	@Autowired
	private ClassRepository clserviceRepo;
	
	@Autowired
	private TeacherRepository teacherRepo;
	
	@Autowired
	private StudentRepository stuRepo;
	
	@Override
	public String addClass(ClassWithTeacher cls_tchr) {
		Class cls = cls_tchr.getCls();
		Teacher tchr = cls_tchr.getTchr();
		//most important step *****
		teacherRepo.save(tchr);
		cls.setTchr(tchr);
		tchr.setCls(cls);
		Class Cls = clserviceRepo.save(cls);
//		Teacher tch = teacherRepo.save(tchr);
		if(Cls!=null ) {
			System.out.println(Cls.getTchr());
			return "Class added sucessfully.";
		}
		return "not saved!!!";
//		return null;
	}

	@Override
	public String addStuClasses(ClassAssociatedStudentDto cls_ass_stu) {
		if(cls_ass_stu!=null) {
		Student stu = cls_ass_stu.getApp_student();
		List<Class> stu_app_cls = cls_ass_stu.getStu_cls_list();
		List<Class> cls_list = stu.getStu_cls_list();
//		stu_app_cls.stream().map(e->e.setStudent(stu));
//		stu_app_cls.stream().map(e->cls_list.add(e));
		for(Class i:stu_app_cls) {
			i.setStudent(stu);
		}
		stu.setStu_cls_list(stu_app_cls);
		stuRepo.save(stu);
		stu_app_cls.stream().map(e->clserviceRepo.save(e));
//		Map<String, List<Class>> resultMap = new HashMap<String, List<Class>>();
//		resultMap.put(stu.getStu_name(),stu.getStu_cls_list());
		return "class added sucessfullyy";}
		else {
			return "give perfect value..";
		}
		
	}

	
	
	

}
	