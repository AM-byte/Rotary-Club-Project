
import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Data_Entry_Screen extends JFrame {

	private JPanel contentPane;
	private JTextField IDtextfield;

	// Requires addition
	private int ID = 0;
	private String badgeNum = " ", firstName = " ", lastName = " ", otherName = " ", occupation = " ", campInfo = " ";
	private String sex;
	private String dob = " ";
	private String line1 = " ", line2 = " ", city = " ", post = " ", taluka = " ", district = " ", state = " ";
	private String pinCode = " ";
	private String phoneNum1 = " ", phoneNum2 = " ";
	private String email = " ";
	private double LOREI = 0;
	private String lostHand = " ", causeOfLoss = " ", other = " ";
	private int lossYear = 0;

	private JTextField badgeNumtextField;
	private JTextField firstNametextField;
	private JTextField lastNametextField;
	private JTextField otherNametextField;
	private JTextField citytextField;
	private JTextField posttextField;
	private JTextField talukatextField;
	private JTextField districttextField;
	private JTextField LOREItextField;
	private JTextField pinCodetextField;
	private JTextField phoneNum1textField;
	private JTextField phoneNum2textField;
	private JTextField emailtextField;
	private JTextField yearOfLosstextField;
	private JTextField othertextField;
	private JTextField dobtextField;

	private JComboBox sexcomboBox;
	private JComboBox statecomboBox;
	private JComboBox occupationcomboBox;
	private JComboBox lostHandcomboBox;
	private JComboBox causeOfLosscomboBox;
	private JComboBox infocomboBox;

	private JTextArea address1textArea;
	private JTextArea address2textArea;

	private JButton btnSavePrint;
	Beneficiary_Data b;

	/**
	 * Create the frame.
	 */
	public Data_Entry_Screen() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				Home_Menu.benData();
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		initComponents();
		this.setAlwaysOnTop(true);

		b = new Beneficiary_Data();
		IDtextfield.setText(b.getID() + "");
	}

//	public Data_Entry_Screen(int index) {
//		initComponents();
//
//		Beneficiary_Data b = Home_Menu.benList.get(index);
//
//		IDtextfield.setText(b.getID() + "");
//		badgeNumtextField.setText(b.getBadgeNum());
//		firstNametextField.setText(b.getFirstName());
//		lastNametextField.setText(b.getLastName());
//		otherNametextField.setText(b.getOtherName());
//		sexcomboBox.setSelectedItem(b.getSex());
//		dobtextField.setText(b.getDob().toString());
//		address1textArea.setText(b.getAddress().getLine1());
//		address2textArea.setText(b.getAddress().getLine2());
//		citytextField.setText(b.getAddress().getCity());
//		posttextField.setText(b.getAddress().getPost());
//		talukatextField.setText(b.getAddress().getTaluka());
//		districttextField.setText(b.getAddress().getDistrict());
//		statecomboBox.setSelectedItem(b.getAddress().getState());
//		pinCodetextField.setText(b.getAddress().getPinCode() + "");
//		phoneNum1textField.setText(b.getContact().getPhoneNum1() + "");
//		phoneNum2textField.setText(b.getContact().getPhoneNum2() + "");
//		emailtextField.setText(b.getContact().getEmail());
//		occupationcomboBox.setSelectedItem(b.getOccupation());
//		LOREItextField.setText(b.getHand().getLOREI() + "");
//		lostHandcomboBox.setSelectedItem(b.getHand().getLostHand());
//		yearOfLosstextField.setText(b.getHand().getLossYear() + "");
//		causeOfLosscomboBox.setSelectedItem(b.getHand().getCauseOfLoss());
//		othertextField.setText(b.getHand().getOther());
//		infocomboBox.setSelectedItem(b.getCampInfo());
//
//	}

	public boolean validName(String name) {
		boolean valid = true;
		char[] chars = name.toCharArray();
		for (char c : chars) {
			if (Character.isDigit(c)) {
				valid = false;
			}
		}
		return valid;
	}

	public boolean validDate(String date) {
		boolean valid = true;
		try {
			Date d = new Date(date);
		} catch (Exception e) {
			valid = false;
		}

		return valid;
	}

	public boolean onlyDigits(String str, int n) {
		for (int i = 0; i < n; i++) {
			if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
				return false;
			}
		}
		return true;
	}

	public boolean containNumbersOnly(String source) {

		source = source.trim();
		boolean result = false;
		Pattern pattern = Pattern.compile("[0-9]+.[0-9]+"); // correct pattern for both float and integer
		pattern = Pattern.compile("\\d+.\\d"); // correct pattern for both float and integer

		result = pattern.matcher(source).matches();
		if (result) {
			System.out.println("\"" + source + "\"" + " is a number");
		} else {
			System.out.println("\"" + source + "\"" + " is a String");
		}
		return result;
	}

	private void btnSavePrintActionPerformed() { // actions performed after the Save n Print button is pressed

		// getting all the variables from the form
		boolean valid = true;

		ID = b.getID();
		badgeNum = badgeNumtextField.getText();
		firstName = firstNametextField.getText();
		lastName = lastNametextField.getText();
		otherName = otherNametextField.getText();
		sex = sexcomboBox.getSelectedItem().toString();
		dob = dobtextField.getText();
		line1 = address1textArea.getText();
		line2 = address2textArea.getText();
		city = citytextField.getText();
		post = posttextField.getText();
		taluka = talukatextField.getText();
		district = districttextField.getText();
		state = statecomboBox.getSelectedItem().toString();
		pinCode = pinCodetextField.getText();
		phoneNum1 = phoneNum1textField.getText();
		phoneNum2 = phoneNum2textField.getText();
		email = emailtextField.getText();
		occupation = occupationcomboBox.getSelectedItem().toString();
		

		lostHand = lostHandcomboBox.getSelectedItem().toString();
		causeOfLoss = causeOfLosscomboBox.getSelectedItem().toString();
		other = othertextField.getText();
		campInfo = infocomboBox.getSelectedItem().toString();

		// validation
//		if (badgeNum.equals(" ") && validName(firstName) && validName(lastName) && validName(otherName)
//				&& validDate(dob) && line1.equals(" ") && validName(city) && city.equals(" ") && validName(post)
//				&& validName(taluka) && validName(district) && district.equals(" ") && (phoneNum1.length() != 11)
//				&& phoneNum1.equals(" ") && (phoneNum2.length() != 11) && !email.contains("@") && !email.contains(".")
//				&& containNumbersOnly(LOREItextField.getText())
//				&& onlyDigits(yearOfLosstextField.getText(), (yearOfLosstextField.getText().length()))) {
//			valid = false;
//		}
		
		if (badgeNum.equals(" ")) {
			valid = false;
			JOptionPane.showMessageDialog(rootPane, "Please check Badge Number");
		} else if (validName(firstName)) {
			valid = false;
			JOptionPane.showMessageDialog(rootPane, "Please check First Name");
		} else if (validName(lastName)) {
			valid = false;
			JOptionPane.showMessageDialog(rootPane, "Please check Last Name");
		} else if (validName(otherName)) {
			valid = false;
			JOptionPane.showMessageDialog(rootPane, "Please check Father's Number");
		} else if (validDate(dob)) {
			valid = false;
			JOptionPane.showMessageDialog(rootPane, "Please check Date of Birth");
		} else if (line1.equals(" ")) {
			valid = false;
			JOptionPane.showMessageDialog(rootPane, "Please check Address Line 1");
		} else if (validName(city)) {
			valid = false;
			JOptionPane.showMessageDialog(rootPane, "Please check City");
		} else if (city.equals(" ")) {
			valid = false;
			JOptionPane.showMessageDialog(rootPane, "Please check City");
		} else if (validName(post)) {
			valid = false;
			JOptionPane.showMessageDialog(rootPane, "Please check Post");
		} else if (validName(taluka)) {
			valid = false;
			JOptionPane.showMessageDialog(rootPane, "Please check Taluka");
		} else if (validName(district)) {
			valid = false;
			JOptionPane.showMessageDialog(rootPane, "Please check District");
		} else if (district.equals(" ")) {
			valid = false;
			JOptionPane.showMessageDialog(rootPane, "Please check District");
		} else if (phoneNum1.length() != 11) {
			valid = false;
			JOptionPane.showMessageDialog(rootPane, "Please check Telephone Number 1");
		} else if (phoneNum2.length() != 11) {
			valid = false;
			JOptionPane.showMessageDialog(rootPane, "Please check Telephone Number 2");
		} else if (phoneNum1.equals(" ")) {
			valid = false;
			JOptionPane.showMessageDialog(rootPane, "Please check Telephone Number 1");
		} else if (!(email.contains("@")) && !(email.contains("."))) {
			valid = false;
			JOptionPane.showMessageDialog(rootPane, "Please check Email Address");
		} else if (containNumbersOnly(LOREItextField.getText())) {
			valid = false;
			JOptionPane.showMessageDialog(rootPane, "Please check Length of Resibual Elbow");
		} else if (onlyDigits(yearOfLosstextField.getText(), (yearOfLosstextField.getText().length()))) {
			valid = false;
			JOptionPane.showMessageDialog(rootPane, "Please check Loss Year");
		}
		
		try {			
			LOREI = Double.parseDouble((LOREItextField.getText()));
			lossYear = Integer.parseInt(yearOfLosstextField.getText());

		} catch(Exception e) {
			JOptionPane.showMessageDialog(rootPane, "Please enter Length of Residual Elbow and Loss Year");
		}
//		 checking if valid remains true, although this is not required as the if statements 
//		 above will make sure that does not happen
//		 adding all the variables to their respective constructors and then adding the
//		 one beneficiary to the benList Array List
		if (valid) {

			b.personalDetails(ID, badgeNum, firstName, lastName, otherName, sex, occupation, campInfo);
			b.address(line1, line2, city, post, taluka, district, state, pinCode); // error
			b.checkUp(LOREI, lostHand, causeOfLoss, other, lossYear);
			b.date(Integer.parseInt(dob.split("/")[0]), Integer.parseInt(dob.split("/")[1]),
					Integer.parseInt(dob.split("/")[2]));
			Home_Menu.benList.add(b);

			Home_Menu.addData();

			String[] buttons = { "Add more", "Back to Menu" };
			int rc = JOptionPane.showOptionDialog(rootPane, "Data Added", "Success", JOptionPane.INFORMATION_MESSAGE, 0, null, buttons, buttons[1]);
			if(rc == 0) {
//				reset();
				this.dispose();
				Data_Entry_Screen a = new Data_Entry_Screen();
				a.setVisible(true);
			} else if (rc == 1) {
				this.dispose();
				Home_Menu.benData();

			}
		}

	}

	private void reset() {
		IDtextfield.setText((b.getID() + 1) + "");
		badgeNumtextField.setText(" ");
		firstNametextField.setText(" ");
		lastNametextField.setText(" ");
		otherNametextField.setText(" ");
		sexcomboBox.setSelectedItem(" ");
		dobtextField.setText(" ");
		address1textArea.setText(" ");
		address2textArea.setText(" ");
		citytextField.setText(" ");
		posttextField.setText(" ");
		talukatextField.setText(" ");
		districttextField.setText(" ");
		statecomboBox.setSelectedItem(" ");
		pinCodetextField.setText(" ");
		phoneNum1textField.setText(" ");
		phoneNum2textField.setText(" ");
		emailtextField.setText(" ");
		occupationcomboBox.setSelectedItem(" ");
		LOREItextField.setText(" ");
		lostHandcomboBox.setSelectedItem(" ");
		yearOfLosstextField.setText(" ");
		causeOfLosscomboBox.setSelectedItem(" ");
		othertextField.setText(" ");
		infocomboBox.setSelectedItem(" ");

	}

	private void dobtextFieldActionPerformed() {
		dobtextField.setText("");
	}

	// gui code
	private void initComponents() {
		setBounds(100, 100, 650, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Beneficiary Data");
		lblNewLabel.setBounds(6, 6, 101, 16);

		IDtextfield = new JTextField();
		IDtextfield.setEditable(false);
		IDtextfield.setBounds(125, 29, 130, 26);
		IDtextfield.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ID: (Auto)");
		lblNewLabel_1.setBounds(6, 34, 68, 16);

		statecomboBox = new JComboBox();

		statecomboBox.setBounds(483, 29, 136, 20);
		statecomboBox.setModel(new DefaultComboBoxModel(
				new String[] { " ", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa",
						"Gujarat", "Haryana", "Himachal Pradesh", "Jharkand", "Karnataka", "Kerala", "Madhya Pradesh",
						"Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan",
						"Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal",
						"Andaman and Nicobar Islands", "Chandigarh", "Dadra and Nagar Haveli and Daman and Diu",
						"Delhi", "Jammu and Kashmir", "Ladhakh", "Lakshwadeep", "Puducherry" }));

		JLabel lblNewLabel_2 = new JLabel("Sex: *");
		lblNewLabel_2.setBounds(6, 190, 36, 16);

		JLabel lblNewLabel_3 = new JLabel("Address Line 1: *");
		lblNewLabel_3.setBounds(6, 255, 107, 16);

		address1textArea = new JTextArea();
		address1textArea.setBounds(125, 255, 130, 26);

		JLabel lblNewLabel_4 = new JLabel("State: *");
		lblNewLabel_4.setBounds(267, 34, 50, 16);

		JLabel lblNewLabel_5 = new JLabel("Badge Number: *");
		lblNewLabel_5.setBounds(6, 62, 105, 16);

		badgeNumtextField = new JTextField();
		badgeNumtextField.setBounds(125, 57, 130, 26);
		badgeNumtextField.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("First Name: *");
		lblNewLabel_6.setBounds(6, 90, 86, 16);

		firstNametextField = new JTextField();
		firstNametextField.setBounds(125, 85, 130, 26);
		firstNametextField.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Surname: *");
		lblNewLabel_7.setBounds(6, 118, 68, 16);

		lastNametextField = new JTextField();
		lastNametextField.setBounds(125, 113, 130, 26);
		lastNametextField.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Father's/Husband's");
		lblNewLabel_8.setBounds(6, 146, 122, 16);

		otherNametextField = new JTextField();
		otherNametextField.setBounds(125, 157, 130, 26);
		otherNametextField.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Name: *");
		lblNewLabel_9.setBounds(6, 162, 50, 16);

		sexcomboBox = new JComboBox();
		sexcomboBox.setBounds(125, 186, 130, 27);
		sexcomboBox.setModel(new DefaultComboBoxModel(new String[] { " ", "Male", "Female", "Other" }));

		JLabel lblNewLabel_10 = new JLabel("Address Line 2:");
		lblNewLabel_10.setBounds(6, 295, 107, 16);

		address2textArea = new JTextArea();
		address2textArea.setBounds(125, 290, 130, 26);

		JLabel lblNewLabel_11 = new JLabel("City: *");
		lblNewLabel_11.setBounds(6, 337, 39, 16);

		citytextField = new JTextField();
		citytextField.setBounds(125, 330, 130, 26);
		citytextField.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("Post:");
		lblNewLabel_12.setBounds(6, 375, 41, 16);

		posttextField = new JTextField();
		posttextField.setBounds(125, 368, 130, 26);
		posttextField.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("Taluka:");
		lblNewLabel_13.setBounds(6, 410, 61, 16);

		talukatextField = new JTextField();
		talukatextField.setBounds(125, 405, 130, 26);
		talukatextField.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("District: *");
		lblNewLabel_14.setBounds(6, 446, 61, 16);

		districttextField = new JTextField();
		districttextField.setBounds(125, 441, 130, 26);
		districttextField.setColumns(10);

		JLabel lblNewLabel_15 = new JLabel("Pin Code: *");
		lblNewLabel_15.setBounds(267, 62, 75, 16);

		JLabel lblNewLabel_16 = new JLabel("Telephone Number 1: *");
		lblNewLabel_16.setBounds(267, 95, 149, 16);

		JLabel lblNewLabel_17 = new JLabel("Telephone Number 2:");
		lblNewLabel_17.setBounds(267, 128, 149, 16);

		JLabel lblNewLabel_18 = new JLabel("Email:");
		lblNewLabel_18.setBounds(267, 168, 61, 16);

		JLabel lblNewLabel_19 = new JLabel("Occupation: *");
		lblNewLabel_19.setBounds(267, 207, 86, 16);

		JLabel lblNewLabel_20 = new JLabel("Length of Residual Elbow (inches): *");
		lblNewLabel_20.setBounds(267, 248, 233, 16);

		JLabel lblNewLabel_21 = new JLabel("Lost Hand: *");
		lblNewLabel_21.setBounds(267, 289, 86, 16);

		JLabel lblNewLabel_22 = new JLabel("Year of Loss: *");
		lblNewLabel_22.setBounds(267, 330, 101, 16);

		JLabel lblNewLabel_23 = new JLabel("Cause of Loss of Hand: *");
		lblNewLabel_23.setBounds(267, 370, 156, 16);

		JLabel lblNewLabel_24 = new JLabel("Other cause of Loss:");
		lblNewLabel_24.setBounds(267, 410, 130, 16);

		JLabel lblNewLabel_25 = new JLabel("Where did you hear about the camp?*");
		lblNewLabel_25.setBounds(267, 446, 233, 16);

		LOREItextField = new JTextField();
		LOREItextField.setBounds(490, 242, 130, 26);
		LOREItextField.setColumns(10);

		pinCodetextField = new JTextField();
		pinCodetextField.setBounds(489, 57, 130, 26);
		pinCodetextField.setColumns(10);

		phoneNum1textField = new JTextField();
		phoneNum1textField.setBounds(489, 90, 130, 26);
		phoneNum1textField.setColumns(10);

		phoneNum2textField = new JTextField();
		phoneNum2textField.setBounds(489, 120, 130, 26);
		phoneNum2textField.setColumns(10);

		emailtextField = new JTextField();
		emailtextField.setBounds(489, 155, 130, 26);
		emailtextField.setColumns(10);

		occupationcomboBox = new JComboBox();
		occupationcomboBox.setBounds(483, 200, 136, 27);
		occupationcomboBox.setModel(
				new DefaultComboBoxModel(new String[] { " ", "School", "College", "Home", "Working", "Others" }));

		lostHandcomboBox = new JComboBox();
		lostHandcomboBox.setBounds(483, 280, 136, 26);
		lostHandcomboBox
				.setModel(new DefaultComboBoxModel(new String[] { " ", "Right hand", "Left hand", "Both hands" }));

		yearOfLosstextField = new JTextField();
		yearOfLosstextField.setBounds(489, 321, 130, 26);
		yearOfLosstextField.setColumns(10);

		causeOfLosscomboBox = new JComboBox();
		causeOfLosscomboBox.setBounds(489, 362, 130, 27);
		causeOfLosscomboBox.setModel(new DefaultComboBoxModel(new String[] { " ", "Accident - Agricultural",
				"Accident - Electrocution", "Accident - Industrial", "Accident - Vehicular", "Birth Defect",
				"Violence, Robbery, etc.", "War, Landmine, etc.", "Others" }));

		othertextField = new JTextField();
		othertextField.setBounds(489, 405, 130, 26);
		othertextField.setColumns(10);

		infocomboBox = new JComboBox();
		infocomboBox.setBounds(499, 442, 120, 27);
		infocomboBox.setModel(new DefaultComboBoxModel(
				new String[] { " ", "Friends", "Hospital", "Posters", "Rotary Volunteer", "WhatsApp" }));

		btnSavePrint = new JButton("Save n Print");
		btnSavePrint.setBounds(247, 474, 117, 29);
		btnSavePrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSavePrintActionPerformed();
			}
		});

		JLabel lblNewLabel_26 = new JLabel("Date of Birth: *");
		lblNewLabel_26.setBounds(6, 223, 93, 16);

		dobtextField = new JTextField();
		dobtextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dobtextFieldActionPerformed();

			}
		});
//		
		dobtextField.setText("dd/mm/yyyy");
		dobtextField.setBounds(125, 215, 130, 26);
		dobtextField.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(IDtextfield);
		contentPane.add(lblNewLabel_4);
		contentPane.add(statecomboBox);
		contentPane.add(lblNewLabel_5);
		contentPane.add(badgeNumtextField);
		contentPane.add(lblNewLabel_15);
		contentPane.add(pinCodetextField);
		contentPane.add(lblNewLabel_6);
		contentPane.add(lblNewLabel_7);
		contentPane.add(firstNametextField);
		contentPane.add(lastNametextField);
		contentPane.add(lblNewLabel_16);
		contentPane.add(lblNewLabel_17);
		contentPane.add(phoneNum1textField);
		contentPane.add(phoneNum2textField);
		contentPane.add(lblNewLabel_8);
		contentPane.add(otherNametextField);
		contentPane.add(lblNewLabel_9);
		contentPane.add(lblNewLabel_18);
		contentPane.add(emailtextField);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_3);
		contentPane.add(lblNewLabel_10);
		contentPane.add(lblNewLabel_11);
		contentPane.add(lblNewLabel_12);
		contentPane.add(sexcomboBox);
		contentPane.add(address1textArea);
		contentPane.add(address2textArea);
		contentPane.add(citytextField);
		contentPane.add(posttextField);
		contentPane.add(lblNewLabel_19);
		contentPane.add(occupationcomboBox);
		contentPane.add(lblNewLabel_20);
		contentPane.add(LOREItextField);
		contentPane.add(lblNewLabel_21);
		contentPane.add(lostHandcomboBox);
		contentPane.add(lblNewLabel_22);
		contentPane.add(yearOfLosstextField);
		contentPane.add(lblNewLabel_13);
		contentPane.add(talukatextField);
		contentPane.add(lblNewLabel_23);
		contentPane.add(causeOfLosscomboBox);
		contentPane.add(lblNewLabel_14);
		contentPane.add(districttextField);
		contentPane.add(lblNewLabel_24);
		contentPane.add(othertextField);
		contentPane.add(lblNewLabel_26);
		contentPane.add(dobtextField);
		contentPane.add(infocomboBox);
		contentPane.add(lblNewLabel_25);
		contentPane.add(btnSavePrint);

	}

}
