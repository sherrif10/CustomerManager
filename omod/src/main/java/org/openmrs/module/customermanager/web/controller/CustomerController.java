package org.openmrs.module.customermanager.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.PatientService;
import org.openmrs.module.customermanager.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	PatientService patientService;
	
	/** Success form view name */
	private final String VIEW = "/module/customermanager/customer";
	
	@RequestMapping(value = "module/customermanager/customer.form", method = RequestMethod.GET)
	public ModelAndView getCustomer() {
		ModelAndView mav = new ModelAndView("customer");
		
		return mav;
	}
	
	@RequestMapping(value = "/module/customermanager/customerslist", method = RequestMethod.GET)
	public ArrayList<Customer> getCustomerList() {
		
		Customer customer = new Customer();
		customer.setLocation("india");
		customer.setPhoneNumber("0775533555");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String formatted = df.format(new Date());
		
		Customer customer1 = new Customer();
		customer1.setLocation("Uganda");
		customer1.setPhoneNumber("075424553433");
		Date date = java.util.Calendar.getInstance().getTime();
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
		
		ArrayList<Customer> customersList = new ArrayList<Customer>();
		customersList.add(customer);
		customersList.add(customer1);
		return customersList;
		
	}
	
}
