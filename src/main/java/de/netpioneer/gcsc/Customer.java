package de.netpioneer.gcsc;

public class Customer {

	private String loginName;
	
	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private Gender gender;

	public Customer(String loginName, String firstName, String lastName,
			int age, Gender gender) {
		this.loginName = loginName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}

	public String getLoginName() {
		return loginName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public Gender getGender() {
		return gender;
	}
	
}