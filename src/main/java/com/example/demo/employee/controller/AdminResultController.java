package com.example.demo.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminResultController {

	
	@PostMapping("/admin/edit/result")
	public String postResult() {
		return "redirect:/employee";
	}
}
