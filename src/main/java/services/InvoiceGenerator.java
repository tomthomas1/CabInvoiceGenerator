package services;

import entities.Ride;
/**
 * Class for invoice manipulation.
 * @author Tom
 *
 */
public class InvoiceGenerator {
	/**
	 *  Method to generate the fare 
	 * @param ride - we will pass the dis and time
	 * @return -  return fare.
	 */
	public double generateInvoice(Ride ride) {
		double fare = 10*ride.distance + ride.time;
		
		return fare > 5 ? fare : 5;
	}
	
	/**
	 *  Method to calculate fare for multiples rides
	 *  We will calculate the fare and add it in the totalfare
	 * @param rides -  we will pass the dis and time
	 * @return total fare
	 */
	public double generateInvoice(Ride[] rides) {
		double singleFare;
		double totalFare = 0;
		for (Ride ride : rides) {
			singleFare = 10*ride.distance + ride.time;
			totalFare += singleFare > 5 ? singleFare : 5;
		}
		return totalFare;
	}
}
