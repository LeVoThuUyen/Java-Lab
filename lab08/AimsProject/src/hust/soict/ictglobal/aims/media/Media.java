package hust.soict.ictglobal.aims.media;

public abstract class Media implements Comparable<Media>{
//	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public int compareTo(Media media) {
		float cost = media.getCost();
		float result = this.cost - cost;
		if(result == 0)
			return 0;
		else
			return (int) result;
	}

	public Media() {
		// TODO Auto-generated constructor stub
	}

}
