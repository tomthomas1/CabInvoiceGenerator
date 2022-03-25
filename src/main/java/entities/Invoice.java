package entities;

/**
 * class for Enhanced invoice
 * here we have total ride count, total fare and the average fare.
 * @author Tom
 *
 */
public class Invoice {

	public int rideCount;
	public double totalFare;
	public double avgFare;
     //constructor
	public Invoice(int rideCount, double totalFare, double avgFare) {
		super();
		this.rideCount = rideCount;
		this.totalFare = totalFare;
		this.avgFare = avgFare;
	}

	/**
	 * We are overriding the equals method.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		return Double.doubleToLongBits(avgFare) == Double.doubleToLongBits(other.avgFare)
				&& rideCount == other.rideCount
				&& Double.doubleToLongBits(totalFare) == Double.doubleToLongBits(other.totalFare);
	}
	
	@Override
	public String toString() {
		return "Invoice [rideCount=" + rideCount + ", totalFare=" + totalFare + ", avgFare=" + avgFare + "]";
	}
	
	

}
