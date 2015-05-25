package de.netpioneer.gcsc;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class CustomerServiceImpl implements CustomerService {

	private List<Customer> customers = new ArrayList<>();
	
	public CustomerServiceImpl() {
		super();
	}
	
	public boolean containsCustomer(final Customer argCustomer) {
		if (customers.contains(argCustomer) == true) {
			return true;
		} else {
			return false;
		}
	}

	/**
	* Deletes the given {@link Customer}.
	* @param argCustomer customer to delete
	* @return true if the customer has been deleted, false otherwise.
	*/
	public boolean deleteCustomer(Customer argCustomer) {
		// Check if we have a customer in our list.
		// If we don't have one, we return false as
		// the customer hasn't been deleted actually.
		if (containsCustomer(argCustomer)){
			// Remove the customer.
			// We could also directly return the result of remove()
			customers.remove(argCustomer);
			// Return true to communicate the result
			return true;
		}
		// Return false if the customer could not be found
		return false;
	}

	public Customer findCustomerByName(String loginName) throws CustomerNotFoundException {
		if (loginName != null && !loginName.equals("")) {
			for (Customer customer : customers) {
				if (customer.getLoginName().equals(loginName)) {
					return customer;
				}
			}
		}
		throw new CustomerNotFoundException(loginName);
	}

	public List<Customer> findMaleAdultCustomers() {
		List<Customer> custFound = new ArrayList<>();
		for (int i = 0; i < customers.size(); i++) {
		if (customers.get(i).getAge() < 18)
					continue;
			else
			{
				if (customers.get(i).getGender() != Gender.FEMALE)
			custFound.add(customers.get(i)); }
		}
		return custFound;
	}
	
	public List<Customer> findMaleAdultCustomers_v2() {
		List<Customer> maleAdultCustomers = new ArrayList<>();
		for (Customer customer : customers) {
			if (isMale(customer) && isAdult(customer)) {
				maleAdultCustomers.add(customer);
			}
		}
		return maleAdultCustomers;
	}
	
	private boolean isMale(Customer customer) {
		return customer.getGender() == Gender.MALE;
	}
	
	private boolean isAdult(Customer customer) {
		return customer.getAge() >= 18;
	}

	public List<Customer> getAllCustomers() {
		return customers;
	}

	public void printSortedByAge() {
		Iterator<Customer> iter = customers.iterator();
		ArrayList<String> list = new ArrayList<String>();
		while (iter.hasNext()) {
			Customer customer = iter.next();
			list.add(customer.getAge() + " " + customer.getLoginName());
		}
		Collections.sort(list);
		Iterator<String> iter2 = list.iterator();
		while (iter2.hasNext()) {
			try {
				String str = iter2.next();
				System.out.println(
						findCustomerByName(str.substring(str.lastIndexOf(" ") + 1)));
			} catch (CustomerNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void printSortedByAge_v2() {
		List<Customer> customersToSort = new ArrayList<>(customers);
		
		Collections.sort(customersToSort, new AgeComparator());
		
		for (Customer customer : customersToSort) {
			System.out.println(customer);
		}
	}

	public void printSortedByLastName() {
		SortedSet<Customer> sortedCustomers= new TreeSet<Customer>(new LastNameComparator());
		sortedCustomers.addAll(customers);
		
		for (Customer customer : sortedCustomers) {
			System.out.println(customer);
		}
	}
	
	public void printSortedByLastName_v2() {
		Collections.sort(customers, new LastNameComparator());
		
		for (Customer customer : customers) {
			System.out.println(customer);
		}		
	}
	
	public void concatenateStrings(Customer customer) {
		String firstName = customer.getFirstName();
		String lastName = customer.getLastName();
		String loginName = customer.getLoginName();
		
		String concatenatedStrings;
		
		concatenatedStrings = new StringBuilder().append("Der Kunde ").append(firstName).append(" ").append(lastName)
		.append(" hat den Loginnamen ").append(loginName).append(".").toString();
		
		concatenatedStrings = MessageFormat.format("Der Kunde {0} {1} hat den Loginnamen {2}.", firstName, lastName, loginName);
		
		concatenatedStrings = String.format("Der Kunde %s %s hat den Loginnamen %s.", firstName, lastName, loginName);
		
		concatenatedStrings = "Der Kunde " + firstName + " " + lastName + " hat den Loginnamen " + loginName + ".";
		
		System.out.println(concatenatedStrings);
	}

}
