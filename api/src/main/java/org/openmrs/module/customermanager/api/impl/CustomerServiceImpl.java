package org.openmrs.module.customermanager.api.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.openmrs.api.APIException;
import org.openmrs.api.context.Context;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.customermanager.Customer;
import org.openmrs.module.customermanager.api.CustomerService;
import org.openmrs.module.customermanager.api.dao.CustomerDao;
import org.openmrs.api.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class CustomerServiceImpl extends BaseOpenmrsService implements CustomerService {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	CustomerService customerService;
	
	UserService UserService;
	
	/**
	 * @param dao the dao to set
	 */
	public void setCustomerDao(CustomerDao dao) {
		this.customerDao = dao;
	}
	
	/**
	 * @return the dao
	 */
	public CustomerDao getCustomerDao() {
		return customerDao;
	}
	
	public void setUserService(UserService userService) {
		this.UserService = userService;
	}
	
	@Override
	public Customer getCustomerByUuid(String uuid) throws APIException {
		return customerDao.getCustomerByUuid(uuid);
	}
	
	@Override
	@Transactional
	public synchronized Customer saveCustomer(Customer customer) {
		if (customer == null) {
			throw new IllegalArgumentException("customer cannot be null");
		}
		return customerDao.saveCustomer(customer);
		
	}
	
	@Transactional
	public synchronized void retireCustomer(Customer customer, String reason) {
		if (customer == null) {
			throw new IllegalArgumentException("customer cannot be null");
		}
		if (StringUtils.isBlank(reason)) {
			throw new IllegalArgumentException(Context.getMessageSourceService().getMessage("general.void.reason.empty"));
		}
		return;
		
	}
	
	@Override
	public Customer getCustomerById(Integer id) throws APIException {
		if (id == null) {
			throw new IllegalArgumentException("id cannot be null");
		}
		return customerDao.getCustomer(id);
	}
	
	@Override
	public Customer getCustomerByLocation(String location) {
		if (location == null) {
			throw new IllegalArgumentException("location cannot be null");
		}
		return customerDao.getCustomerByLocation(location);
	}
	
	@Override
	public Customer getCustomerByPhoneNumber(Integer phoneNumber) {
		if (phoneNumber == null) {
			throw new IllegalArgumentException("phonenumber cannot be null");
		}
		return customerDao.getCustomerByPhoneNumber(phoneNumber);
	}
	
	public List<Customer> listAll(Customer customer) {
		return customerDao.listAll(customer);
	}
	
	@Override
	public Customer createCustomer(Customer customer) throws APIException {
		return customerDao.createCustomer(customer);
	}
	
	@Override
	public void purgeCustomer(Customer customer, String reason) {
		return;
	}
	
}
