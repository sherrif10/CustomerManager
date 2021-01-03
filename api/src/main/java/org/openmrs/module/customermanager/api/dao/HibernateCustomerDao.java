package org.openmrs.module.customermanager.api.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.openmrs.module.customermanager.Customer;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateCustomerDao implements CustomerDao {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private SessionFactory sessionFactory;
	
	@Autowired
	Customer customer;
	
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public List<Customer> getAllCustomers() {
		return sessionFactory.getCurrentSession().createCriteria(Customer.class).list();
		
	}
	
	@Override
	public Customer getCustomer(Integer customerId) {
		return (Customer) sessionFactory.getCurrentSession().get(Customer.class, customerId);
	}
	
	@Override
	public Customer createCustomer(Customer customer) {
		sessionFactory.getCurrentSession().save(customer);
		return customer;
	}
	
	@Override
	public void retireCustomer(Customer customer) {
		sessionFactory.getCurrentSession().delete(customer);
	}
	
	@Override
	public Customer getCustomerByUuid(String uuid) {
		return (Customer) sessionFactory.getCurrentSession().get(Customer.class, uuid);
		
	}
	
	@Override
	public Customer getCustomerByPhoneNumber(Integer phoneNumber) {
		return (Customer) sessionFactory.getCurrentSession().get(Customer.class, phoneNumber);
	}
	
	@Override
	public Customer getCustomerByLocation(String location) {
		return (Customer) sessionFactory.getCurrentSession().get(Customer.class, location);
	}
	
	@Override
	public List<Customer> listAll(Customer customer) {
		return (List<Customer>) sessionFactory.getCurrentSession().get(Customer.class, (Serializable) customer);
	}
	
	@Override
	public Customer saveCustomer(Customer customer) {
		sessionFactory.getCurrentSession().save(customer);
		return customer;
	}
	
}
