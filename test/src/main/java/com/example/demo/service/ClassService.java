package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ClassRepository;
import com.example.demo.Repository.TeacherRepository;
import com.example.demo.dto.Class;
import com.example.demo.dto.ClassWithTeacher;
import com.example.demo.dto.Teacher;
//import com.example.demo.dto.Student;
@Service
public class ClassService implements IClassService {

	@Autowired
	private ClassRepository clserviceRepo;
	
	@Autowired
	private TeacherRepository teacherRepo;
	
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

}
	