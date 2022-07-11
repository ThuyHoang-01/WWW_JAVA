package com.se.spring.controller;

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
import com.se.spring.model.Sinhvien;
import com.se.spring.service.LopService;
import com.se.spring.service.SinhvienService;

@Controller
@RequestMapping("/sinhvien") 
public class SinhvienController {
	@Autowired
	private SinhvienService sinhvienService;

	@Autowired
	private LopService lopService;

	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@PostMapping("/saveSinhvien*")
	public String saveSinhvien(@Valid @ModelAttribute("sinhvien") Sinhvien sinhvien, @RequestParam("lopId") int lopId,
			BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "sinhvien-form";
		} else {
			sinhvienService.saveSinhvien(sinhvien, lopId);
			return "redirect:/sinhvien/list?lopId=" + lopId;
		}
	}

	
	@PostMapping("/updateSinhvien*")
	public String updateSinhvien(@Valid @ModelAttribute("sinhvien") Sinhvien sinhvien, @RequestParam("lopId") int lopId,
			BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "sinhvien-form";
		} else {
			sinhvienService.updateSinhvien(sinhvien, lopId);
			return "redirect:/sinhvien/list?lopId=" + lopId;
		}
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel, @RequestParam("lopId") int lopId) {
		Sinhvien sinhvien = new Sinhvien();
		theModel.addAttribute("sinhvien", sinhvien);
		theModel.addAttribute("lopId", lopId);
		theModel.addAttribute("isUpdate", false);
		return "sinhvien-form";
	}


	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("lopId") int lopId, @RequestParam("sinhvienId") int sinhvienId,
			Model theModel) {
		Sinhvien sinhvien = sinhvienService.getSinhvien(sinhvienId);
		theModel.addAttribute("sinhvien", sinhvien);
		theModel.addAttribute("lopId", lopId);
		theModel.addAttribute("isUpdate", true);

		return "sinhvien-form";
	}

	
	@GetMapping("/delete")
	public String deleteSinhvien(@RequestParam("sinhvienId") int sinhvienId, int lopId) {
		sinhvienService.deleteSinhvien(sinhvienId);
		return "redirect:/sinhvien/list?lopId=" + lopId;
	}


	@GetMapping("/list")
	public String listSinhvien(@RequestParam("lopId") int lopId, Model theModel) {
		Lop lop = lopService.getLop(lopId);
		theModel.addAttribute("lop", lop);
		return "sinhvien-list";
	}
}
