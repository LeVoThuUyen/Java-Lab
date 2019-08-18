package hust.soict.ictglobal.aims.media;

public class DigitalVideoDisc extends Media{
	private String director;
	private int length;
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
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
	
}
