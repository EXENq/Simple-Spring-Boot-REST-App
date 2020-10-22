package ru.exen.customerdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.exen.customerdemo.model.Customer;

/*
 * Repository interface for {@link Customer} class.
 */

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
}
