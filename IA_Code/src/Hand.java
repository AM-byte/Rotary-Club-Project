
public class Hand {
	// declaring all required variables
	private double LOREI;
	private String lostHand, couseOfLoss, other;
	private int lossYear;
	
	public double getLOREI() {
		return LOREI;
	}
	public void setLOREI(double lOREI) {
		LOREI = lOREI;
	}
	public String getLostHand() {
		return lostHand;
	}
	public void setLostHand(String lostHand) {
		this.lostHand = lostHand;
	}
	public String getCouseOfLoss() {
		return couseOfLoss;
	}
	public void setCouseOfLoss(String couseOfLoss) {
		this.couseOfLoss = couseOfLoss;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public int getLossYear() {
		return lossYear;
	}
	public void setLossYear(int lossYear) {
		this.lossYear = lossYear;
	}
}
