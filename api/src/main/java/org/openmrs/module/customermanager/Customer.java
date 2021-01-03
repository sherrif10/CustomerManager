package org.openmrs.module.customermanager;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.openmrs.BaseOpenmrsData;

@Table(name = "customermanager_customer")
public class Customer extends BaseOpenmrsData {
	
	@Id
	@GeneratedValue
	@Column(name = "customermanager_customer_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "Location")
	private static String Location;
	
	@ManyToOne
	@JoinColumn(name = "PhoneNumber")
	private String PhoneNumber;
	
	@Override
	public String getUuid() {
		return super.getUuid();
	}
	
	@Override
	public void setUuid(String uuid) {
		super.setUuid(uuid);
	}
	
	public Customer() {
		super();
		this.id = id;
		PhoneNumber = getPhoneNumber();
	}
	
	public static String getLocation() {
		return Location;
	}
	
	public void setLocation(String location) {
		Location = location;
	}
	
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Customer saveCustomer(Customer customer) {
		return customer;
		
	}
}
