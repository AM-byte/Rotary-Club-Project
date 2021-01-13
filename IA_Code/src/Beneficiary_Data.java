
public class Beneficiary_Data {
	// declaring all required variables
	private int ID;
	private String badgeNum, firstName, lastName, otherName, occupation, campInfo;
	private char sex;
	private Date dob;
	private Address address;
	private Contact contact;
	private Hand hand;

	public Beneficiary_Data() {
		address = new Address();
		contact = new Contact();
		dob = new Date();
		hand = new Hand();
	}
	
	public void personalDetails(int id, String bn, String fn, String ln, String on, char s, String o, String ci) {
		this.ID = id;
		this.badgeNum = bn;
		this.firstName = fn;
		this.lastName = ln;
		this.otherName = on;
		this.sex = s;
		this.occupation = o;
		this.campInfo = ci;
		
	}

	public void address(String l1, String l2, String c, String p, String t, String d, String s, int pc) {
		address.setLine1(l1);
		address.setLine2(l2);
		address.setCity(c);
		address.setPost(p);
		address.setTaluka(t);
		address.setDistrict(d);
		address.setState(s);
		address.setPinCode(pc);
		
	}
	
	public void contact(int p1, int p2, String email) {
		contact.setPhoneNum1(p1);
		contact.setPhoneNum2(p2);
		contact.setEmail(email);
		
	}
	
	public void date(int d, int m, int y) {
		dob.setDate(d);
		dob.setMonth(m);
		dob.setYear(y);
		
	}
	
	public void checkUp(double l, String lh, String col, String other, int ly) {
		hand.setLOREI(l);
		hand.setLostHand(lh);
		hand.setCauseOfLoss(col);
		hand.setOther(other);
		hand.setLossYear(ly);

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		
		if(iD>1000) {
		ID = iD;
		}
	}

	public String getBadgeNum() {
		return badgeNum;
	}

	public void setBadgeNum(String badgeNum) {
		this.badgeNum = badgeNum;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getCampInfo() {
		return campInfo;
	}

	public void setCampInfo(String campInfo) {
		this.campInfo = campInfo;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	

}
