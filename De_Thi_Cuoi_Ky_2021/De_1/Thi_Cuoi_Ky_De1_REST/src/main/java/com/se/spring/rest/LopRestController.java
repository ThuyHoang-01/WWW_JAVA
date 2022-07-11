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

import com.se.spring.entity.Lop;
import com.se.spring.service.LopService;

@RestController
@RequestMapping("/api")
public class LopRestController {
	@Autowired
	private LopService lopService;

	@GetMapping("/lops") // Trả về list toàn bộ Lop
	public List<Lop> getLops() {
		return lopService.getLops();
	}

	@GetMapping("/lops/{theId}") // Trả về một Lop tại lopId
	public Lop getLop(@PathVariable int theId) {
		Lop lop = lopService.getLop(theId);
		if (lop == null) {
			throw new CustomNotFoundException("Lop id not found - " + theId);
		}
		return lop;
	}

	@PostMapping("/lops")
	public Lop addLop(@RequestBody Lop lop) { // Add một Lop mới
		lop.setId(0);
		lopService.saveLop(lop);
		return lop;
	}

	@PutMapping("/lops")
	public Lop updateLop(@RequestBody Lop lop) { // Update Lop
		lopService.saveLop(lop);
		return lop;
	}

	@DeleteMapping("/lops/{theId}")
	public String deleteLop(@PathVariable int theId) { // Delete một Lop
		Lop tempLop = lopService.getLop(theId);
		// Quăng exception nếu không có Lop từ Id nhận vào
		if (tempLop == null) {
			throw new CustomNotFoundException("Lop id not found - " + theId);
		}
		lopService.deleteLop(theId);
		return "Delete lop id - " + theId;
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
