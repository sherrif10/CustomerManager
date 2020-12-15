package org.openmrs.module.customermanager.api.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.openmrs.api.APIException;
import org.openmrs.api.context.Context;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.customermanager.Customer;
import org.openmrs.module.customermanager.api.CustomerService;
import org.openmrs.module.customermanager.api.dao.CustomerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class CustomerServiceImpl extends BaseOpenmrsService implements CustomerService {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	private CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao dao) {
		this.customerDao = dao;
	}
	
	@Override
	@Transactional
	public Customer createCustomer(Customer customer) throws APIException {
		Customer createdCustomer = new Customer();
		createdCustomer.getId();
		createdCustomer.getLocation();
		createdCustomer.getPhoneNumber();
		if (createdCustomer.getLocation() != null) {
			return createdCustomer;
		}
		
		return customerDao.createCustomer(customer);
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
	public List<Customer> getCustomer(Customer customer) {
		return customerDao.getCustomer(customer);
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
	
	@Override
	public Customer getCustomerByUuid(String uuid) {
		if (uuid == null) {
			throw new IllegalArgumentException("uuid cannot be null");
		}
		return customerDao.getCustomerByUuid(uuid);
	}
	
}
