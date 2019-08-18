package mydate;

public class DateTest {

	public static void main(String[] args) {
		
		//SETTER WITH STRING
		MyDate date1 = new MyDate();
		date1.setDay("Twentyfirst");
		date1.setMonth("November");
		date1.setYear("Two thousand and seven");
		System.out.println("*Date 1:");
		date1.print();
		System.out.println();
		System.out.println();
		
		MyDate date2 = new MyDate();
		date2.setDay("Second");
		date2.setMonth("September");
		date2.setYear("Twenty nineteen");
		System.out.println("*Date 2:");
		date2.print();
		System.out.println();
		System.out.println();
		
		//PRINT WITH FORMAT
		MyDate date3 = new MyDate();
		System.out.println("*Date 3:");
		System.out.print("String: ");
		date3.printString();
		System.out.print("Format dd-mm-yyyy: ");
		date3.printFormat("dd-mm-yyyy");
		System.out.print("Format yy/mm/dd: ");
		date3.printFormat("yy/mm/dd");
		System.out.println();
		
		MyDate date4 = new MyDate(1, 1, 1980);
		MyDate date5 = new MyDate(2, 1, 1980);
		
		MyDate[] dateArray = new MyDate[5];
		dateArray[0] = date1;
		dateArray[1] = date2;
		dateArray[2] = date3;
		dateArray[3] = date4;
		dateArray[4] = date5;
		
		//DATE COMPARE
		int dateCompare = DateUtils.compare(date4, date5);
		String compareText;
		if(dateCompare < 0) {
			compareText = "before";
		}
		else if(dateCompare > 0) {
			compareText = "after";
		}
		else {
			compareText = "equal to";
		}
		System.out.println("*Compare dates:");
		date4.print();
		System.out.printf(" is %s ", compareText);
		date5.print();
		System.out.println();
		System.out.println();

		//SORT DATE ARRAY
		DateUtils.sort(dateArray);
		System.out.println("*Sorted dates: ");
		for(MyDate date : dateArray) {
			date.print();
			System.out.println();
		}
	}
}
