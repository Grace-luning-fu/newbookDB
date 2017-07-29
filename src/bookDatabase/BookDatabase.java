package bookDatabase;

import java.util.ArrayList;

public class BookDatabase {
	// adding all books to the database

	public ArrayList<Book> initDatabase() {

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
