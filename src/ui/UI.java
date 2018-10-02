package ui;
import java.util.HashMap;
import java.util.Map;


import models.*;

public class UI {
	public void printHeader() {
		System.out.println("BookID    Title                  Author");
		
	}
	public void printBook(Book book) {
		String bookIDString = String.valueOf(book.getID());
		System.out.println(fixLengthString(bookIDString, 8) + " " + fixLengthString(book.getTitle(), 20) + 
				" " + fixLengthString(book.getAuthor(), 20));
	}
	private String fixLengthString(String start, int lenght) {
		// TODO: fix string padding problem
		if(start.length() >= lenght) {
			return start.substring(0, lenght);
		}else {
			while(start.length() < lenght) {
				start += " ";
			}
			return start;
		}
	}
	
		public void printMaterialCatalog(Map<String, Material> materialCatalog) {
			for(Material nextMaterial : materialCatalog.values())
				{
					System.out.println(nextMaterial.toString());
				}
	}
}
