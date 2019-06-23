package com.freshqart.FreshQart.Services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.freshqart.FreshQart.Models.Customer;
import com.freshqart.FreshQart.Repository.CustomerRepository;
import com.freshqart.FreshQart.View.CustomerVO;

public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer CreateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	private boolean validateCustomerInfo(CustomerVO customer) {
		boolean isValid = true;
		if (customer.getCustomerId() < 0 || StringUtils.isNoneEmpty(customer.getFirstName()) ||
				StringUtils.isNotEmpty(customer.getLastName()) || StringUtils.isNotEmpty(customer.getAddressLine1()) ||
				StringUtils.isNotEmpty(customer.getAddressLine2()) || StringUtils.isNotEmpty(customer.getCity()) ||
				StringUtils.isNotEmpty(customer.getState()) || StringUtils.isNotEmpty(customer.getCountry()) ||
				StringUtils.isNotEmpty(customer.getZipCode()) || StringUtils.isNotEmpty(customer.getPhoneNumber())) {
			isValid = false;
		}
		
		return isValid;
	}
	
}
