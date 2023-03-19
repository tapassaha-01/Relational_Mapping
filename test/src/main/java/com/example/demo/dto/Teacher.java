package com.example.demo.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "teacher_table")
public class Teacher {
	
	@Id
	private long tchr_id;
	
	@Column
	private String tchr_name;
	
	//cls is mapped by the tchr member of that class entity
	@OneToOne(mappedBy = "tchr",cascade = CascadeType.ALL)
	private Class cls;
//	
	public Teacher() {
		super();
	}

	public long getTchr_id() {
		return tchr_id;
	}

	@Override
	public String toString() {
		return "Teacher [tchr_id=" + tchr_id + ", tchr_name=" + tchr_name + ", cls=" + cls + "]";
	}
//
	public void setTchr_id(long tchr_id) {
		this.tchr_id = tchr_id;
	}

	public String getTchr_name() {
		return tchr_name;
	}

	public void setTchr_name(String tchr_name) {
		this.tchr_name = tchr_name;
	}

	public Class getCls() {
		return cls;
	}

	public void setCls(Class cls) {
		this.cls = cls;
	}

	
	
//	@OneToMany(mappedBy = "teacher_table")
//	private List<Student> stulist;
}
