package hust.soict.ictglobal.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
	public boolean search(String title) {
		String tokens[] = title.split(" +");
		for(String token : tokens) {
			if(this.title.toUpperCase().contains(token.toUpperCase()))
				return true;
		}
		return false;
	}
	
	//constructor
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	public DigitalVideoDisc(String title, String category) {
		this(title);
		this.category = category;
	}
	public DigitalVideoDisc(String title, String category, String director) {
		this(title, category);
		this.director = director;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		this(title, category, director);
		this.length = length;
		this.cost = cost;
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}
