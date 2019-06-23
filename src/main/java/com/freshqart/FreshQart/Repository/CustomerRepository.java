package com.freshqart.FreshQart.Repository;

import org.springframework.data.repository.CrudRepository;

import com.freshqart.FreshQart.Models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
