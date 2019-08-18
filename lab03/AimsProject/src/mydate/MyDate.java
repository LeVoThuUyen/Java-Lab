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

	public int getDay() {
		return day;
	}

	public boolean setDay(int day) {
		if(day < 1 || day > 31)
			return false;
		this.day = day;
		return true;
	}

	public int getMonth() {
		return month;
	}

	public boolean setMonth(int month) {
		if(month < 1 || month > 12 )
			return false;
		this.month = month;
		return true;
	}

	public int getYear() {
		return year;
	}

	public boolean setYear(int year) {
		if(year < 0)
			return false;
		this.year = year;
		return true;
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
	
	public void print() {
		System.out.printf("%02d/%02d/%d%n", day, month, year);
	}
}
