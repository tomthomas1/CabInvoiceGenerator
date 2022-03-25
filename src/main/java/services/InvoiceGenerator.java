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
}
