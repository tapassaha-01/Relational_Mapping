package com.example.demo.dto;

import java.util.List;

public class ClassAssociatedStudentDto {

	private Student app_student;
	
	private List<Class> stu_cls_list;
	
	public Student getApp_student() {
		
		return app_student;
	}
	public void setApp_student(Student app_student) {
		this.app_student = app_student;
	}
	public List<Class> getStu_cls_list() {
		return stu_cls_list;
	}
	public void setStu_cls_list(List<Class> stu_cls_list) {
		this.stu_cls_list = stu_cls_list;
	}
	@Override
	public String toString() {
		return "ClassAssociatedStudentDto [app_student=" + app_student + ", stu_cls_list=" + stu_cls_list + "]";
	}
	public ClassAssociatedStudentDto(Student app_student, List<Class> stu_cls_list) {
		super();
		this.app_student = app_student;
		this.stu_cls_list = stu_cls_list;
	}
	
}
