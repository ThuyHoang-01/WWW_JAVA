package iuh.fit.se.springmvc.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		// Create the Student
		Student theStudent = new Student();
		// Add student to the Model
		theModel.addAttribute("student", theStudent);
		return "student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());
		return "student-confirmation";
	}
}
