package hust.soict.ictglobal.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc{
	private String artist;
	private int length = 0;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public boolean addTrack(Track track) {
		for(Track currentTrack : tracks) {
			if(currentTrack.equals(track))
				return false;
		}
		tracks.add(track);
		length += track.getLength();
		return true;
	}
	
	public boolean removeTrack(Track track) {
		for(Track currentTrack : tracks) {
			if(currentTrack.equals(track)) {
				length -= currentTrack.getLength();
				tracks.remove(currentTrack);				
				return true;
			}
		}
		return false;
	}
	
	public int getNumberOfTracks() {
		return tracks.size();
	}
	
	@Override
	public int getLength() {
		return this.length;
	}
	
	public void play() {
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("CD length: " + this.getLength());
		for(Track track : tracks) {
			track.play();
		}
	}
	
//	@Override
//	public int compareTo(Object obj) {
//		CompactDisc cd = (CompactDisc) obj;
//		//compare by number of tracks, then length
//		if(tracks.size() < cd.getNumberOfTracks())
//			return -1;
//		else if(tracks.size() > cd.getNumberOfTracks()) {
//			return 1;
//		}
//		else {
//			return this.getLength() - cd.getLength();
//		}
//	}
}
