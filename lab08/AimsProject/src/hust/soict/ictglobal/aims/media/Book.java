package hust.soict.ictglobal.aims.media;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Book extends Media{
	
	private List<String> authors = new ArrayList<String>();
	private String content;
	private List<String> contentTokens = new ArrayList<String>();
	private Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();
	
	public Book() {
		super();
	}
	
	public List<String> getAuthors() {
		return authors;
	}
	
	public String getContent() {
		return content;
	}
	
	public void processContent() {
		//split content to tokens -> save to contentTokens
		String[] tokens = content.split("\\)*\"*\\s*;*:*\\.*\\?*,*!*\\s+\\(*\"*");
		for(String token : tokens) {
			if(!token.equals("-"))
				contentTokens.add(token.toLowerCase());
		}
		java.util.Collections.sort(contentTokens);
		
		//count the frequency of each token -> set to wordFrequency
		int counter = 1;
		String previous = null;
		for(String s : contentTokens) {
			if(s.equals(previous)) {
				counter++;
			}
			else {
				//save previous
				if(previous != null) {
					wordFrequency.put(previous, counter);
				}
				counter = 1;
				previous = s;
			}
		}
		
		//print
		
	}

	public void setContent(String content) {
		this.content = content;
		processContent();
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
	
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		//title
		output.append("\n*Title: " + getTitle() + "\n");
		//category
		output.append("\n*Category: " + getCategory() + "\n");
		//cost
		output.append("\n*Cost: " + getCost() + "\n");
		//authors
		output.append("\n*Authors:\n");
		for(String author : authors) {
			output.append(author + "\n");
		}
		
		//content length
		output.append("\n*Content length: " + contentTokens.size() + "\n");
		//token list
		output.append("\n*Token list:\n");
		Iterator<Entry<String, Integer>> iterator = wordFrequency.entrySet().iterator();
		while (iterator.hasNext()) {
	        Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>) iterator.next();
	        output.append(pair.getKey() + " : " + pair.getValue() + "\n");
	        iterator.remove();
	    }
		
		return output.toString();
	}
}
