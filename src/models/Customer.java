package models;
import java.util.Date;
import java.util.GregorianCalendar;

import utilities.GenderType;

public class Customer {
	private String title;
	private String FirstName;
	private String Surname;
	private String Adress;
	private String PhoneNumber;
	private String Email;
	private int CustomerNumber;
	private GenderType Gender;
	private boolean isValid;
	private Date expiryDate;
	
	public void setCustomer(String title, String FirstName, String Surname, String Adress , 
			String PhoneNumber, String Email, int CustomerNumber, GenderType Gender) {
		this.title = title;
		this.FirstName = FirstName;
		this.Surname =Surname;
		this.Adress = Adress;
		this.PhoneNumber = PhoneNumber;
		this.Email = Email;
		this.CustomerNumber = CustomerNumber;
		this.Gender = Gender;
		this.isValid = true;
		
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.add(GregorianCalendar.YEAR,1);
		this.expiryDate = gCal.getTime();
		
	}
	
	public Customer(String title, String FirstName, String Surname, String Adress, 
			String PhoneNumber, String Email, int CustomerNumber, GenderType Gender) {
		setCustomer(title, FirstName, Surname, Adress, PhoneNumber, Email, CustomerNumber, Gender);
		
	}
	
	public String getSurname() {
		return Surname;
	}
	
	public void getSurname(String surname) {
		this.Surname = surname;
	}
	
	public String getMailingName() {
		StringBuilder sb = new StringBuilder(title);
		sb.append(" ");
		sb.append(FirstName.substring(0,1));
		sb.append(" ");
		sb.append(Surname);
		
		return sb.toString();
	}
	
	public Date getExpiryDate() {
		return expiryDate;
	}

	@Override
	public String toString() {
		return getMailingName();
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (Adress == null) {
			if (other.Adress != null)
				return false;
		} else if (!Adress.equals(other.Adress))
			return false;
		if (CustomerNumber != other.CustomerNumber)
			return false;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (FirstName == null) {
			if (other.FirstName != null)
				return false;
		} else if (!FirstName.equals(other.FirstName))
			return false;
		if (Gender != other.Gender)
			return false;
		if (PhoneNumber == null) {
			if (other.PhoneNumber != null)
				return false;
		} else if (!PhoneNumber.equals(other.PhoneNumber))
			return false;
		if (Surname == null) {
			if (other.Surname != null)
				return false;
		} else if (!Surname.equals(other.Surname))
			return false;
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		if (isValid != other.isValid)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
}
