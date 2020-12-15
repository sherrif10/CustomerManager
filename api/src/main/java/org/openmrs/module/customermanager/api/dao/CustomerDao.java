package org.openmrs.module.customermanager.api.dao;

import java.util.List;

import org.openmrs.module.customermanager.Customer;

public interface CustomerDao {
	
	/**
	 * @see CustomerService#getCustomer(Integer)
	 */
	Customer getCustomer(Integer id);
	
	public Customer getCustomerByUuid(String uuid);
	
	public Customer getCustomerByPhoneNumber(Integer phoneNumber);
	
	public Customer getCustomerByLocation(String location);
	
	public Customer createCustomer(Customer customer);
	
	public Customer saveCustomer(Customer customer);
	
	public void retireCustomer(Customer customer);
	
	public List<Customer> getCustomer(Customer customer);
	
}
