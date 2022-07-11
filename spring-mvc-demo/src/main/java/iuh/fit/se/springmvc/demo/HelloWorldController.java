package iuh.fit.se.springmvc.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	@RequestMapping("processFormVersionTwo")
	public String letShoutDude(HttpServletRequest request, Model model) {
		// read the request parameter form html form
		String theName = request.getParameter("studentName");
		// convert data to all caps
		theName = theName.toUpperCase();
		// create the message
		String result = "Yo! " + theName;
		// add message to Model
		model.addAttribute("message", result);
		// return the name of view (jsp page)
		return "helloworld";
	}

	@RequestMapping("processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		// convert data to all caps
		theName = theName.toUpperCase();
		// create the message
		String result = "Hey my friend !!!" + theName;
		// add message to Model
		model.addAttribute("message", result);
		// return the name of view (jsp page)
		return "helloworld";
	}
}
