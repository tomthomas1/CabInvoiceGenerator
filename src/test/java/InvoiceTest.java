import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entities.Invoice;
import entities.Ride;
import entities.RideRepository;
import services.InvoiceGenerator;

/**
 * In this we have written the test cases for our program
 * We are using the TDD approach here.
 *  @Before annotation are run before each test. This is useful when we want to execute some common code before running a test.
 * @author Tom
 *
 */
public class InvoiceTest {
	InvoiceGenerator invoice;
	RideRepository rideRepository = new RideRepository();
	HashMap<Integer, Ride[]> rideRepo;
	
	@Before 
	public void initialization() {
		invoice = new InvoiceGenerator();
		rideRepo = rideRepository.getRideRepo();
	}
	
	/**
	 * We have written this test case to check the total fare.
	 * Here 10 X 10 = 100 + 3 X 1 =3
	 * So total Rs.103
	 */
	@Test
	public void testGenerateInvoice() {

		assertEquals(103, invoice.generateInvoice(new Ride(10, 3, "normal")), 0.0);
	}
	/**
	 * Test case to check for minimum fare.
	 * If the fare is less that Rs.5 then we our min fare will be Rs.5.
	 */
	public void testGenerateInvoice_getMin() {

		assertEquals(5, invoice.generateInvoice(new Ride(0.1, 1, "normal")), 0.0);
	}
	
	@Test
	public void testGenerateInvoice_multipleRides() {

		Ride[] rides1 = { new Ride(0.1, 2, "premium"), new Ride(10, 3, "normal") };
		Ride[] rides2 = { new Ride(3, 2, "normal"), new Ride(1, 3, "premium"), new Ride(150, 300, "premium") };
		Ride[] rides3 = { new Ride(5, 7, "normal") };

		rideRepo.put(1, rides1);
		rideRepo.put(2, rides2);
		rideRepo.put(3, rides3);

		Invoice invoices = new Invoice(3, 2903, 967.6666666666666);

		assertEquals(invoices, invoice.generateInvoice(2, rideRepo));
	}
}