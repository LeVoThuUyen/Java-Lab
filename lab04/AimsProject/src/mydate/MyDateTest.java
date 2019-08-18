package mydate;

public class MyDateTest {

	public static void main(String[] args) {
		MyDate currentDate = new MyDate();
		
		MyDate dateInt = new MyDate(2, 3, 1998);
		
		MyDate dateString = new MyDate("April 31th 1975");
		
		currentDate.print();
		dateInt.print();
		dateString.print();
		
		MyDate dateInput = new MyDate(1, 1, 1);
		dateInput.accept();
		dateInput.print();
	}

}
