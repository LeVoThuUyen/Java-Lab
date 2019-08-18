package hust.soict.ictglobal.aims;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hust.soict.ictglobal.aims.media.Book;
import hust.soict.ictglobal.aims.media.CompactDisc;
import hust.soict.ictglobal.aims.media.DigitalVideoDisc;
import hust.soict.ictglobal.aims.media.Media;
import hust.soict.ictglobal.aims.media.Track;
import hust.soict.ictglobal.aims.order.Order;

public class Aims {

	public static void main(String[] args) {
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
		
		List<Media> collection = new ArrayList<Media>();
		collection.add(dvd1);
		collection.add(dvd2);
		collection.add(dvd3);
		
		//add track
		Track track1 = new Track("First", 1);
		Track track2 = new Track("Second", 11);
		Track track3 = new Track("Third", 15);
		
		
		//add cd
		CompactDisc cd1 = new CompactDisc();
		cd1.setTitle("CD1");
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		cd1.setCost(5.0f);
		
		CompactDisc cd2 = new CompactDisc();
		cd2.setTitle("CD2");
		cd1.addTrack(track1);
		cd1.addTrack(track3);
		cd2.setCost(2.0f);
		
		collection.add(cd1);
		collection.add(cd2);
		
		
		
		// unsorted
		System.out.println("*Unsorted list:");
		Iterator<Media> iterator = collection.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(((Media) iterator.next()).getTitle());
		}
		
		// sorted
		System.out.println("*List sorted by price:");
		java.util.Collections.sort((ArrayList<Media>)collection);
		
		iterator = collection.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(((Media) iterator.next()).getTitle());
		}
		
	}
	
}
