package hust.soict.ictglobal.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	
	private List<String> authors = new ArrayList<String>();
	
	public Book() {
		super();
	}
	
	public List<String> getAuthors() {
		return authors;
	}
	
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public boolean addAuthor(String authorName){
		for(String author : authors) {
			if(author.contentEquals(authorName))
				return false;
		}
		authors.add(authorName);
		return true;
	}
	
	public boolean removeAuthor(String authorName) {
		for(String author : authors) {
			if(author.equals(authorName)) {
				authors.remove(authorName);
				return true;
			}
		}
		return false;
	}
}
