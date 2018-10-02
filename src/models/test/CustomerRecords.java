package models.test;

import java.util.HashSet;

import models.Customer;

public class CustomerRecords {

	private HashSet<Customer> records;

	public CustomerRecords() {
		records = new HashSet<Customer>();
	}

	public void add(Customer customer) {
		records.add(customer);
	}

	public Customer findByName(String name) throws CustomerNotFoundException {
		for (Customer customer : records) {
			if (customer.getMailingName().equals(name)) {
				return customer;
			}
		}
		throw new CustomerNotFoundException();
	}
}
