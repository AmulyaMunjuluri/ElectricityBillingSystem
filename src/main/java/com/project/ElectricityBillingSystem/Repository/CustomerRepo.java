package com.project.ElectricityBillingSystem.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.ElectricityBillingSystem.Entity.CustomerEntity;

//used to indicate that the class provides the mechanism for storage, retrieval, search, update and 
//delete operation on objects
@Repository
public interface CustomerRepo   extends JpaRepository<CustomerEntity,Integer>  {


	
	
}
