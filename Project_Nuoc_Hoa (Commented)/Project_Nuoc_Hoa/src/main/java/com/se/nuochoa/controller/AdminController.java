package com.se.nuochoa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin") // Trang được bắt đầu bằng /admin
public class AdminController {
	
	// Cấu hình request map đến trang admin
	@GetMapping("/")
	public String showAdminPage() {
		return "admin";
	}
	
}
