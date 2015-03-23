package com.synerzip.template.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.synerzip.template.cucumber.model.Customer;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BasicStepdefs {
	private String BASE_URL = null;

	private RestTemplate rest = new RestTemplate();

	@Before
	public void setup() throws IOException {

	}

	@After
	public void destroy() {

	}

	@Given("^App is running on (.*?)$")
	public void setAppUrl(String url){
		BASE_URL=url+"apis/customers";
	}
	
	@When("^I store a new Customer\\[firstname=\"(.*?)\",lastname=\"(.*?)\"$")
	public void storeCustomer(String firstName,String lastName) throws Throwable {
		System.out.println("When I store a Customer[firstName=\""+firstName+"\",lastName=\""+lastName+"\"]");
		
		Customer customer = new Customer(firstName, lastName);
		ResponseEntity<Customer> response = rest.postForEntity(BASE_URL,customer, Customer.class);
		Customer returnedCustomer = response.getBody();
		assertEquals(customer.getFirstName(), returnedCustomer.getFirstName());
		assertEquals(customer.getLastName(), returnedCustomer.getLastName());

		

	}

	

	@Then("^I expect to see Customer\\[firstname=\"(.*?)\",lastname=\"(.*?)\" in List of Customers$")
	public void i_expect_to_see(String firstName,String lastName) throws Throwable {
		System.out.println("I expect to see Customer[firstname=\""+firstName+"\",lastname=\""+lastName+"\" in List of Customers");
		
		ResponseEntity<Customer[]> response = rest.getForEntity(BASE_URL,
				Customer[].class);

		Customer customer = new Customer(firstName, lastName);
		Customer[] customers = response.getBody();
		
		boolean matchfound=false;
		for(Customer entity:customers){
			if(entity.getFirstName().equals(customer.getFirstName()) && entity.getLastName().equals(customer.getLastName())){
				matchfound = true;
			}
		}
		
		assertTrue("Did not find Customer in return list",matchfound);
	}
}
