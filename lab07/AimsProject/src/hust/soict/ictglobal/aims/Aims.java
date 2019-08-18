package hust.soict.ictglobal.aims;
import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.ictglobal.aims.media.Book;
import hust.soict.ictglobal.aims.media.CompactDisc;
import hust.soict.ictglobal.aims.media.DigitalVideoDisc;
import hust.soict.ictglobal.aims.media.Track;
import hust.soict.ictglobal.aims.order.Order;

public class Aims {

	public static void main(String[] args) {
		//Memory Daemon
		MemoryDaemon md = new MemoryDaemon();
		Thread thread = new Thread(md);
		thread.setDaemon(true);
		thread.start();
		
		Order order = null;
		
		Scanner input = new Scanner(System.in);
		int choice;
		String temp;
		
		showMenu();
		temp = input.nextLine();
		choice = Integer.parseInt(temp);
		
		while(choice != 0) {
			switch(choice) {
			case 1: 
				System.out.println("1. Create new order");
				order = new Order();
				break;
				
			case 2:
				System.out.println("2. Add item to the order");
				if(order != null) {
					//ADD
					System.out.println("Enter media choice: 0 - dvd, 1 - cd, 2 - book");
					temp = input.nextLine();
					int mediaChoice = Integer.parseInt(temp);
					
					switch(mediaChoice) {
					case 0:
						String title;
						String category;
						String director;
						int length;
						float cost;
						
						System.out.println("Enter title:");
						title = input.nextLine();
						System.out.println("Enter category:");
						category = input.nextLine();
						System.out.println("Enter cost:");
//						cost = input.nextFloat();
						temp = input.nextLine();
						cost = Float.parseFloat(temp);
						System.out.println("Enter director:");
						director = input.nextLine();
						System.out.println("Enter length:");
//						length = input.nextInt();
						temp = input.nextLine();
						length = Integer.parseInt(temp);
						
						DigitalVideoDisc newDVD = new DigitalVideoDisc(title, category, director, length, cost);
						order.addMedia(newDVD);
						
						break;
						
					case 1:
						System.out.println("Enter title:");
						title = input.nextLine();
						System.out.println("Enter category:");
						category = input.nextLine();
						System.out.println("Enter cost:");
						temp = input.nextLine();
						cost = Float.parseFloat(temp);
						CompactDisc cd = new CompactDisc();
						cd.setTitle(title);
						cd.setCategory(category);
						cd.setCost(cost);
						
						int cont;
						System.out.println("Add tracks:");
						do {
							System.out.println("Enter track title:");
							String trackTitle = input.nextLine();
							System.out.println("Enter track length:");
							temp = input.nextLine();
							int trackLength = Integer.parseInt(temp);
							Track newTrack = new Track(trackTitle, trackLength);
							boolean addOk = cd.addTrack(newTrack);
							if(!addOk) {
								System.out.println("Track has already been added!");
							}
							else {
								newTrack.play();
							}
							
							System.out.println("Choose 1 to continue to add track, 0 to quit...");
							temp = input.nextLine();
							cont = Integer.parseInt(temp);
						}while(cont != 0);
						order.addMedia(cd);
						
						break;
						
						
					case 2:
						ArrayList<String> authors = new ArrayList<String>();
						String authorString;
						
						System.out.println("Enter title:");
						title = input.nextLine();
						
						System.out.println("Enter category:");
						category = input.nextLine();
						
						System.out.println("Enter cost:");
						temp = input.nextLine();
						cost = Float.parseFloat(temp);
						
						System.out.println("Enter author names, separate by colons:");
						authorString = input.nextLine();
						
						String[] authorArray = authorString.split(",");
						for(String author : authorArray) {
							authors.add(author);
						}
						
						Book newBook = new Book();
						newBook.setTitle(title);
						newBook.setCategory(category);
						newBook.setCost(cost);
						newBook.setAuthors(authors);
						order.addMedia(newBook);
						
						break;
						
					
					default:
						System.out.println("Invalid choice!");
						break;
					}
				}
				else {
					System.out.println("You haven't create any order! Please create a new one!");
				}
				
				break;
				
			case 3:
				System.out.println("3. Delete item by id");
				
				System.out.println("Enter id of item to be removed:");
				temp = input.nextLine();
				int id = Integer.parseInt(temp);
				
				boolean removeStatus = order.removeMedia(id);
				if(removeStatus)
					System.out.println("Successfully removed!");
				else
					System.out.println("Item can't be removed!");
				
				break;
				
			case 4:
				System.out.println("4. Display the items list of order");
				order.print();
				break;
				
			default:
			}
			
			showMenu();
			temp = input.nextLine();
			choice = Integer.parseInt(temp);
		}
	}
	
	public static void showMenu() {
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

}
