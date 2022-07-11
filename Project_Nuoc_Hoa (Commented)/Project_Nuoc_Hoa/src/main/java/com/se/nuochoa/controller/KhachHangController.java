package com.se.nuochoa.controller;

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

import com.se.nuochoa.entity.KhachHang;
import com.se.nuochoa.service.KhachHangService;

@Controller
@RequestMapping("/khachhang") // Trang được bắt đầu bằng /khachhang
public class KhachHangController {
	
	// Tự động nhúng các Bean 
	// Nó sẽ tìm kiếm bean có tên là KhachHangDao trong container của nó ,sau đó nhúng (hoặc tiêm) vào lớp KhachHangServiceImpl. 
	// Đây chính là cơ chế DI (dependency injection). 
	@Autowired
	private KhachHangService khachHangService;

	// Cấu hình ràng buộc các tham số yêu cầu (nghĩa là dữ liệu biểu mẫu hoặc truy vấn) với một đối tượng mô hình
	// Chuyển đổi các giá trị yêu cầu dựa trên chuỗi (chẳng hạn như tham số yêu cầu, biến đường dẫn, tiêu đề, cookie và các giá trị khác) thành loại đích của đối số phương thức bộ điều khiển
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	// Cấu hình trang hiển thị list Khachhang
	@GetMapping("/list")
	public String ListKhachHang(Model model) {
		List<KhachHang> khachHang = khachHangService.getKhachHangs();
		model.addAttribute("khachhangs", khachHang);
		return "khachhang-list";
	}

	// Cấu hình trang save Khachhang
	// Cấu hình annotation @Valid @ModelAttribute ràng buộc dữ liệu khi Save
	@PostMapping("/saveKhachHang")
	public String saveKhachHang(@Valid @ModelAttribute("khachhang") KhachHang khachHang, BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "khachhang-form";	
		} else {
			khachHangService.saveKhachHang(khachHang);
			return "redirect:/khachhang/list";
		}
	}

	// Cấu hình trang update Khachhang
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("khachhangId") String theId, Model theModel) {
		KhachHang khachHang = khachHangService.getKhachHang(theId);
		theModel.addAttribute("khachhang", khachHang);
		return "khachhang-form";
	}

	// Cấu hình trang add Khachhang
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		KhachHang khachHang = new KhachHang();
		theModel.addAttribute("khachhang", khachHang);
		return "khachhang-form";
	}

	// Cấu hình trang delete Khachhang
	@GetMapping("/delete")
	public String deleteKhachHang(@RequestParam("khachhangId") String theId) {
		khachHangService.deleteKhachHang(theId);
		return "redirect:/khachhang/list";
	}

}
