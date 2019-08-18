package hust.soict.ictglobal.aims.media;

public class TestDVD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Helle hallu", "World", "I am", 10, 10.4f);
		System.out.println("title: "+ dvd1.getTitle());
		System.out.println("cat: " + dvd1.getCategory());
		System.out.println("director: " + dvd1.getDirector());
		System.out.println("length: " + dvd1.getLength());
		System.out.println("cost: " + dvd1.getCost());
		System.out.println(dvd1.search("hallu helle"));
	}

}
