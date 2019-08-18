package mydate;

import java.util.Scanner;

public class MyDate {
	private int day;
	private int month;
	private int year;
	
	public MyDate(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public MyDate() {//set current date
		String now = java.time.LocalDate.now().toString();
		this.day = Integer.parseInt(now.substring(8, 10));
		this.month = Integer.parseInt(now.substring(5, 7));
		this.year = Integer.parseInt(now.substring(0, 4));
	}
	
	public MyDate(String date) {
		setDate(date);
	}

	// DAY
	public int getDay() {
		return day;
	}

	public boolean setDay(int day) {
		if(day < 1 || day > 31)
			return false;
		this.day = day;
		return true;
	}
	
	public void setDay(String dayText) {
		DayList dayList = DayList.valueOf(dayText.toUpperCase());
		int day = dayList.day();
		this.day = day;
	}
	
	// MONTH
	public int getMonth() {
		return month;
	}

	public boolean setMonth(int month) {
		if(month < 1 || month > 12 )
			return false;
		this.month = month;
		return true;
	}
	
	public void setMonth(String monthText) {
		MonthList monthList = MonthList.valueOf(monthText.toUpperCase());
		int month = monthList.month();
		this.month = month;
	}

	
	//YEAR
	public int getYear() {
		return year;
	}

	public boolean setYear(int year) {
		if(year < 0)
			return false;
		this.year = year;
		return true;
	}
	
	public void setYear(String yearText) {
		int year = 0;
		
		String parts[] = yearText.split(" ");
		boolean type1 = false;
		for(String part : parts) {
			if(part.toUpperCase().equals("THOUSAND")) {
				type1 = true;
				break;
			}
		}
		// 2 last digits <= 10
		if(type1) {
			String firstPart = parts[0];
			String lastPart = parts[parts.length - 1];
			
			//get first digit
			OneDigit oneDigit = OneDigit.valueOf(firstPart.toUpperCase());
			int part1 = oneDigit.number();
			
			//get last digit
			int part2;			
			if(lastPart.toUpperCase().equals("THOUSAND")) {
				part2 = 0;
			}
			else {
				oneDigit = OneDigit.valueOf(lastPart.toUpperCase());
				part2 = oneDigit.number();
			}
						
			year = part1 * 1000 + part2;
		}
		// 2 last digits > 10
		else {
			TwoDigit twoDigit = TwoDigit.valueOf(parts[0].toUpperCase());
			int firstTwoDigits = twoDigit.number();
			
			twoDigit = TwoDigit.valueOf(parts[1].toUpperCase());
			int lastTwoDigits = twoDigit.number();
			
			year = firstTwoDigits * 100 + lastTwoDigits;
		}
		
		this.year = year;
	}
	
	private boolean setDate(String date) {
		//split
		String[] dateString = date.split(" ");//month day year
		
		String monthString = dateString[0];
		String dayString = dateString[1];
		String yearString = dateString[2];
		
		//set month
		int monthValue = getMonthNumerically(monthString);
		if(!setMonth(monthValue))
			throw new IllegalArgumentException("Invalid month");
		
		//set day
		int dayValue = getDayNumerically(dayString);
		if(!setDay(dayValue))
			throw new IllegalArgumentException("Day must be between 1 and 31");
		
		//set year
		int yearValue = getYearNumerically(yearString);
		if(!setYear(yearValue))
			throw new IllegalArgumentException("Year must be > 0");
		
		return true;
	}
	
	private int getMonthNumerically(String monthString) {
		String monthUpper = monthString.toUpperCase();
		MonthList monthList = MonthList.valueOf(monthUpper);
		return monthList.month();
	}
	
	private int getDayNumerically(String dayString) {
		String dayNumber = dayString.substring(0, dayString.length() - 2);
		int dayValue = Integer.parseInt(dayNumber);
		return dayValue;
	}
	
	private int getYearNumerically(String yearString) {
		return Integer.parseInt(yearString);
	}
	
	public boolean accept() { //enter from keyboard
		Scanner input = new Scanner(System.in);
		System.out.println("Enter date:");
		String dateString = input.nextLine();
		input.close();
		return setDate(dateString);
	}
	
	//PRINT
	public void print() {
		System.out.printf("%02d/%02d/%d", day, month, year);
	}
	
	public void printString() {
		String dayText = DayList.values()[day - 1].toString();
		String monthText = MonthList.values()[month - 1].toString();
		String yearText = "";
		
		if(year % 100 <= 10) {
			int firstDigit = year / 1000;
			String firstDigitText = OneDigit.values()[firstDigit - 1].toString();
			int lastDigit = year % 10;
			String lastDigitText = OneDigit.values()[lastDigit - 1].toString();
			yearText = String.format("%s thousand and %s", firstDigitText, lastDigitText);
		}
		else {
			int firstTwoDigit = year / 100;
			String firstTwoDigitText = TwoDigit.values()[firstTwoDigit - 11].toString();
			int lastTwoDigit = year % 100;
			String lastTwoDigitText = TwoDigit.values()[lastTwoDigit - 11].toString();
			yearText = firstTwoDigitText + " " + lastTwoDigitText;
		}
		
		System.out.printf("%s THE %s, %s%n", monthText, dayText, yearText );
	}
	
	public void printFormat(String format) {
		if(format.equals("dd/mm/yyyy")) {
			System.out.printf("%02d/%02d/%04d%n", day, month, year);
		}
		else if(format.equals("dd/mm/yy")) {
			System.out.printf("%02d/%02d/%02d%n", day, month, year % 100);
		}
		else if(format.equals("yy/mm/dd")) {
			System.out.printf("%02d/%02d/%02d%n", year % 100, month, day);
		}
		else if(format.equals("yyyy/mm/dd")) {
			System.out.printf("%04d/%02d/%02d%n", year, month, day);
		}
		else if(format.equals("dd-mm-yyyy")) {
			System.out.printf("%02d-%02d-%04d%n", day, month, year);
		}
		else if(format.equals("dd-mm-yy")) {
			System.out.printf("%02d-%02d-%02d%n", day, month, year % 100);
		}
		else if(format.equals("yy-mm-dd")) {
			System.out.printf("%02d-%02d-%02d%n", year % 100, month, day);
		}
		else if(format.equals("yyyy-mm-dd")) {
			System.out.printf("%04d-%02d-%02d%n", year, month, day);
		}
		else {
			this.printString();
		}
	}
}
