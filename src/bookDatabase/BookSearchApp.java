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
		String existA = null;
		int choice = 0;

		// Initialize the book database by adding the 6 books into the book ArrayList
		BookDatabase db = new BookDatabase();
		arr = db.initDatabase();

		// do the following at least once, continue when the user does not choose 5.quit
		do {
			// display the menu
			System.out.println("\n\n===Menu===");
			System.out.println("1.Display the all books in database");
			System.out.println("2.Add a new entry to the database");
			System.out.println("3.Search a book by SKU");
			System.out.println("4.Search a book by Author/co-Author");
			System.out.println("5.Quit");

			System.out.println("Please choose from option 1 to 5:");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();

			// To display all book in the database
			// including the 6 books originally in the database and the ones you will add
			if (choice == 1) {
				System.out.println("");
				System.out.println(
						"----------------------------------------------------------------------------------------"
								+ "---------------------------------------------------------------------------------------------------");
				System.out.printf("\n" + "%6s%26s%40s%36s%52s", "SKU", "Title", "Author", "Description", "Price");
				System.out.println(
						"\n--------------------------------------------------------------------------------------"
								+ "---------------------------------------------------------------------------------------------------");
				// Enhanced loop over the ArrayList arr and display the book database
				for (Book item : arr) {
					System.out.printf("\n" + "%-12s%-45s%-30s%-69s%-10s", item.getSku(), item.getTitle(),
							item.getAuthor(), item.getDescription(), item.getPrice());
				}
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
				sc.next();
				String searchSKU = sc.nextLine();

				searchBySku(arr, searchSKU);
			}

			// look up a book by SKU, loop through the Author, if no match, print the book
			// is not in the database
			if (choice == 4) {

				System.out.println("Please enter the author for searching.");
				sc.next();
				String searchAuthor = sc.nextLine();

				int counterA = 0;

				while (existA != "yes" && counterA < arr.size()) {

					existA = null;

					if (arr.get(counterA).getAuthor().contains(searchAuthor)) {
						System.out.println("SKU: " + arr.get(counterA).getSku() + "    " + "Title: "
								+ arr.get(counterA).getTitle() + "    " + "Author: " + arr.get(counterA).getAuthor()
								+ "    " + "Description" + arr.get(counterA).getDescription() + "    " + "Price: $"
								+ arr.get(counterA).getPrice());

						existA = "yes";
					}
					counterA++;
				}

				if (existA != "yes") {
					System.out.println("The book is not in the data base.");
				}

			}

		} while (choice != 5);

		System.out.println("\n\nThank you for using this App!");

	}
	
	public static ArrayList<Book> searchBySku(ArrayList<Book> arr, String SKU){
		
		int counterS = 0;
		
		String exist = null; 
		
		while (exist != "yes" && counterS < arr.size()) {

				if (SKU.equalsIgnoreCase(arr.get(counterS).getSku())) {
					System.out.println("SKU: " + arr.get(counterS).getSku() + "    " + "Title: "
							+ arr.get(counterS).getTitle() + "    " + "Author: " + arr.get(counterS).getAuthor()
							+ "    " + "Description" + arr.get(counterS).getDescription() + "    " + "Price: $"
							+ arr.get(counterS).getPrice());
					exist = "yes";

				}
				counterS++;
				}
		
		
		if (exist != "yes") {
			System.out.println("The book with this SKU is not in the database.");
			

		} return new ArrayList<Book>();
	
			
	
	}	
	
}

/**
	// This is a test example: a method for adding existing books into book database
	// This method is used in Main method
       public static ArrayList<Book> initDatabase() {

		ArrayList<Book> arrbook = new ArrayList<Book>();

		Book Book1 = new Book();
		Book1.setSku("Java1001");
		Book1.setTitle("Head First Java");
		Book1.setAuthor("Kathy Sierra and Bert Bates");
		Book1.setDescription("Easy to read Java workbook");
		Book1.setPrice(47.50);

		Book Book2 = new Book();
		Book2.setSku("Java1002");
		Book2.setTitle("Thinking in Java");
		Book2.setAuthor("Bruce Eckel");
		Book2.setDescription("Details about Java under the hood");
		Book2.setPrice(20.00);

		Book Book3 = new Book();
		Book3.setSku("Orcl1003");
		Book3.setTitle("OCP: Oracle Certified Professional Java SE");
		Book3.setAuthor("Jeanne Boyarsky");
		Book3.setDescription("Everything you need to know in one place");
		Book3.setPrice(45.00);

		Book Book4 = new Book();
		Book4.setSku("Python1004");
		Book4.setTitle("Automate the Boring Stuff with Python");
		Book4.setAuthor("Al Sweigart");
		Book4.setDescription("Fun with Python");
		Book4.setPrice(10.50);

		Book Book5 = new Book();
		Book5.setSku("Zombie1005");
		Book5.setTitle("The Maker's Guide to the Zombie Apocalypse");
		Book5.setAuthor("Simon Monk");
		Book5.setDescription("Defend Your Base with Simple Circuits, Arduino, and Raspberry Pi");
		Book5.setPrice(16.50);

		Book Book6 = new Book();
		Book6.setSku("Rasp1006");
		Book6.setTitle("Raspberry Pi Projects for the Evil Genius");
		Book6.setAuthor("Donald Norris");
		Book6.setDescription("A dozen fiendishly fun projects for the Raspberry Pi!");
		Book6.setPrice(14.75);

		arrbook.add(Book1);
		arrbook.add(Book2);
		arrbook.add(Book3);
		arrbook.add(Book4);
		arrbook.add(Book5);
		arrbook.add(Book6);

		return arrbook;

	}

}
*/


/*
 * 
 * Test results:

===Menu===
1.Display the all books in database
2.Add a new entry to the database
3.Search a book by SKU
4.Search a book by Author/co-Author
5.Quit
Please choose from option 1 to 5:
2
Input a SKU of the book:
Py001
Input a Title of the book:
Think Python
Input the author of the book:
Allen Downey
Input the description of the book:
An introduction for design
Input the price of the book:
29.55
Would you like to add another book? y/n
n


===Menu===
1.Display the all books in database
2.Add a new entry to the database
3.Search a book by SKU
4.Search a book by Author/co-Author
5.Quit
Please choose from option 1 to 5:
1

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

   SKU                     Title                                  Author                         Description                                               Price
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Java1001    Head First Java                              Kathy Sierra and Bert Bates   Easy to read Java workbook                                           47.5      
Java1002    Thinking in Java                             Bruce Eckel                   Details about Java under the hood                                    20.0      
Orcl1003    OCP: Oracle Certified Professional Java SE   Jeanne Boyarsky               Everything you need to know in one place                             45.0      
Python1004  Automate the Boring Stuff with Python        Al Sweigart                   Fun with Python                                                      10.5      
Zombie1005  The Maker's Guide to the Zombie Apocalypse   Simon Monk                    Defend Your Base with Simple Circuits, Arduino, and Raspberry Pi     16.5      
Rasp1006    Raspberry Pi Projects for the Evil Genius    Donald Norris                 A dozen fiendishly fun projects for the Raspberry Pi!                14.75     
Py001       Think Python                                 Allen Downey                  An introduction for design                                           29.55     

===Menu===
1.Display the all books in database
2.Add a new entry to the database
3.Search a book by SKU
4.Search a book by Author/co-Author
5.Quit
Please choose from option 1 to 5:
3
Please enter the book SKU for searching.
Java001
The book with this SKU is not in the database.


===Menu===
1.Display the all books in database
2.Add a new entry to the database
3.Search a book by SKU
4.Search a book by Author/co-Author
5.Quit
Please choose from option 1 to 5:
4
Please enter the author for searching.
Downey
SKU: Py001    Title: Think Python    Author: Allen Downey    DescriptionAn introduction for design    Price: $29.55


===Menu===
1.Display the all books in database
2.Add a new entry to the database
3.Search a book by SKU
4.Search a book by Author/co-Author
5.Quit
Please choose from option 1 to 5:
5


Thank you for using this App!
 * 
 * 
 * 
 */
