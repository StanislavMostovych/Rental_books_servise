package ui;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import models.*;
import utilities.GenderType;

public class Main { 

	public static void main(String[] args) {

		
		MaterialCatalogInterface materialCatalog = new MaterialCatalogDB();
		
		Book book1 = new Book("1", "An inroduction to Java", "Matt Greencoft", "12345","anytowm Branch", 400);
		Book book2 = new Book("2", "WEW", "voievoemr", "530340","mewiocmwec", 350);
		Book book3 = new Book("3", "rewrwe", "voievoemr", "530340","mewiocmwec", 350);

		DVD dvd1 = new DVD("4","epic film","any","Stiven spilberg","5645",534534);
		DVD dvd2 = new DVD("5","fwefwef","any","Stiven spilberg","5645",534534);
		
//		System.out.println(dvd1.getTitle());
//		book1.recolate("MyCity branch");
		
		
//		materialCatalog.addMaterail(book1);
//		materialCatalog.addMaterail(book2);
//		materialCatalog.addMaterail(book3);
//		materialCatalog.addMaterail(dvd1);
//		materialCatalog.addMaterail(dvd2);
		
		// System.out.println("there are " + materialCatalog.getNumberOfMaterials() + "items in the library");
		
		
//		try
//		{
//			Material foundMaterial = materialCatalog.findMaterial("wew");
//		System.out.println("thisss is finded: " + foundMaterial + "item in the library");
//		}
//		catch(MaterialNotFoundException e)
//		{
//			System.out.println("no matching items found");
//		}
		
	//	System.out.println("ALL TABLES" + materialCatalog.getMaterialMap());
		
	UI ui = new UI();
ui.printHeader();

		
	ui.printMaterialCatalog(materialCatalog.getMaterialMap());
//		try 
//		{
//		Book foundBook = bookCatalog.findBook("Better");
//		System.out.println("We found" + foundBook.getTitle());
//		}
//		catch (BookNotFoundException e) {
//			System.out.println("the book wasnt found");
//			
//		}
//		
//		int myTest = 1;
//		try
//		{
//			if(myTest != 2) {
//				throw new RuntimeException("Something went wrong");
//		}
//		}
//			catch (RuntimeException e) {
//				// do nothing hre so that we can continue;
//		}
		
//		Customer customer = new Customer("MR", "Stan", "Smith", "1 st ave", "1223", "mail@.com", 1, GenderType.MALE);
//		System.out.println(customer.getExpiryDate());
//		System.out.println(customer.getMailingName());
//		
//		System.out.println(customer);
//		
//		System.out.println(customer.equals(customer));
//		
//
//		Loan firstLoan = new Loan(1,customer,book1);
//		System.out.println(firstLoan.getDueDate());
//		System.out.println(firstLoan);
//
//		LoanRegistry registry = new LoanRegistry();
//		
//		try {
//			registry.addLoad(firstLoan);
//			System.out.println("addLoan worked");
//		}
//		catch (LoanAlreadyExistsException e)
//		{
//			System.out.println("addLoan failde");
//		}
//		
//		System.out.println(registry.isBookOnLoan(book1.getID()));
//		firstLoan.endOfLoan();
//		System.out.println(registry.isBookOnLoan(book1.getID()));
	}
	}

	
