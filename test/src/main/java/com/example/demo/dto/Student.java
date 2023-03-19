package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_table")
public class Student {
	@Id
	private long stu_id;
	@Column
	private String stu_name;
	@Column
	private String stu_class;
	
//	@OneToMany(mappedBy = "student")
//	private List<Teacher> stu_tchr_list;
//	
	@ManyToMany(mappedBy = "student_list",cascade = CascadeType.ALL)
	private List<Class> stu_cls_list = new ArrayList<>();

	public long getStu_id() {
		return stu_id;
	}

	public void setStu_id(long stu_id) {
		this.stu_id = stu_id;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_class() {
		return stu_class;
	}

	public void setStu_class(String stu_class) {
		this.stu_class = stu_class;
	}

	public List<Class> getStu_cls_list() {
		return stu_cls_list;
	}

	public void setStu_cls_list(List<Class> stu_cls_list) {
		this.stu_cls_list = stu_cls_list;
	}

	public Student() {
		super();
	}
	
	
}
