/**
 * 
 */
package com.synerzip.template.cucumber.model;


/**
 * @author rohitghatol
 *
 */

public class Customer {

	private String firstName;
	private String lastName;
	
	protected Customer() {}
	public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
