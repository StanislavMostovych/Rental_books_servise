package models;

import java.util.Date;
import java.util.GregorianCalendar;

import utilities.StatusType;

public class Loan {
	private int ID;
	private Customer customer;
	private Book book;
	private Date startDate;
	private Date dueDate;
	private Date returnDate;
	private StatusType status;
	
	


	
	public Loan(int iD, Customer customer, Book book) {
		super();
		ID = iD;
		this.customer = customer;
		this.book = book;
		startDate = new Date();
		
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.add(GregorianCalendar.DAY_OF_WEEK, 14);
		this.dueDate = gCal.getTime();
		
		status = StatusType.CURRENT;
		
	}
	

	@Override
	public String toString() {
		return "Loan [ID=" + ID + ", customer=" + customer.getMailingName() + ", book=" + book.getTitle() + "]";
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		if (ID != other.ID)
			return false;
		return true;
	}


	public Customer getCustomer() {
		return customer;
	}


	public Book getBook() {
		return book;
	}


	public Date getDueDate() {
		return dueDate;
	}
	
	public StatusType getStatus() {
		return status;
	}

	public void endOfLoan() {
		returnDate = new Date();
		status = StatusType.HISTORIC;
	}
	
	
	
	
	
	
}
