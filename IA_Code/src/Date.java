
import java.util.Calendar;
import java.util.Scanner;

public class Date {
	// declaring all required variables
	private int day, month, year;

	public Date() {
		Calendar now = Calendar.getInstance();
		day = now.get(Calendar.DATE);
		month = now.get(Calendar.MONTH) + 1;
		year = now.get(Calendar.YEAR);
	}

	public Date(int d, int m, int y) throws Exception {
		if (!isValidDate(d, m, y)) {
			throw new Exception("Invalid date");
		} else {
			day = d;
			month = m;
			year = y;
		}
	}

	public Date(String dateString) throws Exception {
		int d = 0, m = 0, y = 0;
		dateString = dateString.replace('/', ' ');
		Scanner scanner = new Scanner(dateString);
		try {
			d = scanner.nextInt();
			m = scanner.nextInt();
			y = scanner.nextInt();
			scanner.close();
		} catch (Exception e) {
			throw new Exception("Invalid date format");
		}
		if (isValidDate(d, m, y)) {
			day = d;
			month = m;
			year = y;
		} else {
			throw new Exception("Invalid date");
		}
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public void setDay(int d) {
		int m = this.getMonth(); // to abbreviate the if statements
		int y = this.getYear();
		try {

			if (d < 1 || d > 31) {
				throw new Exception("Invalid day");
			}
			if (m == 4 && d > 30 || m == 6 && d > 30 || m == 9 && d > 30 || m == 11 && d > 30) {
				throw new Exception("Invalid day for month");
			}
			if (!isLeapYear(y) && m == 2 && d > 28) {
				throw new Exception("Not a leap year - February has 28 days");
			}
			if (isLeapYear(y) && m == 2 && d > 29) {
				throw new Exception("Leap year - February has 29 days");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		day = d;
	}

	public void setMonth(int m) {
		try {

			if (!isValidMonth(m)) {
				throw new Exception("Invalid month");
			} else {
				month = m;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void setYear(int y) {
		try {
			if (!isValidYear(y)) {
				throw new Exception("Invalid year");
			} else {
				year = y;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void setDate(int d, int m, int y) throws Exception {
		this.setDay(d);
		this.setMonth(m);
		this.setYear(y);
	}

	public String toString() {
		String output = day + "/" + month + "/" + year;
		return output;
	}

	public static Date stringToDate(String dateString) throws Exception {
		Date date = new Date(dateString);
		return date;
	}

	public static boolean isValidMonth(int month) {
		return (month >= 1 && month <= 12);
	}

	public static boolean isValidYear(int year) {
		return (year >= 1582);
	}

	/*
	 * Every year that is exactly divisible by four is a leap year, except for years
	 * that are exactly divisible by 100, but these centurial years are leap years,
	 * if they are exactly divisible by 400. For example, the years 1700, 1800, and
	 * 1900 were not leap years, but the years 1600 and 2000 were.
	 */
	public static boolean isLeapYear(int year) {
		boolean divisibleBy4 = (year % 4 == 0);
		boolean notDivBy100 = (year % 100 != 0);
		boolean divBy100and400 = (year % 100 == 0 && year % 400 == 0);
		return divisibleBy4 && (notDivBy100 || divBy100and400);
	}

	public static int daysinMonth(int month, int year) {
		if (month == 1) {
			return 31;
		} else if (month == 2 && isLeapYear(year)) {
			return 29;
		} else if (month == 2 && !isLeapYear(year)) {
			return 28;
		} else if (month == 3) {
			return 31;
		} else if (month == 4) {
			return 30;
		} else if (month == 5) {
			return 31;
		} else if (month == 6) {
			return 30;
		} else if (month == 7) {
			return 31;
		} else if (month == 8) {
			return 31;
		} else if (month == 9) {
			return 30;
		} else if (month == 10) {
			return 31;
		} else if (month == 11) {
			return 30;
		} else if (month == 12) {
			return 31;
		} else {
			return -1; // invalid DOTM
		}
	}

	public static Date getCurrentDate() throws Exception {
		Calendar now = Calendar.getInstance();
		int d = now.get(Calendar.DATE);
		int m = now.get(Calendar.MONTH) + 1;
		int y = now.get(Calendar.YEAR);
		Date today = new Date(d, m, y);
		return today;
	}

	public static boolean isValidDay(int day, int month, int year) {
		return (day >= 1 && day <= daysinMonth(month, year));
	}

	public static boolean isValidDate(int day, int month, int year) {
		return (isValidYear(year) && isValidMonth(month) && isValidDay(day, month, year));
	}

	// overloading
	public static boolean isValidDate(String dateString) throws Exception {
		int d = 0, m = 0, y = 0;
		dateString = dateString.replace('/', ' ');
		Scanner scanner = new Scanner(dateString);
		try {
			d = scanner.nextInt();
			m = scanner.nextInt();
			y = scanner.nextInt();
			scanner.close();
		} catch (Exception e) {
			throw new Exception("Invalid date format");
		}
		return (isValidYear(y) && isValidMonth(m) && isValidDay(d, m, y));
	}

	public boolean equals(Date date2) {
		boolean equal = false;
		if (this.getDay() == date2.getDay() && this.getMonth() == date2.getMonth()
				&& this.getYear() == date2.getYear()) {
			equal = true;
		}
		return equal;
	}

	public int getAge(Date date2) { // gets age of beneficiary by comparing current date with dob
		if (this.getYear() != date2.getYear()) {
			return this.getYear() - date2.getYear();
		} else if (this.getMonth() != date2.getMonth()) {
			return this.getMonth() - date2.getMonth();
		} else {
			return this.getDay() - date2.getDay();
		}
	}

}
