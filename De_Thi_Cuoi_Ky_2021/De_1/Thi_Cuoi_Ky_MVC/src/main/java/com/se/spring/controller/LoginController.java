package com.se.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	// Cấu hình trang hiển thị mặc định ban đầu
	@GetMapping("/")
	public String showFirstPage() {
		return "home";
	}
	
	// Cấu hình trang hiển thị home
	@GetMapping("/home")
	public String showHomePage() {
		return "home";
	}

	// Cấu hình trang login
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "fancy-login";
	}

	// Cầu hình trang khi bị access denied
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
	}
}
