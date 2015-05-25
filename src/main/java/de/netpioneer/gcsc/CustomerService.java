package de.netpioneer.gcsc;

import java.util.List;

public interface CustomerService {

	boolean containsCustomer(Customer argCustomer);
	
	boolean deleteCustomer(Customer argCustomer);
	
	Customer findCustomerByName(String loginName) throws CustomerNotFoundException;
	
	List<Customer> findMaleAdultCustomers();
	
	List<Customer> getAllCustomers();
	
	void printSortedByAge();
	
	void printSortedByLastName();
	
}
