package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="class_table")
public class Class {
	@Id
	private long cls_id;
	
	@Column
	private String cls_name;
	
	//one foreign key is created appointed_tchr -> tchr_id(primary key)
	@OneToOne
	@JoinColumn(name="appointed_tchr")
	private Teacher tchr;
	
	@ManyToMany
	private List<Student> student_list = new ArrayList<>();

	public long getCls_id() {
		return cls_id;
	}

	public void setCls_id(long cls_id) {
		this.cls_id = cls_id;
	}

	public String getCls_name() {
		return cls_name;
	}

	public void setCls_name(String cls_name) {
		this.cls_name = cls_name;
	}

	public Teacher getTchr() {
		return tchr;
	}

	public void setTchr(Teacher tchr) {
		this.tchr = tchr;
	}

	public List<Student> getStudent_list() {
		return student_list;
	}

	public void setStudent_list(List<Student> student_list) {
		this.student_list = student_list;
	}

	public Class() {
		super();
	}
	


	
	
}
