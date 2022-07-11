package com.se.spring.rest;

import java.util.ArrayList;
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

import com.se.spring.entity.Customer;
import com.se.spring.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers") // return list of all customers
	public List<Customer> getCustomers(){
			return customerService.getCustomers();
	}

	@GetMapping("/customers/{customerId}") // return single customer at index
	public Customer getCustomer(@PathVariable int customerId) {
		Customer theCustomer = customerService.getCustomer(customerId);
		if(theCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		}
		return theCustomer;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	@DeleteMapping("/customers")
	public String deleteCustomer(@PathVariable int customerId) {
		Customer tempCustomer = customerService.getCustomer(customerId);
		//throw exception if null
		if(tempCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		}
		customerService.deleteCustomer(customerId);
		return "Delete customer id - " + customerId;
	}

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc) {
		CustomerErrorResponse error = new CustomerErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<CustomerErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
}
