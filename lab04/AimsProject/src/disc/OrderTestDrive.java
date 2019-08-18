package disc;

public class OrderTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Order order = new Order();
		
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
		
		DigitalVideoDisc[] dvdList = {dvd1, dvd2, dvd3};
		
		//array parameters
		order.addDigitalVideoDisc(dvdList);
		
		//variable parameters
		order.addDigitalVideoDiscVar(dvd1, dvd2, dvd3);
		
		System.out.print("Total Cost is: ");
		System.out.println(order.totalCost());
		
		//test order limit
		for(int i = 1; i <= 6; i++) {
			if(Order.getNbOrders() >= Order.MAX_LIMITED_ORDERS) {
				System.out.println("User has reached maximum number of orders!");
				break;
			}
			Order newOrder = new Order();
			System.out.println("Current number of orders: " + Order.getNbOrders());
		}
		
		//test order printing
		order.print();
	}

}
