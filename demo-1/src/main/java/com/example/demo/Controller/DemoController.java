package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.userDto;

@Controller
public class DemoController {

	@RequestMapping(value="/controller")
	public String HomePage(Model model) {
		System.out.println("opening From");
		int h =7;
		return "Login";
	}
	
}
