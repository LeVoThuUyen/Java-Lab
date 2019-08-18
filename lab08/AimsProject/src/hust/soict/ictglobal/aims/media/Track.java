package hust.soict.ictglobal.aims.media;

public class Track implements Playable{
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	public boolean equals(Track track) {
		return title.equals(track.title);
	}
	
	public void play() {
		System.out.println("Playing Track: " + getTitle());
	}
	
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
}
