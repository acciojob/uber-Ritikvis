package com.driver.services.impl;

import java.util.List;
import java.util.Optional;

import com.driver.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.model.Admin;
import com.driver.model.Customer;
import com.driver.model.Driver;
import com.driver.repository.AdminRepository;
import com.driver.repository.CustomerRepository;
import com.driver.repository.DriverRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository1;

	@Autowired
	DriverRepository driverRepository1;

	@Autowired
	CustomerRepository customerRepository1;

	@Override
	public void adminRegister(Admin admin) {
		//Save the admin in the database
		adminRepository1.save(admin);
	}

	@Override
	public Admin updatePassword(Integer adminId, String password) {
		//Update the password of admin with given id
		if(adminRepository1.findById(adminId).isPresent()){
			Admin admin = adminRepository1.findById(adminId).get();
			admin.setPassword(password);
			adminRepository1.save(admin);
			return admin;
		}
		return null;
	}

	@Override
	public void deleteAdmin(int adminId){
		// Delete admin without using deleteById function
		if(adminRepository1.findById(adminId).isPresent()){
			Admin admin = adminRepository1.findById(adminId).get();
			adminRepository1.delete(admin);
		}

	}

	@Override
	public List<Driver> getListOfDrivers() {
		//Find the list of all drivers
		return driverRepository1.findAll();

	}

	@Override
	public List<Customer> getListOfCustomers() {
		//Find the list of all customers
		return customerRepository1.findAll();

	}

}