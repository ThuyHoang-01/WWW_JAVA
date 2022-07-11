package com.se.nuochoa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	// Cấu hình trang hiển thị home
	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}

	// Cấu hình trang login
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "fancy-login";
	}

	// Cấu hình trang access-denied
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
	}
	
	// Cấu hình trang logout
	@GetMapping("/logout")
	public String showLogoutPage() {
		return "home";
	}
}
