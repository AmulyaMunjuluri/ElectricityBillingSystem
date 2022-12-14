package com.project.ElectricityBillingSystem.Controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.ElectricityBillingSystem.Entity.CustomerEntity;
import com.project.ElectricityBillingSystem.Exceptions.CustomerFoundException;
import com.project.ElectricityBillingSystem.Exceptions.CustomerNotFoundException;
import com.project.ElectricityBillingSystem.Services.CustomerServices;
import com.project.ElectricityBillingSystem.dto.CustDto;
import com.project.ElectricityBillingSystem.dto.RegRespDto;
import com.project.ElectricityBillingSystem.dto.RegisterDto;


@RestController
//allows to handle all rest APIs such get,post,put/patch,delete requests
public class CustomerController {

	//used to autowire bean on the setter method just like @Required annotation
	@Autowired
	private CustomerServices customerServices;
	
	// mapping HTTP GET requests onto specific handler methods
	//get all Customers
	@GetMapping("/customer")
	public List<CustomerEntity> getAllLogin() {
		return customerServices.getAllCustomer();
	}
	
	@GetMapping("/customer/{id}")
	public Optional<CustomerEntity> getLoginById(@PathVariable int id) throws CustomerNotFoundException {
		return customerServices.getCustomer(id);
	}
	
	@GetMapping ("/customer/dto/{id}")
	public Optional<CustDto> getCustDtoById(@PathVariable int id) throws CustomerNotFoundException {
		return customerServices.getCustDtoById(id);
	}
	
	 //Register customer
		@PostMapping("/customer/register")
		public RegRespDto regCustomer(@Valid @RequestBody RegisterDto customerEntity)  throws CustomerFoundException{
	    return customerServices.regCustomer(customerEntity);
		}
		
	
	// add customer
	@PostMapping("/customer")
	public CustomerEntity addLogin(@Valid @RequestBody CustomerEntity customerEntity) {
		return customerServices.addCustomer(customerEntity);
	}
	
	
	@PutMapping("customer/{id}")
	public CustomerEntity updateLogin(@PathVariable int id,@Valid @RequestBody CustomerEntity customerEntity) throws CustomerNotFoundException {
		return customerServices.updateCustomer(id, customerEntity);
	}
	
	@PutMapping ("/customer/dto/{id}")
	public CustDto updateCustDtoById(@PathVariable int id,@Valid @RequestBody CustDto custDto ) throws CustomerNotFoundException {
		return customerServices.updateCustDtoById(id, custDto);
	}
	
	@DeleteMapping("/customer/{id}")
	public Optional<CustomerEntity> deleteLogin(@PathVariable int id) throws CustomerNotFoundException {
		return customerServices.deleteCustomer(id);
	}
}
