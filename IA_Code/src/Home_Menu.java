
import java.io.*;
import java.util.*;
import java.math.*;

public class Home_Menu {

	static ArrayList<Beneficiary_Data> benList = new ArrayList<Beneficiary_Data>();
	static ArrayList<Beneficiary_Data> sortedBenList = new ArrayList<Beneficiary_Data>();
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
				Search_Screen s = new Search_Screen();
				s.setVisible(true);
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

	public static void editData() { // write to file (file writer) method
		try {
			File benData = new File("/Users/arnavmahale/Documents/CS IA/files/benData.csv");
			FileWriter fw = new FileWriter(benData);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < benList.size(); i++) {
				System.out.println("For loop");
//				Search_Screen s = new Search_Screen();
//				s.setVisible(true);

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

	public static void addData() { // append to file (file writer) method
		try {
			File benData = new File("/Users/arnavmahale/Documents/CS IA/files/benData.csv");
			FileWriter fw = new FileWriter(benData, true);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < benList.size(); i++) {
				System.out.println("For loop");
//				Data_Entry_Screen n = new Data_Entry_Screen();
//				n.setVisible(true);

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

	public static void readData() { // file reading method
		File f = new File("/Users/arnavmahale/Documents/CS IA/files/benData.csv");
		String s = "";
		try {
			f.createNewFile();
			FileReader fr = new FileReader(f);
			BufferedReader buffer = new BufferedReader(fr);

			while ((s = buffer.readLine()) != null) {
				Beneficiary_Data b = new Beneficiary_Data();
//				Address a = new Address();
//				Contact c = new Contact();
//				Hand h = new Hand();

				b.setID(Integer.parseInt(s.split(",")[0]));
				b.setBadgeNum(s.split(",")[1]);
				b.setFirstName(s.split(",")[2]);
				b.setLastName(s.split(",")[3]);
				b.setOtherName(s.split(",")[4]);
				b.setSex(s.split(",")[5].charAt(0));
				String dob = s.split(",")[6];
				b.setDob(new Date(Integer.parseInt(dob.split("/")[0]), Integer.parseInt(dob.split("/")[1]), Integer.parseInt(dob.split("/")[2])));
//				a.setLine1(s.split("'")[7]);
//				a.setLine2(s.split("'")[8]);
//				a.setCity(s.split("'")[9]);
//				a.setPost(s.split(",")[10]);
//				a.setTaluka(s.split(",")[11]);
//				a.setPost(s.split(",")[12]);
//				a.setState(s.split(",")[13]);
//				a.setPinCode(Integer.parseInt(s.split(",")[14]));
//				c.setPhoneNum1(Integer.parseInt(s.split(",")[15]));
//				c.setPhoneNum2(Integer.parseInt(s.split(",")[16]));
//				c.setEmail(s.split(",")[17]);
				b.setOccupation(s.split(",")[18]);
//				h.setLOREI(Double.parseDouble(s.split(",")[19]));
//				h.setLostHand(s.split(",")[20]);
//				h.setLossYear(Integer.parseInt(s.split(",")[21]));
//				h.setCauseOfLoss(s.split(",")[22]);
//				h.setOther(s.split(",")[23]);
				b.setCampInfo(s.split(",")[24]);

				Home_Menu.benList.add(b);
			}

		} catch (Exception e) {
			System.out.println(e);
			;
		}
	}

	// taking the last element as a pivot, places the pivot element at its correct
	// position in sorted array places all elements before or after the pivot depending on whether or not it is larger
	private void partition(ArrayList<Beneficiary_Data> arr, int low, int high) {
		int pivot = arr[high];
		int i = (low - 1); // index of smaller element
		for (int j = low; j < high; j++) {
			// If current element is smaller than the pivot
			if (arr[j] < pivot) {
				i++;

				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

	}

	private void quickSort(ArrayList<Beneficiary_Data> arr, int low, int high) { // sorting the benList array
		if (low >= high){
            return; // base case
        }
        if (low < high) {
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
	}

//	public static int binarySearch(ArrayList<Beneficiary_Data> ar, int key) {
//        int low = 0;
//        int high = ar.size() - 1;
//        while(low <= high) {
//            int middle = low + (high-1)/2;
//            if(ar.get(middle).getID() == key) {
//                return middle;
//            }
//            if(ar.get(middle).getID() < key ) {
//                low = middle + 1;
//            }
//            else {
//                high = middle - 1;
//            }
//        }
//        return -1;
//	}

}
