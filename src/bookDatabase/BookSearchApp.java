package bookDatabase;

import java.util.ArrayList;
import java.util.Scanner;

public class BookSearchApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * This is a program to store information of books into a database. It also
		 * allows you to search a book by its SKU, and display all information about
		 * this book
		 * 
		 * @author Grace
		 **/
		String contin = null;
		ArrayList<Book> arr = new ArrayList<Book>();
		int choice = 0;
		Scanner sc = new Scanner(System.in);

		// Initialize the book database by adding the 6 books into the book ArrayList
		arr = initDatabase();

		// do the following at least once, continue when the user does not choose 5.quit
		do {
			// display the menu
			System.out.println("\n\n===Menu===");
			System.out.println("1.Display all the books in database");
			System.out.println("2.Add a new entry to the database");
			System.out.println("3.Search a book by SKU");
			System.out.println("4.Search a book by Author/co-Author");
			System.out.println("5.Quit");

			System.out.println("Please choose from option 1 to 5:");
			choice = sc.nextInt();

			// To display all book in the database
			// including the 6 books originally in the database and the ones you will add
			if (choice == 1) {
				displayArrbooks(arr);
			}

			// Allow the user to create a book entry, and add all information of the book
			if (choice == 2) {

				// Allow the user to add a book entry at least once,
				// continue when the user choose to keep adding
				do {
					// Create a new instance of Product as an item in ArrayList
					Book onebook = new Book();

					// Prompt user input for SKU
					System.out.println("Input a SKU of the book:");
					sc.next();
					String SKU = sc.nextLine();
					onebook.setSku(SKU);

					// Prompt user input for title
					System.out.println("Input a Title of the book:");

					sc.next();
					String title = sc.nextLine();
					onebook.setTitle(title);

					// Prompt user input for an author
					System.out.println("Input the author of the book:");

					sc.next();
					String author = sc.nextLine();
					onebook.setAuthor(author);

					// Prompt user input for description
					System.out.println("Input the description of the book:");

					sc.next();
					String des = sc.nextLine();
					onebook.setDescription(des);

					// Prompt user input for price
					System.out.println("Input the price of the book:");

					sc.next();
					Double price = sc.nextDouble();
					onebook.setPrice(price);

					// prompt for choice of continue or not
					System.out.println("Would you like to add another book? y/n");
					sc.next();
					contin = sc.nextLine();

					// add this item in to the ArrayList
					arr.add(onebook);

				} while (contin.equalsIgnoreCase("y"));

			}

			// look up a book by SKU, loop through the ArrayList, if no match, print the
			// book is not in the database
			if (choice == 3) {
				System.out.println("Please enter the book SKU for searching.");
				sc.nextLine();
				String searchSKU = sc.nextLine();
				searchBySku(arr, searchSKU);

			}

			// look up a book by SKU, loop through the Author, if no match, print the book
			// is not in the database
			if (choice == 4) {

				System.out.println("Please enter the author for searching.");
				sc.nextLine();
				String searchAuthor = sc.nextLine();

				searchByAuthor(arr, searchAuthor);

			}

		} while (choice != 5);

		System.out.println("\n\nThank you for using this App!");

	}

	public static Book searchBySku(ArrayList<Book> arr, String SKU) {

		String exist = null;

		for (Book a : arr) {
			if (SKU.equalsIgnoreCase(a.getSku())) {
				exist = "yes";
				displaybook(a);
				return a;

			}
		}

		if (exist == null) {
			System.out.println("The book with this SKU is not in the database.");
		}
		return null;
	}

	public static Book searchByAuthor(ArrayList<Book> arr, String Author) {

		String existA = null;

		for (Book b : arr) {
			if (b.getAuthor().contains(Author)) {
				existA = "yes";
				displaybook(b);
				return b;

			}
		}

		if (existA == null) {
			System.out.println("The book written by this Author is not in the database.");
		}
		return null;

	}

	// This is a test example: a method for adding existing books into book database
	// This method is used in Main method
	public static ArrayList<Book> initDatabase() {

		ArrayList<Book> arrbook = new ArrayList<Book>();
		Book newBook1 = new Book();
		newBook1.set("Java1001", "Head First Java", "Kathy Sierra and Bert Bates", "Easy to read Java workbook", 47.50);

		Book newBook2 = new Book();
		newBook2.set("Java1002", "Thinking in Java", "Bruce Eckel", "Details about Java under the hood", 20.00);

		Book newBook3 = new Book();
		newBook3.set("Orcl1003", "OCP: Oracle Certified Professional Java SE", "Jeanne Boyarsky",
				"Everything you need to know in one place", 45.00);

		Book newBook4 = new Book();
		newBook4.set("Python1004", "Automate the Boring Stuff with Python", "Al Sweigart", "Fun with Python", 10.50);

		Book newBook5 = new Book();
		newBook5.set("Zombie1005", "The Maker's Guide to the Zombie Apocalypse", "Simon Monk",
				"Defend Your Base with Simple Circuits, Arduino, and Raspberry Pi", 16.50);

		Book newBook6 = new Book();
		newBook6.set("Rasp1006", "Raspberry Pi Projects for the Evil Genius", "Donald Norris",
				"A dozen fiendishly fun projects for the Raspberry Pi!", 14.75);

		arrbook.add(newBook1);
		arrbook.add(newBook3);
		arrbook.add(newBook4);
		arrbook.add(newBook5);
		arrbook.add(newBook6);

		return arrbook;

	}

	public static void displayArrbooks(ArrayList<Book> arr) {

		System.out.println("");
		System.out.println("----------------------------------------------------------------------------------------"
				+ "---------------------------------------------------------------------------------------------------");
		System.out.printf("\n" + "%6s%26s%40s%36s%52s", "SKU", "Title", "Author", "Description", "Price");
		System.out.println("\n--------------------------------------------------------------------------------------"
				+ "---------------------------------------------------------------------------------------------------");
		// Enhanced loop over the ArrayList arr and display the book database
		for (Book item : arr) {
			System.out.printf("\n" + "%-12s%-45s%-30s%-69s%-10s", item.getSku(), item.getTitle(), item.getAuthor(),
					item.getDescription(), item.getPrice());
		}

	}

	public static void displaybook(Book one) {
		System.out.println(
				"SKU: " + one.getSku() + "    " + "Title: " + one.getTitle() + "    " + "Author: " + one.getAuthor()
						+ "    " + "Description" + one.getDescription() + "    " + "Price: $" + one.getPrice());
	}
}

/*
 * other code hope to save: //BookDatabase db = new BookDatabase(); arr =
 * db.intidatabase();
 * 
 */

/*
 * 
 * Test results:
 * 
 * ===Menu=== 1.Display the all books in database 2.Add a new entry to the
 * database 3.Search a book by SKU 4.Search a book by Author/co-Author 5.Quit
 * Please choose from option 1 to 5: 2 Input a SKU of the book: Py001 Input a
 * Title of the book: Think Python Input the author of the book: Allen Downey
 * Input the description of the book: An introduction for design Input the price
 * of the book: 29.55 Would you like to add another book? y/n n
 * 
 * 
 * ===Menu=== 1.Display the all books in database 2.Add a new entry to the
 * database 3.Search a book by SKU 4.Search a book by Author/co-Author 5.Quit
 * Please choose from option 1 to 5: 1
 * 
 * -----------------------------------------------------------------------------
 * -----------------------------------------------------------------------------
 * ---------------------------------
 * 
 * SKU Title Author Description Price
 * -----------------------------------------------------------------------------
 * -----------------------------------------------------------------------------
 * -------------------------------
 * 
 * Java1001 Head First Java Kathy Sierra and Bert Bates Easy to read Java
 * workbook 47.5 Java1002 Thinking in Java Bruce Eckel Details about Java under
 * the hood 20.0 Orcl1003 OCP: Oracle Certified Professional Java SE Jeanne
 * Boyarsky Everything you need to know in one place 45.0 Python1004 Automate
 * the Boring Stuff with Python Al Sweigart Fun with Python 10.5 Zombie1005 The
 * Maker's Guide to the Zombie Apocalypse Simon Monk Defend Your Base with
 * Simple Circuits, Arduino, and Raspberry Pi 16.5 Rasp1006 Raspberry Pi
 * Projects for the Evil Genius Donald Norris A dozen fiendishly fun projects
 * for the Raspberry Pi! 14.75 Py001 Think Python Allen Downey An introduction
 * for design 29.55
 * 
 * ===Menu=== 1.Display the all books in database 2.Add a new entry to the
 * database 3.Search a book by SKU 4.Search a book by Author/co-Author 5.Quit
 * Please choose from option 1 to 5: 3 Please enter the book SKU for searching.
 * Java001 The book with this SKU is not in the database.
 * 
 * 
 * ===Menu=== 1.Display the all books in database 2.Add a new entry to the
 * database 3.Search a book by SKU 4.Search a book by Author/co-Author 5.Quit
 * Please choose from option 1 to 5: 4 Please enter the author for searching.
 * Downey SKU: Py001 Title: Think Python Author: Allen Downey DescriptionAn
 * introduction for design Price: $29.55
 * 
 * 
 * ===Menu=== 1.Display the all books in database 2.Add a new entry to the
 * database 3.Search a book by SKU 4.Search a book by Author/co-Author 5.Quit
 * Please choose from option 1 to 5: 5
 * 
 * 
 * Thank you for using this App!
 * 
 * 
 * 
 */
