import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTestAppointment {
	private Appointment appt1;
	private Appointment appt2;
	private Appointment appt3;

	private ArrayList<Appointment> appointmentList;

	public C206_CaseStudyTestAppointment() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		appt1 = new Appointment("A1", "2022-10-25");
		appt2 = new Appointment("A2", "2023-4-10");
		appt3 = new Appointment("A3", "2024-9-16");
		appointmentList = new ArrayList<Appointment>();

	}

	@Test

	public void testaddAppointment() {
		assertNotNull("Test if there is a valid appointment arraylist to add to", appointmentList);

		C206_CaseStudy.addAppointment(appointmentList, appt1);
		assertEquals("Test if that Appointment arraylist size is 1?", 1, appointmentList.size());

		assertSame("Test that the Appointment added is the same as the 1st item of the list?", appt1,
				appointmentList.get(0));

		C206_CaseStudy.addAppointment(appointmentList, appt2);
		C206_CaseStudy.addAppointment(appointmentList, appt3);
		assertEquals("Test that Appointment arraylist size is 3?", 3, appointmentList.size());
		assertSame("Test that the Appointment last added is the same as 3rd item of the list?", appt3,
				appointmentList.get(2));
	}


	@Test
	public void testdoView() {
		assertNotNull("Test if there is a valid appointment arraylist to add to", appointmentList);

		assertEquals("Check that appointmentList is empty at the start", 0, appointmentList.size());

		C206_CaseStudy.addAppointment(appointmentList, appt1);
		C206_CaseStudy.addAppointment(appointmentList, appt2);
		C206_CaseStudy.addAppointment(appointmentList, appt3);

		assertEquals("Test if that appointment arraylist size is 3?", 3, appointmentList.size());
	}

	@Test
	public void testdoDelete() {
		assertNotNull("Test if there is a valid appointment arraylist to delete from", appointmentList);
		C206_CaseStudy.addAppointment(appointmentList, appt1);
		assertEquals("Test if that appointment arraylist size is 1?", 1, appointmentList.size());

		C206_CaseStudy.doDelete(appointmentList);
		assertEquals("Test if that appointment arraylist size is 0?", 0, appointmentList.size());

	}

	@After
	public void tearDown() throws Exception {
		appt1 = null;
		appt2 = null;
		appt3 = null;

		appointmentList = null;
	}

}
