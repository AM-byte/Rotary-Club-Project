
import java.io.*;
import java.util.*;
import java.math.*;

public class Home_Menu {

	static ArrayList<Beneficiary_Data> benList = new ArrayList<Beneficiary_Data>();
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		homeMenu();

	}

	public static void homeMenu() {

		int option;

//		option = in.nextInt();

		do {
			System.out.println("Following are the options:"); // asking the use to choose their option
			System.out.println("1. Beneficiary Data");
			System.out.println("2. Display Trend Lines");
			System.out.println("3. Exit Application");

			System.out.println("Please enter number"); // asking the use to choose their option
			option = in.nextInt();
			switch (option) { // switch case to complement the user's selection

			case 1:
				// selected beneficiary data
				System.out.println("Beneficiary Data");
				benData();
				break;

			case 2:
				// selected trend lines
				System.out.println("Trend Lines");
				break;

			case 3:
				// quit
				System.exit(0);
				break;

			default:
				// display error message and accept new value
				System.out.println("You have entered an invalid value. Accepted values are 1, 2 or 3");

			}

		} while (option != 1 && option != 2 && option != 3);

	}

	public static void benData() { // method is called if user selects the beneficiary data option in the home menu

		int option;
		Scanner in2 = new Scanner(System.in);
		System.out.println("Following are the options:"); // asking user to choose their option
		System.out.println("1. Add new beneficiary data");
		System.out.println("2. Edit/delete beneficiary data");
		System.out.println("3. Back to home menu");
		System.out.println("4. Exit Application");
		// option = in2.nextInt();
		do {
			System.out.println("Please enter number");
			option = in2.nextInt();
			switch (option) { // switch case to complement the user's selection

			case 1:
				// adding ben data
				Data_Entry_Screen n = new Data_Entry_Screen();
				n.setVisible(true);
				addData();

				Beneficiary_Data b = new Beneficiary_Data();

//				b.personalDetails(id, bn, fn, ln, on, s, g, o, ci);
//				b.checkUp(l, lh, col, other, ly);
//				b.address(l1, l2, c, p, t, d, s, pc);
//				b.contact(p1, p2, email);
//				b.date(d, m, y);

				break;

			case 2:
				// editing/deleting ben data
				editData();
				break;

			case 3:
				// going back to home menu
				homeMenu();
				break;

			case 4:
				// quit
				System.exit(0);
				break;

			default:
				// display error message and accept new value
				System.out.println("You have entered an invalid value. Accepted values are 1, 2 or 3");
//				option = in.nextInt();
				benData();
			}

		} while (option != 1 && option != 2 && option != 3 && option != 4);

	}

	public static void editData() {
		try {
			File benData = new File("/Users/arnavmahale/Documents/CS IA/files/benData.csv");
			FileWriter fw = new FileWriter(benData);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < benList.size(); i++) {
				System.out.println("For loop");

//				bw.write(benList.get(i).getFirstName() + "," + benList.get(i).getLastName() + "," + benList.get(i).getID());
				bw.newLine();
				bw.flush();
			}
			bw.close();
			System.out.println("File Written");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void addData() {
		try {
			File benData = new File("/Users/arnavmahale/Documents/CS IA/files/benData.csv");
			FileWriter fw = new FileWriter(benData, true);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < benList.size(); i++) {
				System.out.println("For loop");

//				bw.write(benList.get(i).getFirstName() + "," + benList.get(i).getLastName() + "," + benList.get(i).getID());
				bw.newLine();
				bw.flush();
			}
			bw.close();
			System.out.println("File Written");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void readData() {
		File f = new File("/Users/arnavmahale/Documents/CS IA/files/benData.csv");
		String s = "";
		try {
			f.createNewFile();
			FileReader fr = new FileReader(f);
			BufferedReader buffer = new BufferedReader(fr);

			while ((s = buffer.readLine()) != null) {
				Beneficiary_Data b = new Beneficiary_Data();
				Address a = new Address();
				
				b.setID(Integer.parseInt(s.split(",")[0]));
				b.setBadgeNum(s.split(",")[1]);
				b.setFirstName(s.split(",")[2]);
				b.setLastName(s.split(",")[3]);
				b.setOtherName(s.split(",")[4]);
				b.setSex(s.split(",")[5].charAt(0));
				String dob = s.split(",")[6];
				b.setDob(new Date(Integer.parseInt(dob.split("/")[0]), Integer.parseInt(dob.split("/")[1]), Integer.parseInt(dob.split("/")[2])));
				a.setLine1(s.split("'")[7]);
				a.setLine2(s.split("'")[8]);
				a.city
				
			}

		} catch (Exception e) {
			System.out.println(e);
			;
		}
	}

}
