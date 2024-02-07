
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Single singleRoom = new Single();
		Double doubleRoom = new Double();
		Club clubRoom = new Club();
		Family familyRoom = new Family();
		FamilyView familyViewRoom = new FamilyView();
		Suite suiteRoom = new Suite();

		List<Service> services = new ArrayList<Service>();

		int option;

		while (true) {
			int order = 0;
			for (MenuOptions select : MenuOptions.values()) {
				System.out.println((++order) + ". " + select.getSelection());
			}

			option = input.nextInt();
			input.nextLine();
			int selectedIndex = option - 1;
			if (selectedIndex < 0 || selectedIndex >= MenuOptions.values().length) {
				System.out.println("Invalid input");
				System.out.println("\n");
				continue;
			}
			System.out.println("\n");

			MenuOptions menuOptions = MenuOptions.values()[selectedIndex];
			ArrayList<Room> roomTypesList = new ArrayList<>(
					Arrays.asList(singleRoom, doubleRoom, clubRoom, familyRoom, familyViewRoom, suiteRoom));

			switch (menuOptions) {

			case A:
				System.out.println("ROOM INFOS:\n\n");
				for (Room room : roomTypesList) {
					System.out.println(room);
				}
				System.out.println("\n");
				System.out.print("Hotel Name: ");

				String hotelName = input.nextLine();

				ArrayList<String> roomTypes = new ArrayList<>(
						Arrays.asList("Single", "Double", "Club", "Family", "Family with View", "Suite"));
				boolean validRoomType = false;
				String roomTypeOption = null;

				while (!validRoomType) {
					System.out.print("Room Type: ");
					roomTypeOption = input.nextLine();

					for (String roomType : roomTypes) {
						if (roomType.equals(roomTypeOption)) {
							validRoomType = true;
							break;
						}
					}
					if (!validRoomType) {
						System.out.println("Invalid Input");
					}
				}
				boolean isValidMonth = false;
				String reservationMonth = null;

				while (!isValidMonth) {
					System.out.print("Reservation Month: ");
					reservationMonth = input.nextLine();

					for (Month month : Month.values()) {
						if (month.getSelection().equals(reservationMonth)) {
							isValidMonth = true;
							break;
						}
					}
					if (!isValidMonth) {
						System.out.println("Invalid input");
					}
				}
				int reservationStart = 0;
				while (reservationStart <= 0 || reservationStart > 30) {
					System.out.print("Reservation Start (1-30): ");
					reservationStart = input.nextInt();
					if (reservationStart <= 0 || reservationStart > 30) {
						System.out.println("Invalid start day. Please enter a day between 1-30.");
					}
				}
				int reservationEnd = 0;
				while (reservationEnd <= 0 || reservationEnd > 30 || reservationEnd < reservationStart) {
					System.out.print("Reservation End (" + reservationStart + "-30): ");
					reservationEnd = input.nextInt();
					if (reservationEnd <= 0 || reservationEnd > 30) {
						System.out.println("Invalid end day. Please enter a day between " + reservationStart + "-30.");
					} else if (reservationEnd < reservationStart) {
						System.out.println("Invalid end day. End day must be greater than or equal to the start day.");
					}
				}

				Room room = null;
				for (String roomType : roomTypes) {
					if (roomTypeOption.equals(roomType)) {

						switch (roomType) {
						case "Single":
							room = singleRoom;
							break;
						case "Double":
							room = doubleRoom;
							break;
						case "Club":
							room = clubRoom;
							break;
						case "Family":
							room = familyRoom;
							break;
						case "Family with View":
							room = familyViewRoom;
							break;
						case "Suite":
							room = suiteRoom;
							break;
						}
						break;
					}
				}

				Reservation reservationList = new Reservation(hotelName, reservationMonth, reservationStart,
						reservationEnd, room);

				services.add(reservationList);
				reservationList.setCustomerID(Reservation.getReservationID());

				System.out.println("\nReservation ID: " + Reservation.getReservationID() + " is created!\n");

				break;

			case B:

				for (Service reserved : services) {
					if (reserved instanceof Reservation) {
						Reservation reservationInfos = (Reservation) reserved;
						System.out.println("Reservation for a " + reservationInfos.getRoom().getType() + " room in "
								+ reservationInfos.getHotelName() + " starts on "
								+ reservationInfos.getReservationMonth() + " " + reservationInfos.getReservationStart()
								+ " and ends on " + reservationInfos.getReservationEnd() + ".");
						System.out.println(
								"Reservation has a total cost of $" + (int) reservationInfos.calculateService() + ".");
						System.out.println("\n");
					}
				}
				break;

			case C:
				int numOfReservations = Reservation.getReservationID();
				if (numOfReservations == 0) {
					System.out.println("There are no reservations yet. Please try again later.\n");
					break;
				}

				System.out.print("Type a city name for a reservation search: ");
				String city = input.nextLine();

				boolean foundReservation = false;
				System.out.println("Reservations for " + city + ":");
				for (Service service : services) {
					if (service instanceof Reservation) {
						Reservation reservationCity = (Reservation) service;
						if (reservationCity.getHotelName().contains(city)) {
							System.out.println(reservationCity.getHotelName());
							foundReservation = true;
						}
					}
				}

				if (!foundReservation) {
					System.out.println("No reservations found for the specified city.\n");
				}
				System.out.println("\n");
				break;

			case D:
				int serviceType = 0;
				boolean isValidChoose = false;
				while (!isValidChoose) {
					System.out.println("Please select one of the extra services from below: ");
					System.out.println("1. Laundry");
					System.out.println("2. Spa");

					serviceType = input.nextInt();
					if (serviceType == 1 || serviceType == 2) {
						isValidChoose = true;
					} else {
						System.out.println("Invalid service type!");
						System.out.println("\n");
						continue;
					}
				}
				System.out.print("\nType the reservation ID to credit this service: \n");
				int customerID = input.nextInt();
				System.out.println();
				boolean roomReserved = false;
				if (customerID <= Reservation.getReservationID()) {
					roomReserved = true;

				}
				if (!roomReserved) {
					System.out.println("Cannot add laundry or spa service before reserving a room!\n");

					break;
				}

				if (serviceType == 1) {
					System.out.print("How many pieces of clothing? \n");
					int numItems = input.nextInt();

					Laundry laundry = new Laundry();
					laundry.setCustomerID(customerID);
					laundry.setNumItems(numItems);
					services.add(laundry);
					System.out.println("Laundry service added successfully!\n");

				} else if (serviceType == 2) {
					System.out.print("How many Days? ");
					int duration = input.nextInt();

					Spa spa = new Spa();
					spa.setCustomerID(customerID);
					spa.setDuration(duration);
					services.add(spa);
					System.out.println("Spa service added successfully!");
					System.out.println("\n");
				}
				break;

			case E:

				for (Service service : services) {
					if (service instanceof Reservation) {
						Reservation reservationRoom = (Reservation) service;

						System.out.println("The cost for the " + reservationRoom.getServicetype() + " service of reservation ID "
								+ reservationRoom.getCustomerID() + ": " + reservationRoom.calculateService());
					} else if (service instanceof Spa) {
						Spa spa = (Spa) service;
						System.out.println("The cost for the " + spa.getServicetype() + " service of customer ID " + spa.getCustomerID() + ": "
								+ spa.calculateService());
					} else if (service instanceof Laundry) {
						Laundry laundry = (Laundry) service;
						System.out.println("The cost for the " + laundry.getServicetype() + " service of customer ID " + laundry.getCustomerID()
								+ ": " + laundry.calculateService());

					}
				}
				System.out.println();
				break;

			case F:

				int numCustomers = Reservation.getReservationID();
				double totalCostCustomer = 0;
				for (int i = 1; i <= numCustomers; i++) {
					for (Service service : services) {
						if (service instanceof Reservation) {
							Reservation reservation = (Reservation) service;
							if (reservation.getCustomerID() == i) {
								totalCostCustomer += reservation.calculateService();
							}
						} else if (service instanceof Laundry) {
							Laundry laundry = (Laundry) service;
							if (laundry.getCustomerID() == i) {
								totalCostCustomer += laundry.calculateService();
							}
						} else if (service instanceof Spa) {
							Spa spa = (Spa) service;
							if (spa.getCustomerID() == i) {
								totalCostCustomer += spa.calculateService();
							}
						}
					}
					System.out.println(
							"The total cost of all services for customer ID " + i + " is $" + totalCostCustomer);
					totalCostCustomer = 0;
				}
				System.out.println();

				break;

			case G:
				System.out.println("Goodbye");
				input.close();
				return;

			default:
				System.out.println("Invalid input");
				System.out.println("\n");
				break;
			}
		}
	}
}
