package hust.soict.ictglobal.aims;

import hust.soict.ictglobal.aims.media.Book;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book = new Book();
		book.setTitle("Hello");
		book.setCategory("Test");
		book.addAuthor("Unknown");
		book.setCost(10.0f);
		String content ="In recent years we have all been exposed to dire media reports concerning the impending demise of global coal and oil reserves, but the depletion of another key non-renewable resource continues without receiving much press at all. Helium – an inert, odourless, monatomic element known to lay people as the substance that makes balloons float and voices squeak when inhaled – could be gone from this planet within a generation. ";

		book.setContent(content);
		System.out.println(book.toString());
	}

}
