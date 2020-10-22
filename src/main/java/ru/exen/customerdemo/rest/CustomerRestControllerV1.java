package ru.exen.customerdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ru.exen.customerdemo.model.Customer;
import ru.exen.customerdemo.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers/")
public class CustomerRestControllerV1 {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long customerId){
		if (customerId == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Customer customer = this.customerService.getById(customerId);
		
		if(customer == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Customer> saveCustomer(@RequestBody @Validated Customer customer){
		HttpHeaders headers= new HttpHeaders();
		
		if (customer == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		this.customerService.save(customer);
		return new ResponseEntity<>(customer, headers, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Customer> updateCustomer(@RequestBody @Validated Customer customer, UriComponentsBuilder builder){
		HttpHeaders headers= new HttpHeaders();
		
		if (customer == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		this.customerService.save(customer);
		
		return new ResponseEntity<>(customer, headers, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id){
		Customer customer = this.customerService.getById(id);
		
		if(customer == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		this.customerService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> customers = this.customerService.getAll();
		
		if (customers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
}
