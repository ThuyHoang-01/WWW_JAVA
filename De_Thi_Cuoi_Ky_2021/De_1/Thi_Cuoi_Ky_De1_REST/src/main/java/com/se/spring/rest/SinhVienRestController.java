package com.se.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.spring.entity.Sinhvien;
import com.se.spring.service.LopService;
import com.se.spring.service.SinhvienService;

@RestController
@RequestMapping("/api")
public class SinhVienRestController {
	@Autowired
	private SinhvienService sinhvienService;

	@Autowired
	private LopService lopService;

	@GetMapping("/sinhviens/{lopId}") // Trả về list toàn bộ SinhVien của một lớp
	public List<Sinhvien> getSinhViens(@PathVariable int lopId) {
		return lopService.getSinhviens(lopId);
	}
	
	@GetMapping("/sinhviens/sinhvien/{sinhvienId}") // Trả về một Sinhvien từ sinhvienId
	public Sinhvien getSinhVien(@PathVariable int sinhvienId) {
		return sinhvienService.getSinhvien(sinhvienId);
	}

	@PostMapping("/sinhviens/{lopId}") // Add thêm một Sinhvien từ lopId
	public Sinhvien addSinhVien(@RequestBody Sinhvien sinhvien, @PathVariable int lopId) {
		sinhvien.setId(0);
		sinhvienService.saveSinhvien(sinhvien, lopId);
		return sinhvien;
	}

	@PutMapping("/sinhviens/{lopId}") // Add Sinhvien từ lopId
	public Sinhvien updateSinhVien(@RequestBody Sinhvien sinhvien, @PathVariable int lopId) {
		sinhvienService.updateSinhvien(sinhvien, lopId);
		return sinhvien;
	}

	@DeleteMapping("/sinhviens/{theId}") // Delete Sinhvien từ sinhvienId
	public String deleteSinhVien(@PathVariable int theId) {
		Sinhvien tempSinhvien = sinhvienService.getSinhvien(theId);
		// throw exception if null
		if (tempSinhvien == null) {
			throw new CustomNotFoundException("Sinhvien id not found - " + theId);
		}
		sinhvienService.deleteSinhvien(theId);
		return "Delete sinhvien id - " + theId;
	}

	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleException(CustomNotFoundException exc) {
		CustomErrorResponse error = new CustomErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<CustomErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
}
