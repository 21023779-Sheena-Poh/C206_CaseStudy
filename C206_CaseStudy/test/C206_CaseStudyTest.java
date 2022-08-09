import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private Feedback fb1;
	private Feedback fb2;
	private Feedback fb3;

	private BikePart bp1;
	private BikePart bp2;
	private BikePart bp3;

	private Bike b1;
	private Bike b2;
	private Bike b3;

	private ArrayList<Feedback> feedbackList;
	private ArrayList<BikePart> bikePartList;
	private ArrayList<Bike> bikeList;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		fb1 = new Feedback("F123", "bad quality");
		fb2 = new Feedback("F124", "item recieved on time");
		fb3 = new Feedback("F125", "item not packed properly");

		bp1 = new BikePart("BP1", "Leather Seat", 85.90, "bike seat");
		bp2 = new BikePart("BP2", "Off Road Tyres", 150.80, "bike tyre");
		bp3 = new BikePart("BP3", "Timber Handlebar", 90.00, "bike handle");

		b1 = new Bike("B1", "Slick Road Bike", 160.00, "Red");
		b2 = new Bike("B2", "Giant Mountain Bike", 220.50, "Blue");
		b3 = new Bike("B3", "Trek Folding Bike", 190.90, "Yellow");

		feedbackList = new ArrayList<Feedback>();
		bikePartList = new ArrayList<BikePart>();
		bikeList = new ArrayList<Bike>();

	}

	@Test
	public void c206_test() {
		assertTrue("C206_CaseStudyTest ", true);
	}

	@Test
	public void testaddFeedback() {
		assertNotNull("Check if there is valid Feedback arraylist to add to", feedbackList);

		C206_CaseStudy.addFeedback(feedbackList, fb1);
		assertEquals("Check that feedback arraylist size is 1", 1, feedbackList.size());
		assertSame("Check that feedback is added", fb1, feedbackList.get(0));

		C206_CaseStudy.addFeedback(feedbackList, fb2);
		assertEquals("Check that feedback arraylist size is 2", 2, feedbackList.size());
		assertSame("Check that feedback is added", fb2, feedbackList.get(1));

		C206_CaseStudy.addFeedback(feedbackList, fb3);
		assertEquals("Check that feedback arraylist size is 3", 3, feedbackList.size());
		assertSame("Check that feedback is added", fb3, feedbackList.get(2));
	}

	@Test
	public void testViewFeedback() {
		// Item list is not null, so that we can add a new item
		assertNotNull("Test if there is a valid feedback arraylist to add to", feedbackList);

		// Test if the list of buyer retrieved from the BikersPortal is empty
		assertEquals("Check that feedback is empty at the start", 0, feedbackList.size());

		// Given an empty list, after adding 3 items, test if the size of the list is 3
		C206_CaseStudy.addFeedback(feedbackList, fb1);
		C206_CaseStudy.addFeedback(feedbackList, fb2);
		C206_CaseStudy.addFeedback(feedbackList, fb3);
		assertEquals("Test if that Bike arraylist size is 3?", 3, feedbackList.size());
	}

	@Test
	public void testDeleteFeedback() {
		// Item list is not null, so that we can delete a new item
		assertNotNull("Test if there is a valid Bike arraylist to delete from", feedbackList);

		// After adding 1 item, test if the size of the list is 1
		C206_CaseStudy.addFeedback(feedbackList, fb1);
		assertEquals("Test if that Bike arraylist size is 1?", 1, feedbackList.size());

		// Delete the item, and test if the size of the list is 0
		C206_CaseStudy.deleteFeedback(feedbackList); // Requires user input in console
		assertEquals("Test if that Bike arraylist size is 0?", 0, feedbackList.size());
	}

	@Test
	public void testaddBikePart() {
		assertNotNull("Check if there is valid Feedback arraylist to add to", bikePartList);

		C206_CaseStudy.addBikePart(bikePartList, bp1);
		assertEquals("Check that bike part arraylist size is 1", 1, bikePartList.size());
		assertSame("Check that bike part is added", bp1, bikePartList.get(0));

		C206_CaseStudy.addBikePart(bikePartList, bp1);
		assertEquals("Check that bike part arraylist size is 2", 2, bikePartList.size());
		assertSame("Check that bike part is added", bp1, bikePartList.get(1));
	}

	@Test
	public void testViewBikePart() {
		// Item list is not null, so that we can add a new item
		assertNotNull("Test if there is a valid Bikepart arraylist to add to", bikePartList);

		// Test if the list of buyer retrieved from the BikersPortal is empty
		assertEquals("Check that bikepartlist is empty at the start", 0, bikePartList.size());

		// Given an empty list, after adding 3 items, test if the size of the list is 3
		C206_CaseStudy.addBikePart(bikePartList, bp1);
		C206_CaseStudy.addBikePart(bikePartList, bp2);
		C206_CaseStudy.addBikePart(bikePartList, bp3);
		assertEquals("Test if that Bikepart arraylist size is 3?", 3, bikePartList.size());
	}

	@Test
	public void testDeleteBikePart() {
		// Item list is not null, so that we can delete a new item
		assertNotNull("Test if there is a valid Bikepart arraylist to delete from", bikePartList);

		// After adding 1 item, test if the size of the list is 1
		C206_CaseStudy.addBikePart(bikePartList, bp1);
		assertEquals("Test if that Bikepart arraylist size is 1?", 1, bikePartList.size());

		// Delete the item, and test if the size of the list is 0
		C206_CaseStudy.deleteBikePart(bikePartList); // Requires user input in console
		assertEquals("Test if that Bikepart arraylist size is 0?", 0, bikePartList.size());
	}

	@Test
	public void testAddBike() {
		assertNotNull("Check if there is valid Bike arraylist to add to", bikeList);
		C206_CaseStudy.addBike(bikeList, b1);
		assertEquals("Check that Bike arraylist size is 1", 1, bikeList.size());

		C206_CaseStudy.addBike(bikeList, b2);
		assertEquals("Check that Bike arraylist size is 2", 2, bikeList.size());
		assertSame("Check that Bike is added", b2, bikeList.get(1));
	}

	@Test
	public void testDeleteBike() {
		assertNotNull("Test if there is a valid Bike arraylist to delete from", bikeList);

		// After adding 1 item, test if the size of the list is 1
		C206_CaseStudy.addBike(bikeList, b1);
		assertEquals("Test if that Bike arraylist size is 1?", 1, bikeList.size());

		// Delete the item, and test if the size of the list is 0
		C206_CaseStudy.deleteBike(bikeList); // Requires user input in console
		assertEquals("Test if that Bike arraylist size is 0?", 0, bikeList.size());

	}

	@Test
	public void testViewBike() {
		// Item list is not null, so that we can add a new item
		assertNotNull("Test if there is a valid Bike arraylist to add to", bikeList);

		// Test if the list of buyer retrieved from the BikersPortal is empty
		assertEquals("Check that bikelist is empty at the start", 0, bikeList.size());

		// Given an empty list, after adding 3 items, test if the size of the list is 3
		C206_CaseStudy.addBike(bikeList, b1);
		C206_CaseStudy.addBike(bikeList, b2);
		C206_CaseStudy.addBike(bikeList, b3);
		assertEquals("Test if that Bike arraylist size is 3?", 3, bikeList.size());
	}

	@After
	public void tearDown() throws Exception {
		bikeList = null;
		bikePartList = null;
		feedbackList = null;

		b1 = null;
		b2 = null;
		b3 = null;

		bp1 = null;
		bp2 = null;
		bp3 = null;

		fb1 = null;
		fb2 = null;
		fb3 = null;

	}
}
