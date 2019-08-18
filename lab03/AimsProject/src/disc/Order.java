package disc;
import java.util.ArrayList;

public class Order {
	public static final int MAX_NUMBERS_ORDERED = 10;
	
//	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<DigitalVideoDisc>();
	
	private int qtyOrdered = 0;
	
	public boolean addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered >= 10) {
			return false;
		}
		itemsOrdered.add(disc);
		qtyOrdered++;
		return true;
	}
	
	public boolean removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for(int i = 0; i <= qtyOrdered; i++) {
			if(disc.equals(itemsOrdered.get(i))) {
				itemsOrdered.remove(i);
				qtyOrdered--;
				return true;
			}
		}
		return false;
	}
	
	public float totalCost() {
		float sum = 0;
		for(int i = 0; i < itemsOrdered.size(); i++) {
			sum = sum + itemsOrdered.get(i).getCost();
		}
		return sum;
	}
}
