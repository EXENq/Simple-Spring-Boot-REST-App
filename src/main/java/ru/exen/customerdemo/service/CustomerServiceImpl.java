package ru.exen.customerdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ru.exen.customerdemo.model.Customer;
import ru.exen.customerdemo.repository.CustomerRepository;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer getById(Long id) {
		log.info("IN CustomerServiceImpl getById {}", id);
		return customerRepository.getOne(id);
	}

	@Override
	public void save(Customer customer) {
		log.info("IN CustomerServiceImpl save {}", customer);
		customerRepository.save(customer);
	}

	@Override
	public void delete(Long id) {
		log.info("IN CustomerServiceImpl delete {}", id);
		customerRepository.deleteById(id);
	}

	@Override
	public List<Customer> getAll() {
		log.info("IN CustomerServiceImpl getAll");
		return customerRepository.findAll();
	}
	
}
