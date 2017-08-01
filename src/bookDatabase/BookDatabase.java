package bookDatabase;

import java.util.ArrayList;

import revisedVersion.Book;

public class BookDatabase {

	
	ArrayList <Book> bookList;
	
	public BookDatabase() {
		this.bookList = new ArrayList<Book>();
				
	}
	
	public ArrayList<Book> searchByauthor(String author){
		return new ArrayList<Book>(); 
	}
	
	public ArrayList<Book> getBookList(){
		return bookList;
	}
	
	public void addBook(Book bookToAdd) {
		bookList.add(bookToAdd); 
	}
	

	

}
