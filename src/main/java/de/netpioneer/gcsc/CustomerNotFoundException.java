package de.netpioneer.gcsc;

public class CustomerNotFoundException extends Exception {

	private static final long serialVersionUID = 680359043026436997L;
	
	public CustomerNotFoundException(String lastName) {
		super("Customer '" + lastName + "' not found.");
	}

}
