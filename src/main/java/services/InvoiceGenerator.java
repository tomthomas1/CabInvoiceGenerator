package services;

import java.util.HashMap;
import java.util.Map;

import entities.Invoice;
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
		double fare = (ride.distancePrice * ride.distance)+ (ride.timePrice * ride.time);
		
		return fare > 5 ? fare : 5;
	}
	
	/**
	 *  Method to calculate fare for multiples rides
	 *  We will calculate the fare and add it in the totalfare
	 * @param rides -  we will pass the dis and time
	 * @return - total ride, total fare and average fare
	 */
	public Invoice generateInvoice(Ride[] rides) {
		double singleFare;
		double totalFare = 0;
		for (Ride ride : rides) {
			singleFare = generateInvoice(ride);
			totalFare += singleFare > 5 ? singleFare : 5;
		}
		Invoice in = new Invoice(rides.length, totalFare, totalFare / rides.length);
		System.out.println(in);
		return in;
	}
	
	/**
	 *  Method to check user rides and generate invoice
	 * @param i - user
	 * @param rideRepo - to store the rides.
	 * @return - fare.
	 */
	public Invoice generateInvoice(int i, HashMap<Integer, Ride[]> rideRepo) {

		for (Map.Entry<Integer, Ride[]> rideEntry : rideRepo.entrySet()) {
			if (rideEntry.getKey() == i)
				return generateInvoice(rideEntry.getValue());
		}

		return null;
	}
}
