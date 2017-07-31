package revisedVersion;

import java.util.ArrayList;

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
