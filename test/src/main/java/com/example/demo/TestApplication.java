package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dto.Class;
import com.example.demo.dto.Teacher;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
		
		
	}
//	public void run() throws Exception{
//		Class cls = new Class();
//		Teacher tchr = new Teacher();
//		tchr.setTchr_id(1);
//		tchr.setTchr_name("Tapas");
//		cls.setCls_id(10);
//		cls.setCls_name("Math");
//		cls.setTchr(tchr);
//	}

}
