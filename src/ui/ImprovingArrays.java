package ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import models.Book;

public class ImprovingArrays {

	public static void main(String[] args) {
		
		ArrayList<String> myArrayList= new ArrayList<String>();
		HashSet<String> myHashSet = new HashSet<String>();
		
		myArrayList.add("first item");
		boolean result =  myArrayList.add("second item");
		
		System.out.println(result);
		myArrayList.add("third item");
		myArrayList.add("fourth item");
		
		myHashSet.add("first item");
		myHashSet.add("second item");
		myHashSet.add("third item");
		myHashSet.add("fourth item");
		
		
		System.out.println(myArrayList.size());
		System.out.println(myHashSet.size());
		
		
		myArrayList.remove(1);
		myHashSet.remove("second item");
		System.out.println(myHashSet.size());
		
		myArrayList.add("first item");
		myArrayList.add(1, "first item");
		
		myHashSet.add("first item");		
		myHashSet.add("first item");		
		
		System.out.println(myArrayList.size());
		System.out.println(myHashSet.size());
		
		for(int i= 0; i < myArrayList.size(); i++) {
			System.out.println(myArrayList.get(i));
		}
		System.out.println("");
		Iterator<String> myIterator = myHashSet.iterator();
		
		while(myIterator.hasNext()) {
		String nextString = myIterator.next();
		System.out.println(nextString);
			
		}
		
		HashMap<String, Book> myHashmap = new HashMap<String, Book>();
		
//		Book book1 = new Book(1, "rist book", " dsds", "dfsd", "ref", 100);
//		Book book2 = new Book(2, "rist book", " dsds", "dfsd", "ref", 100);
//		Book book3 = new Book(3, "rist book", " dsds", "dfsd", "ref", 100);
	}

}
