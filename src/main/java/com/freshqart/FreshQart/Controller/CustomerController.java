package com.freshqart.FreshQart.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.freshqart.FreshQart.Repository.CustomerRepository;
import com.freshqart.FreshQart.View.CustomerVO;

public class CustomerController {

	@Autowired
	private CustomerRepository customerRepo;
	
	 @PostMapping("/customers/create")
	  public CustomerVO createBook(@Valid @RequestBody CustomerVO customer) {
	    System.out.println("Create Customer: " + customer + "...");
	 
	    return customerRepo.save(customer);
	  }
}