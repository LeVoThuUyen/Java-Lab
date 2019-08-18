package hust.soict.ictglobal.aims.order;
import java.util.ArrayList;
import java.util.List;

import hust.soict.ictglobal.aims.media.Book;
import hust.soict.ictglobal.aims.media.CompactDisc;
import hust.soict.ictglobal.aims.media.DigitalVideoDisc;
import hust.soict.ictglobal.aims.media.Media;
import hust.soict.ictglobal.date.MyDate;
import java.util.Random;

public class Order {
	public static final int MAX_LIMITED_ORDERS = 5;
	private static int nbOrders = 0;

	private MyDate dateOrdered;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	//constructor
	public Order() {
		dateOrdered = new MyDate();
		nbOrders++;
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
	
	public boolean addMedia(Media item) {
		int qtyOrdered = itemsOrdered.size();
		if(qtyOrdered < 10) {
			itemsOrdered.add(item);
			return true;
		}
		return false;
	}
	
	public boolean removeMedia(Media item) {
		return itemsOrdered.remove(item);
	}
	
	public boolean removeMedia(int id) {
		if(id < 0 || id >= itemsOrdered.size())
			return false;
		itemsOrdered.remove(id);
		return true;
	}
	
	public void print() {
		System.out.println("*********************Order************************");
		System.out.print("Date: ");
		dateOrdered.print();
		System.out.println();
		System.out.println("Ordered items:");
		for(int i = 0; i < itemsOrdered.size(); i++) {
			Media currentMedia = itemsOrdered.get(i);
			String type = currentMedia.getClass().toString();
			System.out.printf("%d. ", i);
			if(type.equals("class hust.soict.ictglobal.aims.media.DigitalVideoDisc")) {
				DigitalVideoDisc currentDVD = (DigitalVideoDisc) currentMedia;
				System.out.printf("DVD - %s - %s - %s - %d: $%.2f%n",
					currentDVD.getTitle(),
					currentDVD.getCategory(),
					currentDVD.getDirector(),
					currentDVD.getLength(),
					currentDVD.getCost());
			}
			else if(type.equals("class hust.soict.ictglobal.aims.media.Book")){
				Book currentBook = (Book) currentMedia;
				List<String> authorList = currentBook.getAuthors();
				StringBuffer authors = new StringBuffer();
				for(int j = 0; j < authorList.size(); j++) {
					authors.append(authorList.get(j) + ", ");
				}
				System.out.printf("Book - %s - %s - %s$%.2f%n",
						currentBook.getTitle(),
						currentBook.getCategory(),
						authors,
						currentBook.getCost());
			}
			else if(type.equals("class hust.soict.ictglobal.aims.media.CompactDisc")){
				CompactDisc currentCd = (CompactDisc) currentMedia;
				System.out.printf("DVD - %s - %s - %d: $%.2f%n",
					currentCd.getTitle(),
					currentCd.getCategory(),
					currentCd.getLength(),
					currentCd.getCost());
			}
			else {
				continue;
			}
		}
		System.out.printf("Total cost: $%.2f%n", totalCost());
		System.out.println("**************************************************");
	}
	
	public Media getALuckyItem() {
		Random r = new Random();
		int luckyIndex = r.nextInt(itemsOrdered.size());
		return itemsOrdered.get(luckyIndex);
	}
}