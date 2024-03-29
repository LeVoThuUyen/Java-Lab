package hust.soict.ictglobal.aims.disc;

import hust.soict.ictglobal.aims.order.Order;

public class DiskTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Order order = new Order();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategory("Animation");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
		dvd2.setCategory("Science Fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("George Lucas");
		dvd2.setLength(124);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
		dvd3.setCategory("Animation");
		dvd3.setCost(18.99f);
		dvd3.setDirector("John Musker");
		dvd3.setLength(90);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Cars");
		dvd4.setCategory("Animation");
		dvd4.setCost(12.69f);
		dvd4.setDirector("Unknown");
		dvd4.setLength(120);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Planet Earth");
		dvd5.setCategory("Documentary");
		dvd5.setCost(6.99f);
		dvd5.setDirector("NGC");
		dvd5.setLength(150);
		
		DigitalVideoDisc[] dvdList = {dvd1, dvd2, dvd3, dvd4, dvd5};
		
		order.addDigitalVideoDisc(dvdList);
		
		//test search
		System.out.println("*Search");
		System.out.print("Is there \"lion\" in dvd1? ");
		System.out.println(dvd1.search("lion"));
		System.out.println();
		
		//test get ALuckyItem
		System.out.println("*Lucky Item");
		DigitalVideoDisc luckyItem = order.getALuckyItem();
		System.out.println("Your lucky item is " + luckyItem.getTitle());
		System.out.println("You will get discount $" + luckyItem.getCost());
		luckyItem.setCost(0.0f);
		order.print();
	}

}
