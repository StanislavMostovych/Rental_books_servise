package models;

public class Book extends Material {
	
	private String author;
	private String isbn;
	private int noOfPages;
	
	public Book(String id, String title, String author, String isbn, String branch, int noOfPages) {
		super(id,title,branch);
		
		this.author = author;
		this.isbn = isbn;
		this.noOfPages = noOfPages;
	}
	
	public String getAuthor() {
		return author;
	}
	public String getIsbn() {
		return isbn;
	}
	
	public void senForRepair() {
		System.out.println("Book has beeen sent for repair");
	}
	
	public int getLoanPeriod() {
		return 21;
	}
	
	public int getNoofPages() {
		return noOfPages;
	}
	
	@Override
	public String toString() {
		return "BOOK: " + getID() + " " + getTitle() + "/ " + getAuthor(); 
	}
	
	
}
