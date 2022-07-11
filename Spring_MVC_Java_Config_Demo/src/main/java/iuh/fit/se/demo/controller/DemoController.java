package iuh.fit.se.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/land")
	public String showLanding() {
		return "landing";
	}
}
