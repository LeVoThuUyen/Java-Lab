package hust.soict.ictglobal.aims.media;

public class TestBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book = new Book();
		book.setTitle("Harry Potter");
		book.setCategory("Fiction");
		book.setCost(16.78f);
		System.out.println("add status: " + book.addAuthor("Thu Uyen"));
		System.out.println("add status: " + book.addAuthor("Le Vo"));
		System.out.println("add status: " + book.addAuthor("Thu Uyen\"));\n" +
				"\t\tSystem.out.println(\"add status: \" + book.addAuthor(\"Le Vo Thu Uyen"));
		System.out.println("add status: " + book.addAuthor("Thu Uyen"));
		System.out.println("title: "+ book.getTitle());
		System.out.println("cat: " + book.getCategory());
		System.out.println("cost: " + book.getCost());
		for(int i = 0; i < book.getAuthors().size(); i++) {
			System.out.println("Author " + (i + 1) + " " + book.getAuthors().get(i));
		}
		System.out.println("remove status: " + book.removeAuthor("Thu Uyen"));
		for(int i = 0; i < book.getAuthors().size(); i++) {
			System.out.println("Author " + (i + 1) + " " + book.getAuthors().get(i));
		}
	}

}
