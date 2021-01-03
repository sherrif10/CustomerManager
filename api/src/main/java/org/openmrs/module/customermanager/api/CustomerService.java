package org.openmrs.module.customermanager.api;

import java.util.List;

import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.customermanager.Customer;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CustomerService extends OpenmrsService {
	
	/**
	 * So basically this method returns customer with id it is fetched at run time if it is fetched
	 * 
	 * @param id
	 * @return
	 */
	@Authorized()
	@Transactional(readOnly = false)
	public Customer getCustomerById(Integer id) throws APIException;;
	
	/**
	 * this returns a customer with location name throws IllegalArgumentException if given null
	 * should return null if no match was found
	 * 
	 * @param location
	 * @return
	 */
	@Authorized
	@Transactional(readOnly = false)
	public Customer getCustomerByLocation(String location);
	
	/**
	 * this also returns a customer retrieved by phonenumber throws IllegalArgumentException if
	 * given null should return null if no match was found
	 * 
	 * @param phoneNumber
	 * @return
	 */
	@Authorized
	@Transactional(readOnly = false)
	public Customer getCustomerByPhoneNumber(Integer phoneNumber);
	
	/**
	 * this returns customer by its uuid
	 * 
	 * @param uuid
	 * @return
	 */
	@Transactional(readOnly = false)
	public Customer getCustomerByUuid(String uuid);
	
	/**
	 * Creates a new customer in the customer datatase
	 * 
	 * @param customer
	 * @return
	 */
	public Customer createCustomer(Customer customer) throws APIException;
	
	/**
	 * Saves a new customer in the customer datatase
	 * 
	 * @param customer
	 * @return
	 */
	@Authorized
	public Customer saveCustomer(Customer customer);
	
	/**
	 * This removes customer from the database completely
	 * 
	 * @param customer
	 */
	@Authorized
	public void purgeCustomer(Customer customer, String reason);
	
	/**
	 * return the customers should return empty list if no match was found
	 * 
	 * @param customer
	 * @return
	 */
	public List<Customer> listAll(Customer customer);
	
}
