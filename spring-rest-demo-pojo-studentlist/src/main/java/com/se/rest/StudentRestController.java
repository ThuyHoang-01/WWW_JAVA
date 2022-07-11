package com.se.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	@GetMapping("/students") // return list of all students
	public List<Student> getStudents() {
		List<Student> theStudents = new ArrayList<Student>();

		theStudents.add(new Student("Poorima", "Patel"));
		theStudents.add(new Student("Mario", "Rossi"));
		theStudents.add(new Student("Mary", "Smith"));

		return theStudents;
	}

	@GetMapping("/students/{studentId}") // return single student at index
	public Student getStudents(@PathVariable int studentId) {
		List<Student> theStudents = new ArrayList<Student>();

		theStudents.add(new Student("Poorima", "Patel"));
		theStudents.add(new Student("Mario", "Rossi"));
		theStudents.add(new Student("Mary", "Smith"));

		// Ktra xem studentId truyen vao co hop le hay khong
		if ((studentId >= theStudents.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student is not found " + studentId);
		}

		/*
		 * // Ktra xem studentId truyen vao co hop le hay khong - Su dung global exception handlers 
		 * if ((studentId >= theStudents.size()) || (studentId < 0))
		 * { throw new Exception("Student is not found " + studentId); }
		 */

		return theStudents.get(studentId);
	}

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
}
