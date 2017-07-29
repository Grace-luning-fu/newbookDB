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
		String exist = null;
		String existA = null;
		int choice = 0;

		// Initialize the book database by adding the 6 books into the book ArrayList
		arr = initDatabase();

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
			Scanner scop = new Scanner(System.in);
			choice = scop.nextInt();

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
					Scanner scSKU = new Scanner(System.in);

					String SKU = scSKU.nextLine();
					onebook.setSku(SKU);

					// Prompt user input for title
					System.out.println("Input a Title of the book:");
					Scanner sctitle = new Scanner(System.in);

					String title = sctitle.nextLine();
					onebook.setTitle(title);

					// Prompt user input for an author
					System.out.println("Input the author of the book:");
					Scanner scauthor = new Scanner(System.in);

					String author = scauthor.nextLine();
					onebook.setSku(author);

					// Prompt user input for description
					System.out.println("Input the description of the book:");
					Scanner scde = new Scanner(System.in);

					String des = scde.nextLine();
					onebook.setDescription(des);

					// Prompt user input for price
					System.out.println("Input the price of the book:");
					Scanner scpri = new Scanner(System.in);

					Double price = scpri.nextDouble();
					onebook.setPrice(price);

					// prompt for choice of continue or not
					System.out.println("Would you like to add another book? y/n");
					Scanner scan00 = new Scanner(System.in);
					contin = scan00.nextLine();

					// add this item in to the ArrayList
					arr.add(onebook);

				} while (contin.equalsIgnoreCase("y"));

			}

			// look up a book by SKU, loop through the ArrayList, if no match, print the
			// book is not in the database
			if (choice == 3) {
				System.out.println("Please enter the book SKU for searching.");
				Scanner scan01 = new Scanner(System.in);
				String searchSKU = scan01.nextLine();

				int counterS = 0;

				while (exist != "yes" && counterS < arr.size()) {

					exist = null;

					if (searchSKU.equalsIgnoreCase(arr.get(counterS).getSku())) {
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
				}

			}

			// look up a book by SKU, loop through the Author, if no match, print the book
			// is not in the database
			if (choice == 4) {

				System.out.println("Please enter the author for searching.");
				Scanner scan02 = new Scanner(System.in);
				String searchAuthor = scan02.nextLine();

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

		System.out.println("Thank you for using this App");

	}

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
