
import java.io.*;

import java.util.*;

import java.math.*;

public class Home_Menu {

	static ArrayList<Beneficiary_Data> benList = new ArrayList<Beneficiary_Data>();
	static ArrayList<Beneficiary_Data> sortedBenList = new ArrayList<Beneficiary_Data>();
	static Scanner in;

	public static void main(String[] args) {

		readData();
		homeMenu();

	}

	public static void homeMenu() {

		String option;
		in = new Scanner(System.in);

		do {
			System.out.println("Following are the options:"); // asking the use to choose their option
			System.out.println("1. Beneficiary Data");
			System.out.println("2. Trend Analysis");
			System.out.println("3. Exit Application");
			System.out.println("Please enter number"); // asking the use to choose their option

			option = in.next();

			switch (option) { // switch case to complement the user's selection

			case "1":
				// selected beneficiary data
				benData();
				break;

			case "2":
				// selected trend analysis, make histograms
				trendAnalysis();
				break;

			case "3":
				// quit
				System.exit(0);
				break;

			default:
				// display error message and accept new value
				System.out.println("You have entered an invalid value. Accepted values are 1, 2 or 3");

			}

		} while (!(option.equals("1")) && !(option.equals("2")) && !(option.equals("3")));

	}

	public static void benData() { // method is called if user selects the beneficiary data option in the home menu

		String option;

		System.out.println("Following are the options:"); // asking user to choose their option
		System.out.println("1. Add new beneficiary data");
		System.out.println("2. Edit beneficiary data");
		System.out.println("3. Back to home menu");
		System.out.println("4. Exit Application");
		System.out.println("Please enter number");
		in = new Scanner(System.in);

		do {

			option = in.next();

			switch (option) { // switch case to complement the user's selection

			case "1":
				// adding ben data
				java.awt.EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						new Data_Entry_Screen().setVisible(true);
					}
				});
				break;

			case "2":
				// editing ben data
				java.awt.EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						new Search_Screen().setVisible(true);
					}
				});
				break;

			case "3":
				// going back to home menu
				homeMenu();
				break;

			case "4":
				// quit
				System.exit(0);
				break;

			default:
				// display error message and accept new value
				System.out.println("You have entered an invalid value. Accepted values are 1, 2, 3 or 4");
				benData();
			}

		} while (!(option.equals("1")) && !(option.equals("2")) && !(option.equals("3")) && !(option.equals("4")));
	}

	public static void trendAnalysis() { // method is called if trend analysis is selected

		String option;
		in = new Scanner(System.in);
		System.out.println("Following are the options:"); // asking user to choose their option
		System.out.println("1. Display histogram");
		System.out.println("2. Back to home menu");
		System.out.println("3. Exit Application");
		do {
			System.out.println("Please enter number");
			option = in.next();
			switch (option) { // switch case to complement the user's selection

			case "1":
				// displaying the histogram
				Chart_Screen c = new Chart_Screen();
				c.setVisible(true);
				break;

			case "2":
				// going back to home menu
				homeMenu();
				break;

			case "3":
				// quit
				System.exit(0);
				break;

			default:
				// display error message and accept new value
				System.out.println("You have entered an invalid value. Accepted values are 1, 2 or 3");
				trendAnalysis();
			}

		} while (!(option.equals("1")) && !(option.equals("2")) && !(option.equals("3")));

	}

	public static void addData() { // append to file (file writer) method
		try {
			File benData = new File("/Users/arnavmahale/Documents/CS IA/files/benData.csv");
			FileWriter fw = new FileWriter(benData);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < benList.size(); i++) {

				bw.write(benList.get(i).getID() + "," + benList.get(i).getBadgeNum() + ","
						+ benList.get(i).getFirstName() + "," + benList.get(i).getLastName() + ","
						+ benList.get(i).getOtherName() + "," + benList.get(i).getSex() + "," + benList.get(i).getDob()
						+ "," + benList.get(i).getAddress().getLine1() + "," + benList.get(i).getAddress().getLine1()
						+ "," + benList.get(i).getAddress().getCity() + "," + benList.get(i).getAddress().getPost()
						+ "," + benList.get(i).getAddress().getDistrict() + ","
						+ benList.get(i).getAddress().getTaluka() + "," + benList.get(i).getAddress().getState() + ","
						+ benList.get(i).getAddress().getPinCode() + "," + benList.get(i).getContact().getPhoneNum1()
						+ "," + benList.get(i).getContact().getPhoneNum2() + ","
						+ benList.get(i).getContact().getEmail() + "," + benList.get(i).getOccupation() + ","
						+ benList.get(i).getHand().getLOREI() + "," + benList.get(i).getHand().getLostHand() + ","
						+ benList.get(i).getHand().getLossYear() + "," + benList.get(i).getHand().getCauseOfLoss() + ","
						+ benList.get(i).getHand().getOther() + "," + benList.get(i).getCampInfo());
				bw.newLine();
				bw.flush();
			}
			bw.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void readData() { // file reading method using the buffered reader class

		File f = new File("/Users/arnavmahale/Documents/CS IA/files/benData.csv");
		String s = " ";
		String[] values = null;
		try {
			f.createNewFile();
			FileReader fr = new FileReader(f);
			BufferedReader buffer = new BufferedReader(fr);

			// reading objects from csv file to store in the benList Array List
			while ((s = buffer.readLine()) != null) {

				Beneficiary_Data b = new Beneficiary_Data();
				values = s.split(",");
				b.setID(Integer.parseInt(values[0]));
				b.setBadgeNum(values[1]);
				b.setFirstName(values[2]);
				b.setLastName(values[3]);
				b.setOtherName(values[4]);
				b.setSex(values[5]);
				String dob = s.split(",")[6];
				b.setDob(new Date(dob));
				b.getAddress().setLine1(values[7]);
				b.getAddress().setLine2(values[8]);
				b.getAddress().setCity(values[9]);
				b.getAddress().setPost(values[10]);
				b.getAddress().setTaluka(values[11]);
				b.getAddress().setDistrict(values[12]);
				b.getAddress().setState(values[13]);
				b.getAddress().setPinCode(values[14]);
				b.getContact().setPhoneNum1(values[15]);
				b.getContact().setPhoneNum2(values[16]);
				b.getContact().setEmail(values[17]);
				b.setOccupation(values[18]);

				String d = values[19];
				b.getHand().setLOREI(Double.parseDouble(d));
				b.getHand().setLostHand(values[20]);
				b.getHand().setLossYear(Integer.parseInt(values[21]));
				b.getHand().setCauseOfLoss(values[22]);
				b.getHand().setOther(values[23]);
				b.setCampInfo(values[24]);

				benList.add(b);
			}

			fr.close();

		} catch (Exception e) {
			System.out.println(e);

		}

	}
}
