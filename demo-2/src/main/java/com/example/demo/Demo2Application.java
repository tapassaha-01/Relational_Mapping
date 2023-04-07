package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo2Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	
	}
	
	@Override
	public void run(String... args) throws FileNotFoundException {
		File file = new File("/demo-2/src/main/resources/StudentDetails.txt");
		Scanner sc = new Scanner(file);
		while(sc.hasNext()) {
		System.out.println(sc.nextLine());}
	}

}
