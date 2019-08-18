package mydate;

public class DateUtils {
	public static int compare(MyDate date1, MyDate date2) {
		int day1 = date1.getDay();
		int month1 = date1.getMonth();
		int year1 = date1.getYear();
		
		int day2 = date2.getDay();
		int month2 = date2.getMonth();
		int year2 = date2.getYear();
		
		if(year1 < year2) {
			return -1;
		}
		else if(year1 > year2) {
			return 1;
		}
		else {
			if(month1 < month2) {
				return -1;
			}
			else if(month1 > month2) {
				return 1;
			}
			else {
				if(day1 < day2) {
					return -1;
				}
				else if(day1 > day2) {
					return 1;
				}
				else {
					return 0;
				}
			}
		}
	}
	
	private static void swap(MyDate date1, MyDate date2) {
		int day1 = date1.getDay();
		int month1 = date1.getMonth();
		int year1 = date1.getYear();
		
		int day2 = date2.getDay();
		int month2 = date2.getMonth();
		int year2 = date2.getYear();
		
		date1.setDay(day2);
		date1.setMonth(month2);
		date1.setYear(year2);
		
		date2.setDay(day1);
		date2.setMonth(month1);
		date2.setYear(year1);
	}
	
	public static void sort(MyDate[] dateArray) {
		int size = dateArray.length;
		for(int i = 0; i < size - 1; i++) {
			for(int j = 0; j < size - 1; j++) {
				int status = compare(dateArray[j], dateArray[j + 1]);
				if(status > 0)
					swap(dateArray[j], dateArray[j + 1]);
			}
		}
	}
}
