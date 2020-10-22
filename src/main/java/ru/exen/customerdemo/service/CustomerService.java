package ru.exen.customerdemo.service;

import java.util.List;

import ru.exen.customerdemo.model.Customer;

public interface CustomerService {
	
	Customer getById(Long id);
	
	void save(Customer customer);
	
	void delete(Long id);
	
	List<Customer> getAll();

}
