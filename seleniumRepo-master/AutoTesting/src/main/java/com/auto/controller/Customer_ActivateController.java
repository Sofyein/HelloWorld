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

import com.auto.model.Customer_Activate;
import com.auto.service.Customer_ActivateService;

@RestController
@CrossOrigin
public class Customer_ActivateController {

	@Autowired
	private Customer_ActivateService customer_activateService;
	
	@GetMapping("/customer_activates")
	public List<Customer_Activate> findAll() {
		return customer_activateService.findAll();
	}
	
	@GetMapping("/customer_activates/{id}")
	public Customer_Activate find(@PathVariable String id) {
		return customer_activateService.find(id);
	}
	
	
	@PostMapping("/customer_activates")
	public Customer_Activate save(@RequestBody Customer_Activate customer_activate) {
		return customer_activateService.save(customer_activate);
	}
	
	@DeleteMapping("/customer_activates/{id}")
	public void delete(@PathVariable String id) {
		customer_activateService.delete(id);
	}

	@PutMapping("/customer_activates/convertoarray")
	public List<String[]> convertVersionsToArrays(@RequestBody List<Customer_Activate> customer_activates) {
		return customer_activateService.convertVersionsToArrays(customer_activates);
	}
 }