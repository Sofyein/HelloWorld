package com.auto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auto.model.Customer_Test;
import com.auto.service.Customer_TestService;

@RestController
@CrossOrigin
public class Customer_TestController {

	@Autowired
	private Customer_TestService customer_testService;
	
	@GetMapping("/customer_tests")
	public List<Customer_Test> findAll() {
		return customer_testService.findAll();
	}
	
	@GetMapping("/customer_tests/{id}")
	public Customer_Test find(@PathVariable String id) {
		return customer_testService.find(id);
	}
	
	
	@PostMapping("/customer_tests")
	public Customer_Test save(@RequestBody Customer_Test customer_test) {
		return customer_testService.save(customer_test);
	}
	
	@DeleteMapping("/customer_tests/{id}")
	public void delete(@PathVariable String id) {
		customer_testService.delete(id);
	}

	@PutMapping("/customer_tests/convertoarray")
	public List<String[]> convertVersionsToArrays(@RequestBody List<Customer_Test> customer_tests) {
		return customer_testService.convertVersionsToArrays(customer_tests);
	}
 }