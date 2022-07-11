package com.se.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.spring.model.Lop;
import com.se.spring.service.LopService;

@Controller
@RequestMapping("/lop") 
public class LopController {
	@Autowired
	private LopService lopService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/list")
	public String listLop(Model model) {
		List<Lop> lopList = lopService.getLops();
		model.addAttribute("lops", lopList);
		return "lop-list";
	}

	@PostMapping("/saveLop")
	public String saveLop(@Valid @ModelAttribute("lop") Lop lop, BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "lop-form";
		} else {
			lopService.saveLop(lop);
			return "redirect:/lop/list";
		}
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("lopId") int theId, Model theModel) {
		Lop lop = lopService.getLop(theId);
		theModel.addAttribute("lop", lop);
		return "lop-form";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		Lop lop = new Lop();
		theModel.addAttribute("lop", lop);
		return "lop-form";
	}

	@GetMapping("/delete")
	public String deleteLop(@RequestParam("lopId") int theId) {
		lopService.deleteLop(theId);
		return "redirect:/lop/list";
	}
}
