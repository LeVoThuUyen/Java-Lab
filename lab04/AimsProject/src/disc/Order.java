package disc;
import java.util.ArrayList;
import mydate.MyDate;

public class Order {
	public static final int MAX_LIMITED_ORDERS = 5;
	private static int nbOrders = 0;

	private MyDate dateOrdered;
	private int qtyOrdered = 0;
	private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<DigitalVideoDisc>();
	
	//constructor
	public Order() {
		dateOrdered = new MyDate();
		nbOrders++;
	}
	
	//add single dvd
	public boolean addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered >= 10) {
			return false;
		}
		itemsOrdered.add(disc);
		qtyOrdered++;
		return true;
	}
	
	//add two dvds at once
	public boolean addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if(qtyOrdered >= 10) {
			System.out.printf("Order is full! Disc %s, %s can't be added!%n", dvd1.getTitle(), dvd2.getTitle());
			return false;
		}
		itemsOrdered.add(dvd1);
		qtyOrdered++;
		
		if(qtyOrdered >= 10) {
			System.out.printf("Order is full! Disc %s can't be added!%n", dvd2.getTitle());
			return false;
		}
		itemsOrdered.add(dvd2);
		qtyOrdered++;
		
		return true;
	}
	
	//add array of dvd
	public boolean addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		int size = dvdList.length;
		if(size + qtyOrdered > 10 ) {
			System.out.println("This order excesses the maximum number allowed!");
			return false;
		}
		
		for(DigitalVideoDisc dvd : dvdList) {
			itemsOrdered.add(dvd);
		}
		qtyOrdered += size;
		return true;
	}

	//add with variable arguments
	public boolean addDigitalVideoDiscVar(DigitalVideoDisc...dvdList) {
		int size = dvdList.length;
		if(size + qtyOrdered > 10 ) {
			System.out.println("This order excesses the maximum number allowed!");
			return false;
		}
		
		for(DigitalVideoDisc dvd : dvdList) {
			itemsOrdered.add(dvd);
		}
		qtyOrdered += size;
		return true;
	}
	
	public boolean removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for(int i = 0; i <= qtyOrdered; i++) {
			if(disc.equals(itemsOrdered.get(i))) {
				itemsOrdered.remove(i);
				qtyOrdered--;
				return true;
			}
		}
		return false;
	}
	
	public static int getNbOrders() {
		return nbOrders;
	}

	public float totalCost() {
		float sum = 0;
		for(int i = 0; i < itemsOrdered.size(); i++) {
			sum = sum + itemsOrdered.get(i).getCost();
		}
		return sum;
	}
	
	public MyDate getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(MyDate dateOrdered) {
		this.dateOrdered = dateOrdered;
	}
	
	public void print() {
		System.out.println("*********************Order************************");
		System.out.print("Date: ");
		dateOrdered.print();
		System.out.println("Ordered items:");
		for(int i = 0; i < qtyOrdered; i++) {
			DigitalVideoDisc currentDVD = itemsOrdered.get(i);
			System.out.printf("%d. DVD - %s - %s - %s - %d: $%.2f%n", 
					i + 1,
					currentDVD.getTitle(),
					currentDVD.getCategory(),
					currentDVD.getDirector(),
					currentDVD.getLength(),
					currentDVD.getCost());
		}
		System.out.printf("Total cost: $%.2f%n", totalCost());
		System.out.println("**************************************************");
	}
}
