
import java.io.*;

import java.util.*;

import java.math.*;

public class Home_Menu {

	static ArrayList<Beneficiary_Data> benList = new ArrayList<Beneficiary_Data>();
	static ArrayList<Beneficiary_Data> sortedBenList = new ArrayList<Beneficiary_Data>();
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		readData();

//		readDataScanner();
//		
		for(Beneficiary_Data b: benList) {
			System.out.println(b.getID() + ": "+  b.getDob() + ":"+b.getOccupation() + " " + b.getHand().getLOREI()+ " "+b.getHand().getCauseOfLoss()
					
					
					+ ": "+b.getHand().getLossYear());
		}
		homeMenu();

	}

	public static void homeMenu() {

		int option;

//		option = in.nextInt();

		do {
			System.out.println("Following are the options:"); // asking the use to choose their option
			System.out.println("1. Beneficiary Data");
			System.out.println("2. Trend Analysis");
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
				// selected trend analysis, make histograms
				System.out.println("Trend Analysis");
				trendAnalysis();
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
				Search_Screen s = new Search_Screen();
				s.setVisible(true);
//				editData();
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
				System.out.println("You have entered an invalid value. Accepted values are 1, 2, 3 or 4");
//				option = in.nextInt();
				benData();
			}

		} while (option != 1 && option != 2 && option != 3 && option != 4);

	}

	public static void trendAnalysis() { // method is called if the use selects the trend analysis option in the home
											// menu

		int option;
		Scanner in2 = new Scanner(System.in);
		System.out.println("Following are the options:"); // asking user to choose their option
		System.out.println("1. Display histogram");
		System.out.println("2. Back to home menu");
		System.out.println("3. Exit Application");
		// option = in2.nextInt();
		do {
			System.out.println("Please enter number");
			option = in2.nextInt();
			switch (option) { // switch case to complement the user's selection

			case 1:
				// displaying the histogram
				System.out.println("Histogram option was successfully selected");

				break;

			case 2:
				// going back to home menu
				homeMenu();
				break;

			case 3:
				// quit
				System.exit(0);
				break;

			default:
				// display error message and accept new value
				System.out.println("You have entered an invalid value. Accepted values are 1, 2 or 3");
//				option = in.nextInt();
				trendAnalysis();
			}

		} while (option != 1 && option != 2 && option != 3 && option != 4);

	}

	public static void editData() { // write to file (file writer) method
		try {
			File benData = new File("/Users/arnavmahale/Documents/CS IA/files/benDataNew.csv");
			FileWriter fw = new FileWriter(benData);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < benList.size(); i++) {

				bw.write(benList.get(i).getFirstName() + "," + benList.get(i).getLastName() + "," + benList.get(i).getID());
				bw.newLine();
				bw.flush();
			}
			bw.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void addData() { // append to file (file writer) method
		try {
			File benData = new File("/Users/arnavmahale/Documents/CS IA/files/benDataNew.csv");
			FileWriter fw = new FileWriter(benData, true);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < benList.size(); i++) {

				bw.write(benList.get(i).getFirstName() + "," + benList.get(i).getLastName() + ","
						+ benList.get(i).getID());  //add codes
				bw.newLine();
				bw.flush();
			}
			bw.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void readData() { // file reading method

		File f = new File("/Users/arnavmahale/Documents/CS IA/files/benData.csv");
		String s = "";
		String[] values = null;
		try {
			f.createNewFile();
			FileReader fr = new FileReader(f);
			BufferedReader buffer = new BufferedReader(fr);

			// reading objects from csv file to store in the benList Array List
			while ((s = buffer.readLine()) != null) {

				Beneficiary_Data b = new Beneficiary_Data();
				values = s.split(",");

				for (String i : values) {
					System.out.println(i);
				}

				b.setID(Integer.parseInt(values[0]));
				b.setBadgeNum(values[1]);
				b.setFirstName(values[2]);
				b.setLastName(values[3]);
				b.setOtherName(values[4]);
				String s1 = values[5];
				b.setSex(s1.charAt(0));

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

	public static void readDataScanner() { // file reading method

		File f = new File("/Users/arnavmahale/Documents/CS IA/files/benData.csv");
		String s = "";
		String[] values = null;
		try {
			Scanner sc = new Scanner(f);

			// reading objects from csv file to store in the benList Array List
			while (sc.hasNext()) {

				Beneficiary_Data b = new Beneficiary_Data();
				s = sc.nextLine();
				values = s.split(",");

				b.setID(Integer.parseInt(values[0]));
				b.setBadgeNum(values[1]);
				b.setFirstName(values[2]);
				b.setLastName(values[3]);
				b.setOtherName(values[4]);
				String s1 = values[5];
				b.setSex(s1.charAt(0));

				String dob = s.split(",")[6];
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

		} catch (IOException e) {
			System.out.println(e);

		}

	}

	public static void serialize(ArrayList<Beneficiary_Data> list) {
		try {
			FileOutputStream fileOut = new FileOutputStream("/Users/arnavmahale/Documents/CS IA/files/benData.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			for (int i = 0; i < list.size(); i++) {

				out.writeObject(list.get(i));
			}
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in /Users/arnavmahale/Documents/CS IA/files/benData.ser");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deserialize() {
		try {
			FileInputStream fileIn = new FileInputStream("/Users/arnavmahale/Documents/CS IA/files/benData.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Beneficiary_Data b = new Beneficiary_Data();
			b = (Beneficiary_Data) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e2) {
			System.out.println("Beneficiary Data not found");
			e2.printStackTrace();
		}
	}

}
