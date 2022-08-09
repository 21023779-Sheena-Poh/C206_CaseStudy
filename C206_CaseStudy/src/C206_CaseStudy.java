import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		ArrayList<Bike> bikeList = new ArrayList<Bike>();
		ArrayList<BikePart> bikePartList = new ArrayList<BikePart>();
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
		// customer arraylist - arjun
		
		bikeList.add(new Bike("B1", "Slick Road Bike", 160.00, "Red"));
		bikeList.add(new Bike("B2", "Giant Mountain Bike", 220.50, "Blue"));
		bikeList.add(new Bike("B3", "Trek Folding Bike", 190.90, "Yellow"));

		bikePartList.add(new BikePart("BP1", "Leather Seat", 85.90, "bike seat"));
		bikePartList.add(new BikePart("BP2", "Off Road Tyres", 150.80, "bike tyre"));
		bikePartList.add(new BikePart("BP3", "Timber Handlebar", 90.00, "bike handle"));

		appointmentList.add(new Appointment("A1", "2022-10-25"));
		appointmentList.add(new Appointment("A2", "2023-4-10"));
		appointmentList.add(new Appointment("A3", "2024-9-16"));

		feedbackList.add(new Feedback("F123", "bad quality"));
		feedbackList.add(new Feedback("F124", "item recieved on time"));
		feedbackList.add(new Feedback("F125", "item not packed properly"));

		int option = 0;
		while (option != 5) {
			mainMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				bikemenu();
				int bikeoption = Helper.readInt("Enter an option > ");
				if (bikeoption == 1) {
					System.out.println(viewAllBikes(bikeList));
					viewAllBikeParts(bikePartList);
				} else if (bikeoption == 2) {
					int itemchoice = bikeitem();

					if (itemchoice == 1) {
						Bike newBike = bikeadded();
						addBike(bikeList, newBike);
					} else if (itemchoice == 2) {
						BikePart newBikePart = BikePartadded();
						addBikePart(bikePartList, newBikePart);
					} else {
						System.out.println("invalid option");
					}
				} else if (bikeoption == 3) {
					int itemchoice = bikeitem();

					if (itemchoice == 1) {
						viewAllBikes(bikeList);
						updateBike(bikeList);
					} else if (itemchoice == 2) {
						viewAllBikeParts(bikePartList);
						updateBikePart(bikePartList);
					} else {
						System.out.println("invalid option");
					}
				} else if (bikeoption == 4) {
					int itemchoice = bikeitem();

					if (itemchoice == 1) {
						viewAllBikes(bikeList);
						deleteBike(bikeList);
					} else if (itemchoice == 2) {
						viewAllBikeParts(bikePartList);
						deleteBikePart(bikePartList);
					}
				} else {
					System.out.println("invalid option");
				}
			}

		    else if (option == 2) { // customer menu - arjun
		    	
		    }
		 
			else if (option == 3) {
				Helper.line(80, "=");
				System.out.println("Manage Appointment");
				Helper.line(80, "=");
				System.out.println("1. View Appointment");
				System.out.println("2. Add Appointment");
				System.out.println("3. Delete Appointment");
				int optionA = Helper.readInt("Enter an option > ");

				if (optionA == 1) {
					doView(appointmentList);
				} else if (optionA == 2) {
					Appointment newAppointment=inputAppointment();
					C206_CaseStudy.addAppointment(appointmentList, newAppointment);
				} else if (optionA == 3) {
					doDelete(appointmentList);
				
				} else {
					System.out.println("Invalid option.");
				}
					
			} else if (option == 4) {
				menu();
				int fboption = Helper.readInt("Enter an option > ");
				if (fboption == 1) {
					viewFeedback(feedbackList);
				} else if (fboption == 2) {
					Feedback newFeedback = recordFeedback();
					addFeedback(feedbackList, newFeedback);
				} else if (fboption == 3) {
					viewFeedback(feedbackList);
					updateFeedbackStatus(feedbackList);
				} else if (fboption == 4) {
					deleteFeedback(feedbackList);
				}
			} else if (option == 5) {
				System.out.println("Thank you for using BIKE LOVER'S COMMUNITY (BLC).");
			} else {
				System.out.println("Invalid option");
			}
		}
	}

	private static void bikemenu() {
		Helper.line(80, "=");
		System.out.println("Manage bikes");
		Helper.line(80, "=");
		System.out.println("1. View Bike Item");
		System.out.println("2. Add Item");
		System.out.println("3. Update Details");
		System.out.println("4. Delete Item");

	}

	private static void menu() {
		Helper.line(80, "=");
		System.out.println("Manage Feedback");
		Helper.line(80, "=");
		System.out.println("1. View Feedback");
		System.out.println("2. Record Feedback");
		System.out.println("3. Update Feedback Status");
		System.out.println("4. Delete Feedback");
	}

	public static Bike bikeadded() {
		String id = Helper.readString("Enter id > ");
		String name = Helper.readString("Enter name > ");
		double price = Helper.readDouble("Enter price > ");
		String colour = Helper.readString("Enter colour > ");

		Bike Bikeadd = new Bike(id, name, price, colour);
		return Bikeadd;
	}

	public static void addBike(ArrayList<Bike> bikeList, Bike Bikeadd) {
		bikeList.add(Bikeadd);
		System.out.println("A new bike is added successfully");
	}

	public static BikePart BikePartadded() {
		String id = Helper.readString("Enter id > ");
		String name = Helper.readString("Enter name > ");
		double price = Helper.readDouble("Enter price > ");
		String component = Helper.readString("Enter component > ");

		BikePart BikePartadd = new BikePart(id, name, price, component);
		return BikePartadd;
	}

	public static void addBikePart(ArrayList<BikePart> bikePartList, BikePart BikePartadd) {
		bikePartList.add(BikePartadd);
		System.out.println("A new bike part is added successfully");
	}

	public static String viewAllBikes(ArrayList<Bike> bikeList) {
		Helper.line(80, "=");
		System.out.println("LIST OF BIKES");
		Helper.line(80, "=");
		String output = String.format("%-5s %-25s %-10s %-15s %-15s\n", "ID", "NAME", "PRICE", "AVAILABLE", "COLOUR");

		for (int i = 0; i < bikeList.size(); i++) {

			output += String.format("%-5s %-25s %-10s %-15s %-15s\n", bikeList.get(i).getId(), bikeList.get(i).getName(),
					bikeList.get(i).getPrice(), showAvailability(bikeList.get(i).getAvailable()),
					bikeList.get(i).getColour());
		}
		return output;
	}

	public static void viewAllBikeParts(ArrayList<BikePart> bikePartList) {
		Helper.line(80, "=");
		System.out.println("LIST OF BIKE PARTS");
		Helper.line(80, "=");
		String output = String.format("%-5s %-30s %-10s %-15s %s\n", "ID", "NAME", "PRICE", "AVAILABLE", "COMPONENT");

		for (int i = 0; i < bikePartList.size(); i++) {

			output += String.format("%-5s %-30s %-10s %-15s %s\n", bikePartList.get(i).getId(),
					bikePartList.get(i).getName(), bikePartList.get(i).getPrice(),
					showAvailability(bikePartList.get(i).getAvailable()), bikePartList.get(i).getComponent());
		}
		System.out.println(output);
	}

	public static void updateBike(ArrayList<Bike> bikeList) {
		String id = Helper.readString("Enter id > ");
		String name = Helper.readString("Enter name > ");
		double price = Helper.readDouble("Enter price > ");
		String available = Helper.readString("Enter if item is available > ");
		String colour = Helper.readString("Enter colour > ");

		for (int i = 0; i < bikeList.size(); i++) {
			if (bikeList.get(i).getId().equals(id)) {
				bikeList.get(i).setName(name);
				bikeList.get(i).setPrice(price);
				if (available.equalsIgnoreCase("yes")) {
					bikeList.get(i).setAvailable(true);
				} else {
					if (available.equalsIgnoreCase("no")) {
						bikeList.get(i).setAvailable(false);
					}
				}
				bikeList.get(i).setColour(colour);
			}
		}
		System.out.println("Bike List Updated");

	}

	public static void updateBikePart(ArrayList<BikePart> bikePartList) {
		String id = Helper.readString("enter id to update > ");
		String name = Helper.readString("enter name to update > ");
		double price = Helper.readDouble("enter price to update > ");
		String available = Helper.readString("Enter if item is available > ");
		String component = Helper.readString("Enter component > ");

		for (int i = 0; i < bikePartList.size(); i++) {
			if (bikePartList.get(i).getId().equals(id)) {
				bikePartList.get(i).setName(name);
				bikePartList.get(i).setPrice(price);
				if (available.equalsIgnoreCase("yes")) {
					bikePartList.get(i).setAvailable(true);
				} else {
					if (available.equalsIgnoreCase("no")) {
						bikePartList.get(i).setAvailable(false);
					}
				}
				bikePartList.get(i).setComponent(component);
			}
		}
		System.out.println("Bike Part List Updated!");

	}

	public static void deleteBike(ArrayList<Bike> bikeList) {
		String id = Helper.readString("Enter id to delete > ");

		for (int i = 0; i < bikeList.size(); i++) {
			if (bikeList.get(i).getId().equals(id)) {
				String delete = Helper.readString("Are you sure you want to delete " + id);
				if (delete.equalsIgnoreCase("yes")) {
					bikeList.remove(i);
					System.out.println(id + " has been deleted.");
				} else {

					System.out.println(id + " has not been deleted");
				}
			}
		}
		

	}

	public static void deleteBikePart(ArrayList<BikePart> bikePartList) {
		String id = Helper.readString("Enter id to delete > ");

		for (int i = 0; i < bikePartList.size(); i++) {
			if (bikePartList.get(i).getId().equals(id)) {
				String delete = Helper.readString("Are you sure you want to delete " + id);
				if (delete.equalsIgnoreCase("yes")) {
					bikePartList.remove(i);
					System.out.println(id + " has been deleted.");
				} else {

					System.out.println(id + " has not been deleted");
				}
			}
		}

	}

	// customer create, view, delete - arjun
	
	
	public static String retrieveAllAppointment(ArrayList<Appointment> appointmentList) {
		String output="";
		for (int i = 0; i < appointmentList.size(); i++) {
			String id=appointmentList.get(i).getID();
			String apptDate=appointmentList.get(i).getApptDate();
			output += String.format("%-5s %-10s\n", appointmentList.get(i).getID(),
					appointmentList.get(i).getApptDate());
			
		}
		return output;
	}
	public static void doView(ArrayList<Appointment> appointmentList) {

		String output = String.format("%-5s %-10s\n", "ID", "APPOINTMENT DATE");
		output+=retrieveAllAppointment(appointmentList);
		System.out.println(output);
	}

	public static Appointment inputAppointment() {
		String id = Helper.readString("Enter ID > ");
		String appointmentDate = Helper.readString("Enter Appointment Date(yyyy-mm-dd) > ");
		Appointment newAppointment = new Appointment(id, appointmentDate);
		return newAppointment;
	}

	public static void addAppointment(ArrayList<Appointment> appointmentList, Appointment newAppointment) {
		appointmentList.add(newAppointment);

	}
	public static void doDelete(ArrayList<Appointment> appointmentList) {
		String id = Helper.readString("Enter Appointment ID > ");
		for (int i = 0; i < appointmentList.size(); i++) {
			if (appointmentList.get(i).getID().equals(id)) {
				appointmentList.remove(i);
				System.out.println("Deleted Successfully!");
			} else {
				System.out.println("Invalid Appointment ID");
			}
		}
	}

	public static Feedback recordFeedback() {
		String id = Helper.readString("Enter id > ");
		String feedback = Helper.readString("Enter feedback > ");

		Feedback newFeedback = new Feedback(id, feedback);
		return newFeedback;
	}

	public static void addFeedback(ArrayList<Feedback> feedbackList, Feedback newFeedback) {
		feedbackList.add(newFeedback);
		System.out.println("New feedback added!");
	}

	public static void viewFeedback(ArrayList<Feedback> feedbackList) {
		System.out.println("FEEDBACKS > ");
		String output = String.format("%-5s %-10s %-50s\n", "ID", "STATUS", "FEEDBACK");

		for (int i = 0; i < feedbackList.size(); i++) {

			output += String.format("%-5s %-10s %-50s\n", feedbackList.get(i).getId(), feedbackList.get(i).getStatus(),
					feedbackList.get(i).getFeedback());
		}
		System.out.println(output);
	}

	public static void updateFeedbackStatus(ArrayList<Feedback> feedbackList) {
		String id = Helper.readString("Enter id > ");
		boolean isSolved = false;
		for (int i = 0; i < feedbackList.size(); i++) {
			if (feedbackList.get(i).getId().equals(id)) {
				isSolved = false;
			}
		}

		if (isSolved == false) {
			char status = Helper.readChar("Enter status > ");

			for (int i = 0; i < feedbackList.size(); i++) {
				if (feedbackList.get(i).getId().equals(id)) {
					if (Character.toUpperCase(status) == 'S') {
						feedbackList.get(i).setStatus("Solved");
					} else {
						feedbackList.get(i).setStatus("Pending");
					}
				}
			}
			System.out.println("Feedback List updated!");
		} else {
			System.out.println("ID ENTERED NOT FOUND");
		}
	}

	public static void deleteFeedback(ArrayList<Feedback> feedbackList) {
		String id = Helper.readString("Enter id to delete > ");
		for (int i = 0; i < feedbackList.size(); i++) {
			if (feedbackList.get(i).getId().equals(id)) {
				String deleted = Helper.readString("Are you sure you want to delete record " + id + " > ");
				if (deleted.equalsIgnoreCase("yes")) {
					feedbackList.remove(i);
					System.out.println(id + " has been deleted.");
				} else {

					System.out.println(id + " cannot be deleted");
				}
			}
		}
	}

	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}

	private static void mainMenu() {
		Helper.line(80, "=");
		System.out.println("BIKE LOVER'S COMMUNITY (BLC)");
		Helper.line(80, "=");
		System.out.println("1. Manage Bikes and Bike Parts Listings");
		System.out.println("2. Manage Customers");
		System.out.println("3. Manage Appointments");
		System.out.println("4. Manage Feedback");
		System.out.println("5. Quit");
		Helper.line(80, "=");
	}

	public static int bikeitem() {
		Helper.line(80, "=");
		System.out.println("ENTER BIKE OR BIKE PARTS");
		Helper.line(80, "=");
		System.out.println("1. Bike listing");
		System.out.println("2. Bike Part listing");
		int itemchoice = Helper.readInt("Enter item choice > ");
		return itemchoice;
	}

}


