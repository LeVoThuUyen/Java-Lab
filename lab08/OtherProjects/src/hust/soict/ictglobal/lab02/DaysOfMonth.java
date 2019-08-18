package hust.soict.ictglobal.lab02;
import java.util.Scanner;

public class DaysOfMonth {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int inputMonth;
		int inputYear;
		int daysOfMonth = 0;
		boolean isLeapYear;
		
		// Enter year
		do {
			System.out.println("Enter year: ");
			inputYear = input.nextInt();
		}while(inputYear < 0);
		
		if(inputYear % 4 == 0)
			isLeapYear = true;
		else
			isLeapYear = false;
		
		
		// Enter month
		do {
			System.out.println("Enter month: ");
			inputMonth = input.nextInt();
		}while(inputMonth < 1 || inputMonth > 12);
		
		
		// Output days of month
		switch(inputMonth) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			daysOfMonth = 31;
			break;
			
		case 4: case 6: case 9: case 11:
			daysOfMonth = 30;
			break;
		case 2:
			if(isLeapYear)
				daysOfMonth = 29;
			else
				daysOfMonth = 28;
			break;
		}
			
		System.out.println("Number of days: " + daysOfMonth);
		input.close();
	}

}
